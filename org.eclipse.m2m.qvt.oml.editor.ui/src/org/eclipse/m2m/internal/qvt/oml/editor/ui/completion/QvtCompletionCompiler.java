/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 391289
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParser;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.IKeywordHandler;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.KeywordHandlerRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.lpg.AbstractLexer;

/**
 * @author aigdalov
 * Created on Oct 30, 2007
 */
public class QvtCompletionCompiler extends QVTOCompiler {
    private final QvtCompletionData myData;
    private final Map<URI, CFileData> myCFileDataMap = new LinkedHashMap<URI, CFileData>();
    private QvtOperationalEnv myEnvironment;

    public QvtCompletionCompiler(IMetamodelRegistryProvider metamodelProvider, QvtCompletionData data) {
        super(metamodelProvider);
        myData = data;
    }
    
    public Map<URI, CFileData> getCFileDataMap() {
        return myCFileDataMap;
    }

    public AbstractLexer createLexer(UnitProxy unit) throws IOException, ParserException, BadLocationException {
        CFileData cFileData = getCFileData(unit.getURI());
        if (cFileData.getLexer() != null) {
            return cFileData.getLexer();
        }
        Reader reader = createReader(unit);
        
		QVTOLexer lexer = new QVTOLexer(new QvtOperationalEnvFactory(
				getEPackageRegistry(unit.getURI())).createEnvironment(unit.getURI()));
        
        cFileData.setLexer(lexer);
        try {
            lexer.reset(new OCLInput(reader).getContent(), unit.getURI().lastSegment());
            QVTOParser qvtoParser = new QVTOParser(lexer);
            lexer.lexer(qvtoParser.getIPrsStream());
            cFileData.setParser(qvtoParser);
        } finally {
            reader.close();
        }
        return lexer;    
    }

    @Override
    protected Reader createReader(UnitProxy source) throws IOException {
      if (source.getURI().equals(myData.getCFile().getURI())) {
    	  String documentText = myData.getDocument().get();
    	  return new StringReader(documentText);
      }
    	
      return super.createReader(source);
    }
    
    public QvtOperationalEnv compileAll() {
        if (myEnvironment == null) {
            URI uri = this.myData.getCFile().getURI();
			myEnvironment = new QvtOperationalEnvFactory(getEPackageRegistry(uri)).createEnvironment(uri);

            QvtCompilerOptions options = new QvtCompilerOptions();
            options.setReportErrors(false);
            options.setShowAnnotations(false);
            options.setSourceLineNumbersEnabled(false);

            try {
                compile(myData.getCFile(), options, null);
            } catch (MdaException ex) {
              Activator.log(ex);
            }
        }
        return myEnvironment;
    }
    
    @Override
    protected QvtOperationalVisitorCS createAnalyzer(AbstractQVTParser parser, QvtCompilerOptions options, Monitor monitor) {
		return new QvtCompletionVisitorCS(parser, options, monitor) {
			@Override
			protected void setEnv(QvtOperationalEnv env) {			
				super.setEnv(env);
				myEnvironment = env;
			}
		};
    }

    @Override
    protected CSTParseResult parse(UnitProxy source, QvtCompilerOptions options) throws ParserException {
     	CFileData cFileData = compile(source);
		AbstractQVTParser qvtParser = cFileData.getParser();

    	UnitCS unitCS = cFileData.getUnitCS();
    	
    	QvtOperationalFileEnv env = (QvtOperationalFileEnv)cFileData.getLexer().getEnvironment();
    	CSTParseResult result = new CSTParseResult();
    	result.unitCS = unitCS;
    	result.env = env;
    	result.parser = qvtParser;
    	return result;
    }
    
    
    private CFileData compile(UnitProxy cFile) {
        CFileData cFileData = getCFileData(cFile.getURI());
        try {
            AbstractLexer lexer = createLexer(cFile);
            IPrsStream prsStream = lexer.getILexStream().getIPrsStream();
            IKeywordHandler[] keywordHandlers = KeywordHandlerRegistry.getInstance().getKeywordHandlers();
            StringBuilder lightweightScriptBuilder = new StringBuilder(lexer.getILexStream().getStreamLength());
            for (int i = 0, n = prsStream.getSize(); i < n; i++) {
                IToken token = prsStream.getTokenAt(i);
                for (IKeywordHandler keywordHandler : keywordHandlers) {
                    String contribution = keywordHandler.handle(token, prsStream, myData, cFileData);
                    if (contribution != null) {
                        int offsetDelta = token.getStartOffset() - lightweightScriptBuilder.length();
                        for (int j = 0; j < offsetDelta - 1; j++) {
                            lightweightScriptBuilder.append(' ');
                        }
                        lightweightScriptBuilder.append(contribution);
                        break;
                    }
                }
            }
            String lightweightScript = lightweightScriptBuilder.toString();
            cFileData.setLightweightScript(lightweightScript);
            CSTNode cstNode = LightweightParserUtil.parse(lightweightScript, cFile, LightweightParserUtil.ParserTypeEnum.LIGHTWEIGHT_PARSER);

            cFileData.setUnitCS((UnitCS)cstNode);            
        } catch (Exception ex) {
            Activator.log(ex);
        }
        return cFileData;
    }
    
    public CFileData getCFileData(URI unitURI) {
        CFileData cFileData = myCFileDataMap.get(unitURI);
        if (cFileData == null) {
            cFileData = new CFileData();
            myCFileDataMap.put(unitURI, cFileData);        
        }
        return cFileData;
    }
    
    public CFileData getCFileData(MappingModuleCS mappingModuleCS) {
        for (CFileData cFileData : myCFileDataMap.values()) {
        	UnitCS unitCS = cFileData.getUnitCS();
        	if(unitCS != null && unitCS.getModules().contains(mappingModuleCS)) {
                return cFileData;
            }
        }
        return null;
    }
}