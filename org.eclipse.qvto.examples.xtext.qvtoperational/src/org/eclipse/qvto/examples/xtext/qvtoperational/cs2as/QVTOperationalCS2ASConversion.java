package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.tx.CS2ASTransformer;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.NewCS2AS;
import org.eclipse.qvto.examples.xtext.qvtoperational.cs2as._QVTOperationalCS2AS_qvtp_qvtias.QVTOperationalCS2AS_qvtp_qvtias;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

public class QVTOperationalCS2ASConversion extends NewCS2AS {
	
	public QVTOperationalCS2ASConversion(CS2AS converter, IDiagnosticConsumer diagnosticsConsumer) {
		super(converter, diagnosticsConsumer);
	}

	@Override
	protected Class<? extends CS2ASTransformer> getCS2ASTxClass() {
		//return AbstractCS2ASTransformer.class;
		return QVTOperationalCS2AS_qvtp_qvtias.class;
	}
}
