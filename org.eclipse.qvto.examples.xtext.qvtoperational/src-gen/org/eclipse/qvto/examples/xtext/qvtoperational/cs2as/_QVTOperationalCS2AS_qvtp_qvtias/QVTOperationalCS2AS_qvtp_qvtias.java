/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as._QVTOperationalCS2AS_qvtp_qvtias;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.lookup.QVTOperationalLookupVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.cs2as.SingleResultLookupEnvironment;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToLibraryCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS;

/**
 * The QVTOperationalCS2AS_qvtp_qvtias transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootObjects(String)}
 */
@SuppressWarnings("nls")
public class QVTOperationalCS2AS_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/BaseCS", null, BaseCSPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperational", null, QVTOperationalPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS", null, QVTOperationalCSPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ClassCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("ClassCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ClassifierPropertyCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("ClassifierPropertyCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_$metamodel$.getClassId("Element", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Library = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Library", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingOperationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("MappingOperationCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MetamodelCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("MetamodelCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Model = PACKid_$metamodel$.getClassId("Model", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModelParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModelType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelTypeCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("ModelTypeCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModuleCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("ModuleCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_$metamodel$.getClassId("NamedElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("OperationCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("OperationalTransformation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("PackageCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ParameterCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("ParameterCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ParameterDeclarationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("ParameterDeclarationCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PathElement2CS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("PathElement2CS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PathName2CS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("PathName2CS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_QVToClassCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("QVToClassCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_QVToLibraryCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("QVToLibraryCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_StructuralFeatureCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("StructuralFeatureCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TopLevelCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("TopLevelCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TransformationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("TransformationCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TypeCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("TypeCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TypedRefCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_BaseCS.getClassId("TypedRefCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TypedTypeRef2CS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("TypedTypeRef2CS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_VarParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("VarParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Visitable = PACKid_$metamodel$.getClassId("Visitable", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING);
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_ = "";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_abstract = "abstract";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_blackbox = "blackbox";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_composite = "composite";
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ParameterCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ParameterCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PathElement2CS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElement2CS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_StructuralFeatureCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_StructuralFeatureCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TypeCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_TypeCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_ownedClasses = CLSSid_Package.getPropertyId("ownedClasses");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Element = TypeId.SEQUENCE.getSpecializedId(CLSSid_Element);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_ModelParameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_ModelParameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_ModelType = TypeId.SEQUENCE.getSpecializedId(CLSSid_ModelType);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassifierPropertyCS = TypeId.SET.getSpecializedId(CLSSid_ClassifierPropertyCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_MappingOperationCS = TypeId.SET.getSpecializedId(CLSSid_MappingOperationCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_MetamodelCS = TypeId.SET.getSpecializedId(CLSSid_MetamodelCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ModelTypeCS = TypeId.SET.getSpecializedId(CLSSid_ModelTypeCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ParameterDeclarationCS = TypeId.SET.getSpecializedId(CLSSid_ParameterDeclarationCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_QVToClassCS = TypeId.SET.getSpecializedId(CLSSid_QVToClassCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_QVToLibraryCS = TypeId.SET.getSpecializedId(CLSSid_QVToLibraryCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TopLevelCS = TypeId.SET.getSpecializedId(CLSSid_TopLevelCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TransformationCS = TypeId.SET.getSpecializedId(CLSSid_TransformationCS);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_ClassifierPropertyCS,    // 0 => ClassifierPropertyCS
        CLSSid_MappingOperationCS,      // 1 => MappingOperationCS
        CLSSid_MetamodelCS,             // 2 => MetamodelCS
        CLSSid_ModelTypeCS,             // 3 => ModelTypeCS
        CLSSid_ParameterDeclarationCS,  // 4 => ParameterDeclarationCS
        CLSSid_QVToClassCS,             // 5 => QVToClassCS
        CLSSid_QVToLibraryCS,           // 6 => QVToLibraryCS
        CLSSid_TopLevelCS,              // 7 => TopLevelCS
        CLSSid_TransformationCS         // 8 => TransformationCS
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static /*@NonNull*/ int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : ClassifierPropertyCS -> {ClassifierPropertyCS}
        {1},                    // 1 : MappingOperationCS -> {MappingOperationCS}
        {2},                    // 2 : MetamodelCS -> {MetamodelCS}
        {3},                    // 3 : ModelTypeCS -> {ModelTypeCS}
        {4},                    // 4 : ParameterDeclarationCS -> {ParameterDeclarationCS}
        {5},                    // 5 : QVToClassCS -> {QVToClassCS}
        {6},                    // 6 : QVToLibraryCS -> {QVToLibraryCS}
        {7},                    // 7 : TopLevelCS -> {TopLevelCS}
        {8}                     // 8 : TransformationCS -> {TransformationCS}
    };
    
    
    public QVTOperationalCS2AS_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    /**
     * 
     * map cClassifierPropertyCS_2_Property in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (classifierPropertyCS : qvtoperationalcs::ClassifierPropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize property : Property[1];
     *  |}
     * where ( |)
     * { |
     * classifierPropertyCS.pivot := property;
     * }
     * map uProperty_isComposite {
     * classifierPropertyCS := classifierPropertyCS;
     * }
     *   map uProperty_name {
     * classifierPropertyCS := classifierPropertyCS;
     * }
     */
    protected boolean MAP_cClassifierPropertyCS_2_Property(final /*@NonNull*/ /*@NonInvalid*/ ClassifierPropertyCS classifierPropertyCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Property property = PivotFactory.eINSTANCE.createProperty();
        assert property != null;
        models[1/*rightAS*/].add(property);
        // property assignments
        classifierPropertyCS.setPivot(property);
        // mapping statements
        MAP_uProperty_isComposite(classifierPropertyCS);
        MAP_uProperty_name(classifierPropertyCS);
        return true;
    }
    
    /**
     * 
     * map cMappingOperationCS_2_MappingOperation in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (mappingOperationCS : qvtoperationalcs::MappingOperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize mappingOperation : qvtoperational::MappingOperation[1];
     *  |}
     * where ( |)
     * { |
     * mappingOperationCS.pivot := mappingOperation;
     * }
     * map uMappingOperation_name {
     * mappingOperationCS := mappingOperationCS;
     * }
     */
    protected boolean MAP_cMappingOperationCS_2_MappingOperation(final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS mappingOperationCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ MappingOperation mappingOperation = QVTOperationalFactory.eINSTANCE.createMappingOperation();
        assert mappingOperation != null;
        models[1/*rightAS*/].add(mappingOperation);
        // property assignments
        mappingOperationCS.setPivot(mappingOperation);
        // mapping statements
        MAP_uMappingOperation_name(mappingOperationCS);
        return true;
    }
    
    /**
     * 
     * map cMetamodelCS_2_Package in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (metamodelCS : qvtoperationalcs::MetamodelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize package : Package[1];
     *  |}
     * where ( |)
     * { |
     * metamodelCS.pivot := package;
     * }
     * map uPackage_name {
     * metamodelCS := metamodelCS;
     * }
     *   map uPackage_nsPrefix {
     * metamodelCS := metamodelCS;
     * }
     *   map uPackage_URI {
     * metamodelCS := metamodelCS;
     * }
     */
    protected boolean MAP_cMetamodelCS_2_Package(final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS metamodelCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Package symbol_0 = PivotFactory.eINSTANCE.createPackage();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        metamodelCS.setPivot(symbol_0);
        // mapping statements
        MAP_uPackage_name(metamodelCS);
        MAP_uPackage_nsPrefix(metamodelCS);
        MAP_uPackage_URI(metamodelCS);
        return true;
    }
    
    /**
     * 
     * map cModelTypeCS_2_ModelType in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (modelTypeCS : qvtoperationalcs::ModelTypeCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize modelType : qvtoperational::ModelType[1];
     *  |}
     * where ( |)
     * { |
     * modelTypeCS.pivot := modelType;
     * }
     * map uModelType_name {
     * modelTypeCS := modelTypeCS;
     * }
     */
    protected boolean MAP_cModelTypeCS_2_ModelType(final /*@NonNull*/ /*@NonInvalid*/ ModelTypeCS modelTypeCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ ModelType modelType = QVTOperationalFactory.eINSTANCE.createModelType();
        assert modelType != null;
        models[1/*rightAS*/].add(modelType);
        // property assignments
        modelTypeCS.setPivot(modelType);
        // mapping statements
        MAP_uModelType_name(modelTypeCS);
        return true;
    }
    
    /**
     * 
     * map cParameterDeclarationCS_2_VarParameter in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (parameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize varParameter : qvtoperational::VarParameter[1];
     *  |}
     * where ( |
     * not parameterDeclarationCS.oclContainer()
     *   .oclIsKindOf(qvtoperationalcs::ModuleCS)
     *   )
     * { |
     * parameterDeclarationCS.pivot := varParameter;
     * }
     * map uVarParameter_name {
     * parameterDeclarationCS := parameterDeclarationCS;
     * }
     */
    protected boolean MAP_cParameterDeclarationCS_2_VarParameter(final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS parameterDeclarationCS) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ModuleCS_0 = idResolver.getClass(CLSSid_ModuleCS, null);
        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, parameterDeclarationCS);
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtoperationalcs_c_c_ModuleCS_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ VarParameter varParameter = QVTOperationalFactory.eINSTANCE.createVarParameter();
        assert varParameter != null;
        models[1/*rightAS*/].add(varParameter);
        // property assignments
        parameterDeclarationCS.setPivot(varParameter);
        // mapping statements
        MAP_uVarParameter_name(parameterDeclarationCS);
        return true;
    }
    
    /**
     * 
     * map cParameterDeclarationCS_2_ModelParameter in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (parameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize modelParameter : qvtoperational::ModelParameter[1];
     *  |}
     * where ( |
     * parameterDeclarationCS.oclContainer()
     *   .oclIsKindOf(qvtoperationalcs::ModuleCS)
     *   )
     * { |
     * parameterDeclarationCS.pivot := modelParameter;
     * }
     * map uModelParameter_name {
     * parameterDeclarationCS := parameterDeclarationCS;
     * }
     */
    protected boolean MAP_cParameterDeclarationCS_2_ModelParameter(final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS parameterDeclarationCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ModuleCS_0 = idResolver.getClass(CLSSid_ModuleCS, null);
        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, parameterDeclarationCS_0);
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtoperationalcs_c_c_ModuleCS_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        // creations
        final /*@Thrown*/ ModelParameter modelParameter = QVTOperationalFactory.eINSTANCE.createModelParameter();
        assert modelParameter != null;
        models[1/*rightAS*/].add(modelParameter);
        // property assignments
        parameterDeclarationCS_0.setPivot(modelParameter);
        // mapping statements
        MAP_uModelParameter_name(parameterDeclarationCS_0);
        return true;
    }
    
    /**
     * 
     * map cQVToClassCS_2_Class in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToClassCS : qvtoperationalcs::QVToClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize class : Class[1];
     *  |}
     * where ( |)
     * { |
     * qVToClassCS.pivot := class;
     * }
     * map uClass_name {
     * qVToClassCS := qVToClassCS;
     * }
     *   map uClass_ownedOperations {
     * qVToClassCS := qVToClassCS;
     * }
     *   map uClass_ownedProperties {
     * qVToClassCS := qVToClassCS;
     * }
     */
    protected boolean MAP_cQVToClassCS_2_Class(final /*@NonNull*/ /*@NonInvalid*/ QVToClassCS qVToClassCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Class symbol_0 = PivotFactory.eINSTANCE.createClass();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        qVToClassCS.setPivot(symbol_0);
        // mapping statements
        MAP_uClass_name(qVToClassCS);
        MAP_uClass_ownedOperations(qVToClassCS);
        MAP_uClass_ownedProperties(qVToClassCS);
        return true;
    }
    
    /**
     * 
     * map cQVToLibraryCS_2_Library in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToLibraryCS : qvtoperationalcs::QVToLibraryCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize library : qvtoperational::Library[1];
     *  |}
     * where ( |)
     * { |
     * qVToLibraryCS.pivot := library;
     * }
     * map uLibrary_name {
     * qVToLibraryCS := qVToLibraryCS;
     * }
     *   map uLibrary_isBlackbox {
     * qVToLibraryCS := qVToLibraryCS;
     * }
     *   map uLibrary_ownedOperations {
     * qVToLibraryCS := qVToLibraryCS;
     * }
     *   map uLibrary_usedModelType {
     * qVToLibraryCS := qVToLibraryCS;
     * }
     */
    protected boolean MAP_cQVToLibraryCS_2_Library(final /*@NonNull*/ /*@NonInvalid*/ QVToLibraryCS qVToLibraryCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Library library = QVTOperationalFactory.eINSTANCE.createLibrary();
        assert library != null;
        models[1/*rightAS*/].add(library);
        // property assignments
        qVToLibraryCS.setPivot(library);
        // mapping statements
        MAP_uLibrary_name(qVToLibraryCS);
        MAP_uLibrary_isBlackbox(qVToLibraryCS);
        MAP_uLibrary_ownedOperations(qVToLibraryCS);
        MAP_uLibrary_usedModelType(qVToLibraryCS);
        return true;
    }
    
    /**
     * 
     * map cTopLevelCS_2_Model in QVTOperationalCS2AS_qvtp_qvtias {
     * leftCS (topLevelCS : qvtoperationalcs::TopLevelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize model : Model[1];
     *  |}
     * where ( |)
     * { |
     * topLevelCS.pivot := model;
     * }
     * 
     */
    protected boolean MAP_cTopLevelCS_2_Model(final /*@NonNull*/ /*@NonInvalid*/ TopLevelCS topLevelCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ org.eclipse.ocl.pivot.Model model = PivotFactory.eINSTANCE.createModel();
        assert model != null;
        models[1/*rightAS*/].add(model);
        // property assignments
        topLevelCS.setPivot(model);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cTransformationCS_2_OperationalTransformation in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (transformationCS : qvtoperationalcs::TransformationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize operationalTransformation : qvtoperational::OperationalTransformation[1];
     *  |}
     * where ( |)
     * { |
     * transformationCS.pivot := operationalTransformation;
     * }
     * map uOperationalTransformation_isBlackbox {
     * transformationCS := transformationCS;
     * }
     *   map uOperationalTransformation_name {
     * transformationCS := transformationCS;
     * }
     *   map uOperationalTransformation_modelParameter {
     * transformationCS := transformationCS;
     * }
     *   map uOperationalTransformation_ownedOperations {
     * transformationCS := transformationCS;
     * }
     *   map uOperationalTransformation_isAbstract {
     * transformationCS := transformationCS;
     * }
     */
    protected boolean MAP_cTransformationCS_2_OperationalTransformation(final /*@NonNull*/ /*@NonInvalid*/ TransformationCS transformationCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ OperationalTransformation operationalTransformation = QVTOperationalFactory.eINSTANCE.createOperationalTransformation();
        assert operationalTransformation != null;
        models[1/*rightAS*/].add(operationalTransformation);
        // property assignments
        transformationCS.setPivot(operationalTransformation);
        // mapping statements
        MAP_uOperationalTransformation_isBlackbox(transformationCS);
        MAP_uOperationalTransformation_name(transformationCS);
        MAP_uOperationalTransformation_modelParameter(transformationCS);
        MAP_uOperationalTransformation_ownedOperations(transformationCS);
        MAP_uOperationalTransformation_isAbstract(transformationCS);
        return true;
    }
    
    /**
     * 
     * map uProperty_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (classifierPropertyCS : qvtoperationalcs::ClassifierPropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Property[1];
     * _1 : String[?];
     *  |
     * _0 := classifierPropertyCS.pivot.oclAsType(Property);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uProperty_name(final /*@NonNull*/ /*@NonInvalid*/ ClassifierPropertyCS classifierPropertyCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Property_0 = idResolver.getClass(CLSSid_Property, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = classifierPropertyCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Property oclAsType = ClassUtil.nonNullState((Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Property_0));
        final /*@Nullable*/ /*@Thrown*/ String name = classifierPropertyCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uProperty_isComposite in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (classifierPropertyCS : qvtoperationalcs::ClassifierPropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Property[1];
     * _1 : Boolean[?];
     *  |
     * _0 := classifierPropertyCS.pivot.oclAsType(Property)
     *   ;
     * _1 := qualifiers->exists(x | x = 'composite');
     * _0.isComposite := _1;
     * }
     * 
     */
    protected boolean MAP_uProperty_isComposite(final /*@NonNull*/ /*@NonInvalid*/ ClassifierPropertyCS classifierPropertyCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Property_0 = idResolver.getClass(CLSSid_Property, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = classifierPropertyCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Property oclAsType = ClassUtil.nonNullState((Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Property_0));
        final /*@NonNull*/ /*@Thrown*/ List<String> qualifiers = classifierPropertyCS_1.getQualifiers();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_qualifiers = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, qualifiers);
        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_qualifiers.iterator();
        /*@Thrown*/ boolean exists;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                if (accumulator == ValueUtil.FALSE_VALUE) {
                    exists = ValueUtil.FALSE_VALUE;
                }
                else {
                    throw (InvalidValueException)accumulator;
                }
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ String x = (String)ITERATOR_x.next();
            /**
             * x = 'composite'
             */
            final /*@NonInvalid*/ boolean eq = STR_composite.equals(x);
            //
            if (eq == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
                exists = ValueUtil.TRUE_VALUE;
                break;														// Stop immediately 
            }
            else if (eq == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
                ;															// Carry on
            }
            else {															// Impossible badly typed result
                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
            }
        }
        // property assignments
        oclAsType.setIsComposite(exists);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uMappingOperation_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (mappingOperationCS : qvtoperationalcs::MappingOperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::MappingOperation[1];
     * _1 : String[?];
     *  |
     * _0 := mappingOperationCS.pivot.oclAsType(qvtoperational::MappingOperation);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uMappingOperation_name(final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS mappingOperationCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_MappingOperation_0 = idResolver.getClass(CLSSid_MappingOperation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = mappingOperationCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ MappingOperation oclAsType = ClassUtil.nonNullState((MappingOperation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_MappingOperation_0));
        final /*@Nullable*/ /*@Thrown*/ String name = mappingOperationCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uMappingOperation_ownedParameters in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (mappingOperationCS : qvtoperationalcs::MappingOperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::MappingOperation[1];
     * _1 : Sequence(Parameter);
     *  |
     * _0 := mappingOperationCS.pivot.oclAsType(qvtoperational::MappingOperation)
     *   ;
     * _1 := ownedParameters.pivot.oclAsType(Parameter);
     * _0.ownedParameters := _1;
     * }
     * 
     */
    protected boolean MAP_uMappingOperation_ownedParameters(final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS mappingOperationCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_MappingOperation_0 = idResolver.getClass(CLSSid_MappingOperation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = mappingOperationCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ MappingOperation oclAsType = ClassUtil.nonNullState((MappingOperation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_MappingOperation_0));
        final /*@NonNull*/ /*@Thrown*/ List<ParameterCS> ownedParameters = mappingOperationCS_1.getOwnedParameters();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, ownedParameters);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Parameter);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedParameters.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ ParameterCS _1 = (ParameterCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Parameter)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
            if (_1 == null) {
                throwNull(mappingOperationCS_1, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Parameter oclAsType_0 = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Parameter_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Parameter> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, collect);
        oclAsType.getOwnedParameters().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (metamodelCS : qvtoperationalcs::MetamodelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Package[1];
     * _1 : String[?];
     *  |
     * _0 := metamodelCS.pivot.oclAsType(Package);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_name(final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS metamodelCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = metamodelCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Package_0));
        final /*@Nullable*/ /*@Thrown*/ String name = metamodelCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_nsPrefix in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (metamodelCS : qvtoperationalcs::MetamodelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Package[1];
     * _1 : String[?];
     *  |
     * _0 := metamodelCS.pivot.oclAsType(Package);
     * _1 := name;
     * _0.nsPrefix := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_nsPrefix(final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS metamodelCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = metamodelCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Package_0));
        final /*@Nullable*/ /*@Thrown*/ String name = metamodelCS_1.getName();
        // property assignments
        oclAsType.setNsPrefix(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_URI in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (metamodelCS : qvtoperationalcs::MetamodelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Package[1];
     * _1 : String[?];
     *  |
     * _0 := metamodelCS.pivot.oclAsType(Package);
     * _1 := name;
     * _0.URI := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_URI(final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS metamodelCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = metamodelCS_2.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Package_0));
        final /*@Nullable*/ /*@Thrown*/ String name = metamodelCS_2.getName();
        // property assignments
        oclAsType.setURI(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_ownedClasses in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (metamodelCS : qvtoperationalcs::MetamodelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Package[1];
     * _1 : Sequence(Class);
     *  |
     * _0 := metamodelCS.pivot.oclAsType(Package)
     *   ;
     * _1 := ownedClasses.pivot.oclAsType(Class);
     * _0.ownedClasses := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_ownedClasses(final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS metamodelCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = metamodelCS_3.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Package_0));
        final /*@NonNull*/ /*@Thrown*/ List<ClassCS> ownedClasses = metamodelCS_3.getOwnedClasses();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ ClassCS _1 = (ClassCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Class)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Class_0 = idResolver.getClass(CLSSid_Class, null);
            if (_1 == null) {
                throwNull(metamodelCS_3, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Class oclAsType_0 = ClassUtil.nonNullState((Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Class_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Class> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Class.class, collect);
        oclAsType.getOwnedClasses().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uModelType_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (modelTypeCS : qvtoperationalcs::ModelTypeCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::ModelType[1];
     * _1 : String[?];
     *  |
     * _0 := modelTypeCS.pivot.oclAsType(qvtoperational::ModelType);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uModelType_name(final /*@NonNull*/ /*@NonInvalid*/ ModelTypeCS modelTypeCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_ModelType_0 = idResolver.getClass(CLSSid_ModelType, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = modelTypeCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ ModelType oclAsType = ClassUtil.nonNullState((ModelType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_ModelType_0));
        final /*@Nullable*/ /*@Thrown*/ String name = modelTypeCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uVarParameter_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (parameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not parameterDeclarationCS.oclContainer()
     *   .oclIsKindOf(qvtoperationalcs::ModuleCS)
     *   )
     * {_0 : qvtoperational::VarParameter[1];
     * _1 : String[?];
     *  |
     * _0 := parameterDeclarationCS.pivot.oclAsType(qvtoperational::VarParameter);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uVarParameter_name(final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS parameterDeclarationCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ModuleCS_0 = idResolver.getClass(CLSSid_ModuleCS, null);
        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, parameterDeclarationCS_1);
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtoperationalcs_c_c_ModuleCS_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_VarParameter_0 = idResolver.getClass(CLSSid_VarParameter, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = parameterDeclarationCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ VarParameter oclAsType = ClassUtil.nonNullState((VarParameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_VarParameter_0));
        final /*@Nullable*/ /*@Thrown*/ String name = parameterDeclarationCS_1.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uModelParameter_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (parameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * parameterDeclarationCS.oclContainer()
     *   .oclIsKindOf(qvtoperationalcs::ModuleCS)
     *   )
     * {_0 : qvtoperational::ModelParameter[1];
     * _1 : String[?];
     *  |
     * _0 := parameterDeclarationCS.pivot.oclAsType(qvtoperational::ModelParameter);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uModelParameter_name(final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS parameterDeclarationCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ModuleCS_0 = idResolver.getClass(CLSSid_ModuleCS, null);
        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, parameterDeclarationCS_2);
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtoperationalcs_c_c_ModuleCS_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_ModelParameter_0 = idResolver.getClass(CLSSid_ModelParameter, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = parameterDeclarationCS_2.getPivot();
        final /*@NonNull*/ /*@Thrown*/ ModelParameter oclAsType = ClassUtil.nonNullState((ModelParameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_ModelParameter_0));
        final /*@Nullable*/ /*@Thrown*/ String name = parameterDeclarationCS_2.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uModelParameter_type in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (parameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * parameterDeclarationCS.oclContainer()
     *   .oclIsKindOf(qvtoperationalcs::ModuleCS)
     *   )
     * {_0 : qvtoperational::ModelParameter[1];
     * _1 : qvtoperational::ModelType[?];
     *  |
     * _0 := parameterDeclarationCS.pivot.oclAsType(qvtoperational::ModelParameter)
     *   ;
     * _1 := pivot.oclAsType(qvtoperational::VarParameter)
     *   .lookupModelType(
     *     ownedType.oclAsType(qvtoperationalcs::TypedTypeRef2CS));
     * _0.type := _1;
     * }
     * 
     */
    protected boolean MAP_uModelParameter_type(final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS parameterDeclarationCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ModuleCS_0 = idResolver.getClass(CLSSid_ModuleCS, null);
        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, parameterDeclarationCS_3);
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtoperationalcs_c_c_ModuleCS_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_ModelParameter_0 = idResolver.getClass(CLSSid_ModelParameter, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_VarParameter_0 = idResolver.getClass(CLSSid_VarParameter, null);
        final /*@Nullable*/ /*@Thrown*/ Element pivot = parameterDeclarationCS_3.getPivot();
        // variable assignments
        final /*@NonNull*/ /*@Thrown*/ ModelParameter oclAsType = ClassUtil.nonNullState((ModelParameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_ModelParameter_0));
        final /*@NonNull*/ /*@Thrown*/ VarParameter self_0 = ClassUtil.nonNullState((VarParameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_VarParameter_0));
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_TypedTypeRef2CS_0 = idResolver.getClass(CLSSid_TypedTypeRef2CS, null);
        final /*@Nullable*/ /*@Thrown*/ TypedRefCS ownedType = parameterDeclarationCS_3.getOwnedType();
        final /*@NonNull*/ /*@Thrown*/ TypedTypeRef2CS typedRef = ClassUtil.nonNullState((TypedTypeRef2CS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ownedType, TYP_qvtoperationalcs_c_c_TypedTypeRef2CS_0));
        final /*@Nullable*/ /*@Thrown*/ PathName2CS ownedPathName = typedRef.getOwnedPathName();
        if (ownedPathName == null) {
            throwNull(parameterDeclarationCS_3, "Null source for \'\'http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS\'::PathName2CS::ownedPathElements2\'");
        }
        final /*@NonNull*/ /*@Thrown*/ List<PathElement2CS> pathSeq = ownedPathName.getOwnedPathElements2();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_pathSeq = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElement2CS, pathSeq);
        final /*@Nullable*/ /*@Thrown*/ PathElement2CS last = (PathElement2CS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq);
        SingleResultLookupEnvironment _lookupEnv = new SingleResultLookupEnvironment(executor,last, ValueUtil.FALSE_VALUE);
        QVTOperationalLookupVisitor _lookupVisitor = new QVTOperationalLookupVisitor(_lookupEnv);
        EList<NamedElement> _lookupResult = self_0.accept(_lookupVisitor).getNamedElements();
        ModelType _lookupModelType = null;
        if (_lookupResult.size() == 1) {
            _lookupModelType = (ModelType)_lookupResult.get(0);
        } else {
            handleLookupError(parameterDeclarationCS_3,last);
        };
        // property assignments
        oclAsType.setType(_lookupModelType);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uClass_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToClassCS : qvtoperationalcs::QVToClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Class[1];
     * _1 : String[?];
     *  |
     * _0 := qVToClassCS.pivot.oclAsType(Class);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_name(final /*@NonNull*/ /*@NonInvalid*/ QVToClassCS qVToClassCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToClassCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Class oclAsType = ClassUtil.nonNullState((Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Class_0));
        final /*@Nullable*/ /*@Thrown*/ String name = qVToClassCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uClass_ownedProperties in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToClassCS : qvtoperationalcs::QVToClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Class[1];
     * _1 : Sequence(Property[*|1]);
     *  |
     * _0 := qVToClassCS.pivot.oclAsType(Class)
     *   ;
     * _1 := ownedProperties.pivot.oclAsType(Element)
     *   .oclAsType(Property);
     * _0.ownedProperties := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_ownedProperties(final /*@NonNull*/ /*@NonInvalid*/ QVToClassCS qVToClassCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToClassCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Class oclAsType = ClassUtil.nonNullState((Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Class_0));
        final /*@NonNull*/ /*@Thrown*/ List<StructuralFeatureCS> ownedProperties = qVToClassCS_1.getOwnedProperties();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_StructuralFeatureCS, ownedProperties);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedProperties.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ StructuralFeatureCS _1 = (StructuralFeatureCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Element)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Element_0 = idResolver.getClass(CLSSid_Element, null);
            if (_1 == null) {
                throwNull(qVToClassCS_1, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Element oclAsType_0 = ClassUtil.nonNullState((Element)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Element_0));
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Element _1_0 = (Element)ITERATOR__1_0.next();
            /**
             * oclAsType(Property)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Property_0 = idResolver.getClass(CLSSid_Property, null);
            final /*@NonNull*/ /*@Thrown*/ Property oclAsType_1 = ClassUtil.nonNullState((Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1_0, TYP_Property_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Property> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, collect);
        oclAsType.getOwnedProperties().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uClass_ownedOperations in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToClassCS : qvtoperationalcs::QVToClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Class[1];
     * _1 : Sequence(Operation);
     *  |
     * _0 := qVToClassCS.pivot.oclAsType(Class)
     *   ;
     * _1 := ownedOperations.pivot.oclAsType(Operation);
     * _0.ownedOperations := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_ownedOperations(final /*@NonNull*/ /*@NonInvalid*/ QVToClassCS qVToClassCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToClassCS_2.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Class oclAsType = ClassUtil.nonNullState((Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Class_0));
        final /*@NonNull*/ /*@Thrown*/ List<OperationCS> ownedOperations = qVToClassCS_2.getOwnedOperations();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, ownedOperations);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedOperations.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ OperationCS _1 = (OperationCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Operation)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
            if (_1 == null) {
                throwNull(qVToClassCS_2, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Operation_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Operation> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, collect);
        oclAsType.getOwnedOperations().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uLibrary_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToLibraryCS : qvtoperationalcs::QVToLibraryCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::Library[1];
     * _1 : String[?];
     *  |
     * _0 := qVToLibraryCS.pivot.oclAsType(qvtoperational::Library);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uLibrary_name(final /*@NonNull*/ /*@NonInvalid*/ QVToLibraryCS qVToLibraryCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_Library_0 = idResolver.getClass(CLSSid_Library, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToLibraryCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Library oclAsType = ClassUtil.nonNullState((Library)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_Library_0));
        final /*@Nullable*/ /*@Thrown*/ String name = qVToLibraryCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uLibrary_ownedOperations in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToLibraryCS : qvtoperationalcs::QVToLibraryCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::Library[1];
     * _1 : Sequence(Operation);
     *  |
     * _0 := qVToLibraryCS.pivot.oclAsType(qvtoperational::Library)
     *   ;
     * _1 := ownedOperations.pivot.oclAsType(Operation);
     * _0.ownedOperations := _1;
     * }
     * 
     */
    protected boolean MAP_uLibrary_ownedOperations(final /*@NonNull*/ /*@NonInvalid*/ QVToLibraryCS qVToLibraryCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_Library_0 = idResolver.getClass(CLSSid_Library, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToLibraryCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Library oclAsType = ClassUtil.nonNullState((Library)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_Library_0));
        final /*@NonNull*/ /*@Thrown*/ List<OperationCS> ownedOperations = qVToLibraryCS_1.getOwnedOperations();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, ownedOperations);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedOperations.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ OperationCS _1 = (OperationCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Operation)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
            if (_1 == null) {
                throwNull(qVToLibraryCS_1, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Operation_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Operation> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, collect);
        oclAsType.getOwnedOperations().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uLibrary_usedModelType in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToLibraryCS : qvtoperationalcs::QVToLibraryCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::Library[1];
     * _1 : Sequence(qvtoperational::ModelType);
     *  |
     * _0 := qVToLibraryCS.pivot.oclAsType(qvtoperational::Library)
     *   ;
     * _1 := parameters->collect(x |
     *     qVToLibraryCS.pivot.oclAsType(qvtoperational::Library)
     *     .lookupModelType(
     *       x.ownedType.oclAsType(qvtoperationalcs::TypedTypeRef2CS)));
     * _0.usedModelType := _1;
     * }
     * 
     */
    protected boolean MAP_uLibrary_usedModelType(final /*@NonNull*/ /*@NonInvalid*/ QVToLibraryCS qVToLibraryCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_Library_0 = idResolver.getClass(CLSSid_Library, null);
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToLibraryCS_2.getPivot();
        // variable assignments
        final /*@NonNull*/ /*@Thrown*/ Library oclAsType = ClassUtil.nonNullState((Library)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_Library_0));
        final /*@NonNull*/ /*@Thrown*/ List<ParameterCS> parameters = qVToLibraryCS_2.getParameters();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_parameters = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, parameters);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_ModelType);
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_parameters.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ ParameterCS x = (ParameterCS)ITERATOR_x.next();
            /**
             * _'null' : qvtoperational::ModelType[?]
             */
            final /*@NonNull*/ /*@Thrown*/ Library self_0 = ClassUtil.nonNullState((Library)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_Library_0));
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_TypedTypeRef2CS_0 = idResolver.getClass(CLSSid_TypedTypeRef2CS, null);
            if (x == null) {
                throwNull(qVToLibraryCS_2, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::TypedElementCS::ownedType\'");
            }
            final /*@Nullable*/ /*@Thrown*/ TypedRefCS ownedType = x.getOwnedType();
            final /*@NonNull*/ /*@Thrown*/ TypedTypeRef2CS typedRef = ClassUtil.nonNullState((TypedTypeRef2CS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ownedType, TYP_qvtoperationalcs_c_c_TypedTypeRef2CS_0));
            final /*@Nullable*/ /*@Thrown*/ PathName2CS ownedPathName = typedRef.getOwnedPathName();
            if (ownedPathName == null) {
                throwNull(qVToLibraryCS_2, "Null source for \'\'http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS\'::PathName2CS::ownedPathElements2\'");
            }
            final /*@NonNull*/ /*@Thrown*/ List<PathElement2CS> pathSeq = ownedPathName.getOwnedPathElements2();
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_pathSeq = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElement2CS, pathSeq);
            final /*@Nullable*/ /*@Thrown*/ PathElement2CS last = (PathElement2CS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq);
            SingleResultLookupEnvironment _lookupEnv = new SingleResultLookupEnvironment(executor,last, ValueUtil.FALSE_VALUE);
            QVTOperationalLookupVisitor _lookupVisitor = new QVTOperationalLookupVisitor(_lookupEnv);
            EList<NamedElement> _lookupResult = self_0.accept(_lookupVisitor).getNamedElements();
            ModelType _lookupModelType = null;
            if (_lookupResult.size() == 1) {
                _lookupModelType = (ModelType)_lookupResult.get(0);
            } else {
                handleLookupError(x,last);
            };
            //
            accumulator.add(_lookupModelType);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<ModelType> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(ModelType.class, collect);
        oclAsType.getUsedModelType().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uLibrary_isBlackbox in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (qVToLibraryCS : qvtoperationalcs::QVToLibraryCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::Library[1];
     * _1 : Boolean[?];
     *  |
     * _0 := qVToLibraryCS.pivot.oclAsType(qvtoperational::Library)
     *   ;
     * _1 := qualifiers->exists(x | x = 'blackbox');
     * _0.isBlackbox := _1;
     * }
     * 
     */
    protected boolean MAP_uLibrary_isBlackbox(final /*@NonNull*/ /*@NonInvalid*/ QVToLibraryCS qVToLibraryCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_Library_0 = idResolver.getClass(CLSSid_Library, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = qVToLibraryCS_3.getPivot();
        final /*@NonNull*/ /*@Thrown*/ Library oclAsType = ClassUtil.nonNullState((Library)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_Library_0));
        final /*@NonNull*/ /*@Thrown*/ List<String> qualifiers = qVToLibraryCS_3.getQualifiers();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_qualifiers = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, qualifiers);
        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_qualifiers.iterator();
        /*@Thrown*/ boolean exists;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                if (accumulator == ValueUtil.FALSE_VALUE) {
                    exists = ValueUtil.FALSE_VALUE;
                }
                else {
                    throw (InvalidValueException)accumulator;
                }
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ String x = (String)ITERATOR_x.next();
            /**
             * x = 'blackbox'
             */
            final /*@NonInvalid*/ boolean eq = STR_blackbox.equals(x);
            //
            if (eq == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
                exists = ValueUtil.TRUE_VALUE;
                break;														// Stop immediately 
            }
            else if (eq == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
                ;															// Carry on
            }
            else {															// Impossible badly typed result
                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
            }
        }
        // property assignments
        oclAsType.setIsBlackbox(exists);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uModel_ownedPackages in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (topLevelCS : qvtoperationalcs::TopLevelCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : Model[1];
     * _1 : Set(Package);
     *  |
     * _0 := topLevelCS.pivot.oclAsType(Model)
     *   ;
     * _1 := let
     *     dummyPackage : Package[1] = Package{
     *       name = '', ownedClasses = ownedTypes.pivot.oclAsType(Element)
     *       .oclAsType(Class)
     *     };
     * 
     *   in
     *     dummyPackage->includingAll(ownedPackages.pivot.oclAsType(Package));
     * _0.ownedPackages := _1;
     * }
     * 
     */
    protected boolean MAP_uModel_ownedPackages(final /*@NonNull*/ /*@NonInvalid*/ TopLevelCS topLevelCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_name = idResolver.getProperty(PROPid_name);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Model_0 = idResolver.getClass(CLSSid_Model, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Package_0 = idResolver.getClass(CLSSid_Package, null);
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_ownedClasses = idResolver.getProperty(PROPid_ownedClasses);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = topLevelCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Model oclAsType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Model)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_Model_0));
        final /*@NonNull*/ /*@Thrown*/ Package dummyPackage = (Package)TYP_Package_0.createInstance();
        CTORid_name.initValue(dummyPackage, STR_);
        final /*@NonNull*/ /*@Thrown*/ List<TypeCS> ownedTypes = topLevelCS_0.getOwnedTypes();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedTypes = idResolver.createOrderedSetOfAll(ORD_CLSSid_TypeCS, ownedTypes);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedTypes.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ TypeCS _1 = (TypeCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Element)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Element_0 = idResolver.getClass(CLSSid_Element, null);
            if (_1 == null) {
                throwNull(topLevelCS_0, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Element oclAsType_0 = ClassUtil.nonNullState((Element)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Element_0));
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Element _1_0 = (Element)ITERATOR__1_0.next();
            /**
             * oclAsType(Class)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Class_0 = idResolver.getClass(CLSSid_Class, null);
            final /*@NonNull*/ /*@Thrown*/ Class oclAsType_1 = ClassUtil.nonNullState((Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1_0, TYP_Class_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        final List<Class> UNBOXED_collect = collect.asEcoreObjects(idResolver, Class.class);
        assert UNBOXED_collect != null;
        CTORid_ownedClasses.initValue(dummyPackage, UNBOXED_collect);
        final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, dummyPackage);
        final /*@NonNull*/ /*@Thrown*/ List<PackageCS> ownedPackages = topLevelCS_0.getOwnedPackages();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1_1 = BOXED_ownedPackages.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_1;
        while (true) {
            if (!ITERATOR__1_1.hasNext()) {
                collect_1 = accumulator_1;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ PackageCS _1_1 = (PackageCS)ITERATOR__1_1.next();
            /**
             * pivot.oclAsType(Package)
             */
            if (_1_1 == null) {
                throwNull(topLevelCS_0, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_1 = _1_1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Package oclAsType_2 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_1, TYP_Package_0));
            //
            accumulator_1.add(oclAsType_2);
        }
        final /*@NonNull*/ /*@Thrown*/ SetValue includingAll = (SetValue)CollectionIncludingAllOperation.INSTANCE.evaluate(oclAsSet, collect_1);
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Package> ECORE_includingAll = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, includingAll);
        oclAsType.getOwnedPackages().addAll(ECORE_includingAll);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uOperationalTransformation_name in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (transformationCS : qvtoperationalcs::TransformationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::OperationalTransformation[1];
     * _1 : String[?];
     *  |
     * _0 := transformationCS.pivot.oclAsType(qvtoperational::OperationalTransformation);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationalTransformation_name(final /*@NonNull*/ /*@NonInvalid*/ TransformationCS transformationCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_OperationalTransformation_0 = idResolver.getClass(CLSSid_OperationalTransformation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = transformationCS_0.getPivot();
        final /*@NonNull*/ /*@Thrown*/ OperationalTransformation oclAsType = ClassUtil.nonNullState((OperationalTransformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_OperationalTransformation_0));
        final /*@Nullable*/ /*@Thrown*/ String name = transformationCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uOperationalTransformation_modelParameter in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (transformationCS : qvtoperationalcs::TransformationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::OperationalTransformation[1];
     * _1 : Sequence(qvtoperational::ModelParameter[*|1]);
     *  |
     * _0 := transformationCS.pivot.oclAsType(qvtoperational::OperationalTransformation)
     *   ;
     * _1 := parameters.pivot.oclAsType(Parameter)
     *   .oclAsType(qvtoperational::ModelParameter);
     * _0.modelParameter := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationalTransformation_modelParameter(final /*@NonNull*/ /*@NonInvalid*/ TransformationCS transformationCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_OperationalTransformation_0 = idResolver.getClass(CLSSid_OperationalTransformation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = transformationCS_1.getPivot();
        final /*@NonNull*/ /*@Thrown*/ OperationalTransformation oclAsType = ClassUtil.nonNullState((OperationalTransformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_OperationalTransformation_0));
        final /*@NonNull*/ /*@Thrown*/ List<ParameterCS> parameters = transformationCS_1.getParameters();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_parameters = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, parameters);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Parameter);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_parameters.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ ParameterCS _1 = (ParameterCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Parameter)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
            if (_1 == null) {
                throwNull(transformationCS_1, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Parameter oclAsType_0 = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Parameter_0));
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_ModelParameter);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Parameter _1_0 = (Parameter)ITERATOR__1_0.next();
            /**
             * oclAsType(qvtoperational::ModelParameter)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_ModelParameter_0 = idResolver.getClass(CLSSid_ModelParameter, null);
            final /*@NonNull*/ /*@Thrown*/ ModelParameter oclAsType_1 = ClassUtil.nonNullState((ModelParameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1_0, TYP_qvtoperational_c_c_ModelParameter_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<ModelParameter> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(ModelParameter.class, collect);
        oclAsType.getModelParameter().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uOperationalTransformation_ownedOperations in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (transformationCS : qvtoperationalcs::TransformationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::OperationalTransformation[1];
     * _1 : Sequence(Operation);
     *  |
     * _0 := transformationCS.pivot.oclAsType(qvtoperational::OperationalTransformation)
     *   ;
     * _1 := ownedOperations.pivot.oclAsType(Operation);
     * _0.ownedOperations := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationalTransformation_ownedOperations(final /*@NonNull*/ /*@NonInvalid*/ TransformationCS transformationCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_OperationalTransformation_0 = idResolver.getClass(CLSSid_OperationalTransformation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = transformationCS_2.getPivot();
        final /*@NonNull*/ /*@Thrown*/ OperationalTransformation oclAsType = ClassUtil.nonNullState((OperationalTransformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_OperationalTransformation_0));
        final /*@NonNull*/ /*@Thrown*/ List<OperationCS> ownedOperations = transformationCS_2.getOwnedOperations();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, ownedOperations);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedOperations.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ OperationCS _1 = (OperationCS)ITERATOR__1.next();
            /**
             * pivot.oclAsType(Operation)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
            if (_1 == null) {
                throwNull(transformationCS_2, "Null source for \'\'http://www.eclipse.org/ocl/2015/BaseCS\'::PivotableElementCS::pivot\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Element pivot_0 = _1.getPivot();
            final /*@NonNull*/ /*@Thrown*/ Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot_0, TYP_Operation_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Operation> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, collect);
        oclAsType.getOwnedOperations().addAll(ECORE_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uOperationalTransformation_isBlackbox in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (transformationCS : qvtoperationalcs::TransformationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::OperationalTransformation[1];
     * _1 : Boolean[?];
     *  |
     * _0 := transformationCS.pivot.oclAsType(qvtoperational::OperationalTransformation)
     *   ;
     * _1 := qualifiers->exists(x | x = 'blackbox');
     * _0.isBlackbox := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationalTransformation_isBlackbox(final /*@NonNull*/ /*@NonInvalid*/ TransformationCS transformationCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_OperationalTransformation_0 = idResolver.getClass(CLSSid_OperationalTransformation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = transformationCS_3.getPivot();
        final /*@NonNull*/ /*@Thrown*/ OperationalTransformation oclAsType = ClassUtil.nonNullState((OperationalTransformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_OperationalTransformation_0));
        final /*@NonNull*/ /*@Thrown*/ List<String> qualifiers = transformationCS_3.getQualifiers();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_qualifiers = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, qualifiers);
        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_qualifiers.iterator();
        /*@Thrown*/ boolean exists;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                if (accumulator == ValueUtil.FALSE_VALUE) {
                    exists = ValueUtil.FALSE_VALUE;
                }
                else {
                    throw (InvalidValueException)accumulator;
                }
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ String x = (String)ITERATOR_x.next();
            /**
             * x = 'blackbox'
             */
            final /*@NonInvalid*/ boolean eq = STR_blackbox.equals(x);
            //
            if (eq == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
                exists = ValueUtil.TRUE_VALUE;
                break;														// Stop immediately 
            }
            else if (eq == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
                ;															// Carry on
            }
            else {															// Impossible badly typed result
                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
            }
        }
        // property assignments
        oclAsType.setIsBlackbox(exists);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uOperationalTransformation_isAbstract in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   leftCS (transformationCS : qvtoperationalcs::TransformationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : qvtoperational::OperationalTransformation[1];
     * _1 : Boolean[?];
     *  |
     * _0 := transformationCS.pivot.oclAsType(qvtoperational::OperationalTransformation)
     *   ;
     * _1 := qualifiers->exists(x | x = 'abstract');
     * _0.isAbstract := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationalTransformation_isAbstract(final /*@NonNull*/ /*@NonInvalid*/ TransformationCS transformationCS_4) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperational_c_c_OperationalTransformation_0 = idResolver.getClass(CLSSid_OperationalTransformation, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ Element pivot = transformationCS_4.getPivot();
        final /*@NonNull*/ /*@Thrown*/ OperationalTransformation oclAsType = ClassUtil.nonNullState((OperationalTransformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, pivot, TYP_qvtoperational_c_c_OperationalTransformation_0));
        final /*@NonNull*/ /*@Thrown*/ List<String> qualifiers = transformationCS_4.getQualifiers();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_qualifiers = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, qualifiers);
        /*@Nullable*/ /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_qualifiers.iterator();
        /*@Thrown*/ boolean exists;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                if (accumulator == ValueUtil.FALSE_VALUE) {
                    exists = ValueUtil.FALSE_VALUE;
                }
                else {
                    throw (InvalidValueException)accumulator;
                }
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ String x = (String)ITERATOR_x.next();
            /**
             * x = 'abstract'
             */
            final /*@NonInvalid*/ boolean eq = STR_abstract.equals(x);
            //
            if (eq == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
                exists = ValueUtil.TRUE_VALUE;
                break;														// Stop immediately 
            }
            else if (eq == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
                ;															// Carry on
            }
            else {															// Impossible badly typed result
                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
            }
        }
        // property assignments
        oclAsType.setIsAbstract(exists);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map __root__ in QVTOperationalCS2AS_qvtp_qvtias {
     * 
     *   where ( |)
     * { |}
     * for _classifierPropertyCS_ClassifierPropertyCS : qvtoperationalcs::ClassifierPropertyCS in qvtoperationalcs::ClassifierPropertyCS.allInstances()
     *    {
     * 
     *     map cClassifierPropertyCS_2_Property {
     * classifierPropertyCS := _classifierPropertyCS_ClassifierPropertyCS;
     * }}
     *   for _mappingOperationCS_MappingOperationCS : qvtoperationalcs::MappingOperationCS in qvtoperationalcs::MappingOperationCS.allInstances()
     *    {
     * 
     *     map cMappingOperationCS_2_MappingOperation {
     * mappingOperationCS := _mappingOperationCS_MappingOperationCS;
     * }}
     *   for _metamodelCS_MetamodelCS : qvtoperationalcs::MetamodelCS in qvtoperationalcs::MetamodelCS.allInstances()
     *    {
     * map cMetamodelCS_2_Package {
     * metamodelCS := _metamodelCS_MetamodelCS;
     * }}
     *   for _modelTypeCS_ModelTypeCS : qvtoperationalcs::ModelTypeCS in qvtoperationalcs::ModelTypeCS.allInstances()
     *    {
     * 
     *     map cModelTypeCS_2_ModelType {
     * modelTypeCS := _modelTypeCS_ModelTypeCS;
     * }}
     *   for _parameterDeclarationCS_ParameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS in qvtoperationalcs::ParameterDeclarationCS.allInstances()
     *    {
     * 
     *     map cParameterDeclarationCS_2_VarParameter {
     * parameterDeclarationCS := _parameterDeclarationCS_ParameterDeclarationCS;
     * }}
     *   for _parameterDeclarationCS_ParameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS in qvtoperationalcs::ParameterDeclarationCS.allInstances()
     *    {
     * 
     *     map cParameterDeclarationCS_2_ModelParameter {
     * parameterDeclarationCS := _parameterDeclarationCS_ParameterDeclarationCS;
     * }}
     *   for _mappingOperationCS_MappingOperationCS : qvtoperationalcs::MappingOperationCS in qvtoperationalcs::MappingOperationCS.allInstances()
     *    {
     * 
     *     map uMappingOperation_ownedParameters {
     * mappingOperationCS := _mappingOperationCS_MappingOperationCS;
     * }}
     *   for _qVToClassCS_QVToClassCS : qvtoperationalcs::QVToClassCS in qvtoperationalcs::QVToClassCS.allInstances()
     *    {
     * map cQVToClassCS_2_Class {
     * qVToClassCS := _qVToClassCS_QVToClassCS;
     * }}
     *   for _qVToLibraryCS_QVToLibraryCS : qvtoperationalcs::QVToLibraryCS in qvtoperationalcs::QVToLibraryCS.allInstances()
     *    {
     * 
     *     map cQVToLibraryCS_2_Library {
     * qVToLibraryCS := _qVToLibraryCS_QVToLibraryCS;
     * }}
     *   for _topLevelCS_TopLevelCS : qvtoperationalcs::TopLevelCS in qvtoperationalcs::TopLevelCS.allInstances()
     *    {
     * map cTopLevelCS_2_Model {
     * topLevelCS := _topLevelCS_TopLevelCS;
     * }}
     *   for _transformationCS_TransformationCS : qvtoperationalcs::TransformationCS in qvtoperationalcs::TransformationCS.allInstances()
     *    {
     * 
     *     map cTransformationCS_2_OperationalTransformation {
     * transformationCS := _transformationCS_TransformationCS;
     * }}
     *   for _metamodelCS_MetamodelCS : qvtoperationalcs::MetamodelCS in qvtoperationalcs::MetamodelCS.allInstances()
     *    {
     * map uPackage_ownedClasses {
     * metamodelCS := _metamodelCS_MetamodelCS;
     * }}
     *   for _topLevelCS_TopLevelCS : qvtoperationalcs::TopLevelCS in qvtoperationalcs::TopLevelCS.allInstances()
     *    {
     * map uModel_ownedPackages {
     * topLevelCS := _topLevelCS_TopLevelCS;
     * }}
     *   for _parameterDeclarationCS_ParameterDeclarationCS : qvtoperationalcs::ParameterDeclarationCS in qvtoperationalcs::ParameterDeclarationCS.allInstances()
     *    {
     * 
     *     map uModelParameter_type {
     * parameterDeclarationCS := _parameterDeclarationCS_ParameterDeclarationCS;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ClassifierPropertyCS_0 = idResolver.getClass(CLSSid_ClassifierPropertyCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_MappingOperationCS_1 = idResolver.getClass(CLSSid_MappingOperationCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_MetamodelCS_1 = idResolver.getClass(CLSSid_MetamodelCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ModelTypeCS_0 = idResolver.getClass(CLSSid_ModelTypeCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_ParameterDeclarationCS_2 = idResolver.getClass(CLSSid_ParameterDeclarationCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_QVToClassCS_0 = idResolver.getClass(CLSSid_QVToClassCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_QVToLibraryCS_0 = idResolver.getClass(CLSSid_QVToLibraryCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_TopLevelCS_1 = idResolver.getClass(CLSSid_TopLevelCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_qvtoperationalcs_c_c_TransformationCS_0 = idResolver.getClass(CLSSid_TransformationCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_5 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_MappingOperationCS, TYP_qvtoperationalcs_c_c_MappingOperationCS_1);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_10 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_MetamodelCS, TYP_qvtoperationalcs_c_c_MetamodelCS_1);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_4 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ParameterDeclarationCS, TYP_qvtoperationalcs_c_c_ParameterDeclarationCS_2);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_11 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_TopLevelCS, TYP_qvtoperationalcs_c_c_TopLevelCS_1);
        // mapping statements
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassifierPropertyCS, TYP_qvtoperationalcs_c_c_ClassifierPropertyCS_0);
        for (ClassifierPropertyCS _classifierPropertyCS_ClassifierPropertyCS : ValueUtil.typedIterable(ClassifierPropertyCS.class, allInstances)) {
            if (_classifierPropertyCS_ClassifierPropertyCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ClassifierPropertyCS symbol_0 = (ClassifierPropertyCS)_classifierPropertyCS_ClassifierPropertyCS;
                MAP_cClassifierPropertyCS_2_Property(symbol_0);
            }
        }
        for (MappingOperationCS _mappingOperationCS_MappingOperationCS : ValueUtil.typedIterable(MappingOperationCS.class, allInstances_5)) {
            if (_mappingOperationCS_MappingOperationCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS symbol_2 = (MappingOperationCS)_mappingOperationCS_MappingOperationCS;
                MAP_cMappingOperationCS_2_MappingOperation(symbol_2);
            }
        }
        for (MetamodelCS _metamodelCS_MetamodelCS : ValueUtil.typedIterable(MetamodelCS.class, allInstances_10)) {
            if (_metamodelCS_MetamodelCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS symbol_4 = (MetamodelCS)_metamodelCS_MetamodelCS;
                MAP_cMetamodelCS_2_Package(symbol_4);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_2 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ModelTypeCS, TYP_qvtoperationalcs_c_c_ModelTypeCS_0);
        for (ModelTypeCS _modelTypeCS_ModelTypeCS : ValueUtil.typedIterable(ModelTypeCS.class, allInstances_2)) {
            if (_modelTypeCS_ModelTypeCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ModelTypeCS symbol_6 = (ModelTypeCS)_modelTypeCS_ModelTypeCS;
                MAP_cModelTypeCS_2_ModelType(symbol_6);
            }
        }
        for (ParameterDeclarationCS _parameterDeclarationCS_ParameterDeclarationCS : ValueUtil.typedIterable(ParameterDeclarationCS.class, allInstances_4)) {
            if (_parameterDeclarationCS_ParameterDeclarationCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS symbol_8 = (ParameterDeclarationCS)_parameterDeclarationCS_ParameterDeclarationCS;
                MAP_cParameterDeclarationCS_2_VarParameter(symbol_8);
            }
        }
        for (ParameterDeclarationCS _parameterDeclarationCS_ParameterDeclarationCS_0 : ValueUtil.typedIterable(ParameterDeclarationCS.class, allInstances_4)) {
            if (_parameterDeclarationCS_ParameterDeclarationCS_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS symbol_10 = (ParameterDeclarationCS)_parameterDeclarationCS_ParameterDeclarationCS_0;
                MAP_cParameterDeclarationCS_2_ModelParameter(symbol_10);
            }
        }
        for (MappingOperationCS _mappingOperationCS_MappingOperationCS_0 : ValueUtil.typedIterable(MappingOperationCS.class, allInstances_5)) {
            if (_mappingOperationCS_MappingOperationCS_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS symbol_12 = (MappingOperationCS)_mappingOperationCS_MappingOperationCS_0;
                MAP_uMappingOperation_ownedParameters(symbol_12);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_QVToClassCS, TYP_qvtoperationalcs_c_c_QVToClassCS_0);
        for (QVToClassCS _qVToClassCS_QVToClassCS : ValueUtil.typedIterable(QVToClassCS.class, allInstances_6)) {
            if (_qVToClassCS_QVToClassCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ QVToClassCS symbol_14 = (QVToClassCS)_qVToClassCS_QVToClassCS;
                MAP_cQVToClassCS_2_Class(symbol_14);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_7 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_QVToLibraryCS, TYP_qvtoperationalcs_c_c_QVToLibraryCS_0);
        for (QVToLibraryCS _qVToLibraryCS_QVToLibraryCS : ValueUtil.typedIterable(QVToLibraryCS.class, allInstances_7)) {
            if (_qVToLibraryCS_QVToLibraryCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ QVToLibraryCS symbol_16 = (QVToLibraryCS)_qVToLibraryCS_QVToLibraryCS;
                MAP_cQVToLibraryCS_2_Library(symbol_16);
            }
        }
        for (TopLevelCS _topLevelCS_TopLevelCS : ValueUtil.typedIterable(TopLevelCS.class, allInstances_11)) {
            if (_topLevelCS_TopLevelCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TopLevelCS symbol_18 = (TopLevelCS)_topLevelCS_TopLevelCS;
                MAP_cTopLevelCS_2_Model(symbol_18);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_9 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_TransformationCS, TYP_qvtoperationalcs_c_c_TransformationCS_0);
        for (TransformationCS _transformationCS_TransformationCS : ValueUtil.typedIterable(TransformationCS.class, allInstances_9)) {
            if (_transformationCS_TransformationCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TransformationCS symbol_20 = (TransformationCS)_transformationCS_TransformationCS;
                MAP_cTransformationCS_2_OperationalTransformation(symbol_20);
            }
        }
        for (MetamodelCS _metamodelCS_MetamodelCS_0 : ValueUtil.typedIterable(MetamodelCS.class, allInstances_10)) {
            if (_metamodelCS_MetamodelCS_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS symbol_22 = (MetamodelCS)_metamodelCS_MetamodelCS_0;
                MAP_uPackage_ownedClasses(symbol_22);
            }
        }
        for (TopLevelCS _topLevelCS_TopLevelCS_0 : ValueUtil.typedIterable(TopLevelCS.class, allInstances_11)) {
            if (_topLevelCS_TopLevelCS_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TopLevelCS symbol_24 = (TopLevelCS)_topLevelCS_TopLevelCS_0;
                MAP_uModel_ownedPackages(symbol_24);
            }
        }
        for (ParameterDeclarationCS _parameterDeclarationCS_ParameterDeclarationCS_1 : ValueUtil.typedIterable(ParameterDeclarationCS.class, allInstances_4)) {
            if (_parameterDeclarationCS_ParameterDeclarationCS_1 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ParameterDeclarationCS symbol_26 = (ParameterDeclarationCS)_parameterDeclarationCS_ParameterDeclarationCS_1;
                MAP_uModelParameter_type(symbol_26);
            }
        }
        return true;
    }
}
