/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvto.examples.pivot.qvtoperational.util;

import java.util.Iterator;
import java.util.List;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.internal.lookup.LookupPackage;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.lookup.ImperativeOCLLookupVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.Tag;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

public class AbstractQVTOperationalLookupVisitor
	extends ImperativeOCLLookupVisitor
	implements QVTOperationalVisitor<LookupEnvironment>
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Lookup", null, LookupPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCL", null, ImperativeOCLPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperational", null, QVTOperationalPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvto_examples_pivot_qvtoperational_lookup = IdManager.getRootPackageId("java://org.eclipse.qvto.examples.pivot.qvtoperational.lookup");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AbstractQVTOperationalLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvto_examples_pivot_qvtoperational_lookup.getClassId("AbstractQVTOperationalLookupVisitor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Constructor = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Constructor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ConstructorBody = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ConstructorBody", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ContextualProperty = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ContextualProperty", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DummyRelation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("DummyRelation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DummyRelationDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("DummyRelationDomain", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DummyRelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("DummyRelationalTransformation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_$metamodel$.getClassId("Element", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EntryOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("EntryOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Helper", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ImperativeCallExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ImperativeOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Library = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Library", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup.getClassId("LookupEnvironment", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingBody = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingBody", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingCallExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModelParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModelType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Module", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModuleImport = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModuleImport", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ObjectExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ObjectExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationBody = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("OperationBody", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("OperationalTransformation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ResolveExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ResolveExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ResolveInExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ResolveInExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Tag = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Tag", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_VarParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("VarParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_VariableInitExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("VariableInitExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId COL_CLSSid_OclElement = TypeId.COLLECTION.getSpecializedId(CLSSid_OclElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ModelParameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModelParameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ModuleImport = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModuleImport);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_VarParameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_VarParameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_VariableInitExp = TypeId.ORDERED_SET.getSpecializedId(CLSSid_VariableInitExp);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Module = TypeId.SEQUENCE.getSpecializedId(CLSSid_Module);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Variable = TypeId.SEQUENCE.getSpecializedId(CLSSid_Variable);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(CLSSid_Variable);
    
    protected /*@Nullable*/ /*@Thrown*/ Object child;
    protected final /*@NonNull*/ /*@Thrown*/ Executor executor;
    protected final /*@NonNull*/ /*@Thrown*/ IdResolver idResolver;
    
    public AbstractQVTOperationalLookupVisitor(/*@NonNull*/ LookupEnvironment context) {
        super(context);
        this.executor = context.getExecutor();
        this.idResolver = executor.getIdResolver();
    }
    
    /**
     * visitConstructor(element : qvtoperational::Constructor[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitConstructor(final /*@NonNull*/ /*@NonInvalid*/ Constructor element) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element);
        return parentEnv;
    }
    
    /**
     * visitConstructorBody(element : qvtoperational::ConstructorBody[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.content->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.variable)
     *     .addElements(
     *       element.content->select(x |
     *         element.content->indexOf(x) <
     *         element.content->indexOf(child))
     *       ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitConstructorBody(final /*@NonNull*/ /*@NonInvalid*/ ConstructorBody element_0) {
        final /*@NonNull*/ /*@Thrown*/ List<OCLExpression> content = element_0.getContent();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_content = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, content);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_content, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (includes) {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_imperativeocl_c_c_VariableInitExp_0 = idResolver.getClass(CLSSid_VariableInitExp, null);
            final /*@NonNull*/ /*@Thrown*/ List<Variable> variable = element_0.getVariable();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = context.addElements(variable);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
            /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_content.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ OCLExpression x = (OCLExpression)ITERATOR_x.next();
                /**
                 * element.content->indexOf(x) < element.content->indexOf(child)
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, x);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, select, TYP_imperativeocl_c_c_VariableInitExp_0);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
            /*@NonNull*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                /*@NonNull*/ /*@NonInvalid*/ VariableInitExp _1 = (VariableInitExp)ITERATOR__1.next();
                /**
                 * referredVariable
                 */
                final /*@NonNull*/ /*@Thrown*/ Variable referredVariable = _1.getReferredVariable();
                //
                accumulator_0.add(referredVariable);
            }
            final /*@NonNull*/ /*@Thrown*/ List<Variable> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, collect);
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ECORE_collect);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_0);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_0);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitContextualProperty(element : qvtoperational::ContextualProperty[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitContextualProperty(final /*@NonNull*/ /*@NonInvalid*/ ContextualProperty element_1) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitDummyRelation(element : qvtoperational::DummyRelation[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitDummyRelation(final /*@NonNull*/ /*@NonInvalid*/ DummyRelation element_2) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_2);
        return parentEnv;
    }
    
    /**
     * visitDummyRelationDomain(element : qvtoperational::DummyRelationDomain[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitDummyRelationDomain(final /*@NonNull*/ /*@NonInvalid*/ DummyRelationDomain element_3) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_3);
        return parentEnv;
    }
    
    /**
     * visitDummyRelationalTransformation(element : qvtoperational::DummyRelationalTransformation[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitDummyRelationalTransformation(final /*@NonNull*/ /*@NonInvalid*/ DummyRelationalTransformation element_4) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_4);
        return parentEnv;
    }
    
    /**
     * visitEntryOperation(element : qvtoperational::EntryOperation[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitEntryOperation(final /*@NonNull*/ /*@NonInvalid*/ EntryOperation element_5) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_5);
        return parentEnv;
    }
    
    /**
     * visitHelper(element : qvtoperational::Helper[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitHelper(final /*@NonNull*/ /*@NonInvalid*/ Helper element_6) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_6);
        return parentEnv;
    }
    
    /**
     * visitImperativeCallExp(element : qvtoperational::ImperativeCallExp[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitImperativeCallExp(final /*@NonNull*/ /*@NonInvalid*/ ImperativeCallExp element_7) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_7);
        return parentEnv;
    }
    
    /**
     * visitImperativeOperation(element : qvtoperational::ImperativeOperation[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.body = child
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElement(element.context)
     *     .addElements(element.result)
     *     .addElements(element.ownedParameters)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitImperativeOperation(final /*@NonNull*/ /*@NonInvalid*/ ImperativeOperation element_8) {
        final /*@Nullable*/ /*@Thrown*/ OperationBody body = element_8.getBody();
        final /*@Thrown*/ boolean eq = (body != null) ? body.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ VarParameter context_0 = element_8.getContext();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElement = context.addElement(context_0);
            final /*@NonNull*/ /*@Thrown*/ List<VarParameter> result = element_8.getResult();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = addElement.addElements(result);
            final /*@NonNull*/ /*@Thrown*/ List<Parameter> ownedParameters = element_8.getOwnedParameters();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ownedParameters);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_8);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_8);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitLibrary(element : qvtoperational::Library[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedProperties)
     *   .addElements(element.ownedOperations)
     *   .addElements(element.ownedVariable)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else
     *     let
     *       inner : lookup::LookupEnvironment[?] = context.addElementsOf(element.moduleImport.module)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitLibrary(final /*@NonNull*/ /*@NonInvalid*/ Library element_9) {
        final /*@NonNull*/ /*@Thrown*/ List<Property> ownedProperties = element_9.getOwnedProperties();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedProperties);
        final /*@NonNull*/ /*@Thrown*/ List<Operation> ownedOperations = element_9.getOwnedOperations();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ownedOperations);
        final /*@NonNull*/ /*@Thrown*/ List<Variable> ownedVariable = element_9.getOwnedVariable();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements(ownedVariable);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (hasFinalResult) {
            symbol_1 = inner;
        }
        else {
            final /*@NonNull*/ /*@Thrown*/ List<ModuleImport> moduleImport = element_9.getModuleImport();
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_moduleImport = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleImport, moduleImport);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Module);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_moduleImport.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue elements;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    elements = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ ModuleImport _1 = (ModuleImport)ITERATOR__1.next();
                /**
                 * _'null' : qvtoperational::Module[?]
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/pivot/1.0/QVTOperational\'::ModuleImport::module\'");
                }
                final /*@Nullable*/ /*@Thrown*/ Module module = _1.getModule();
                //
                accumulator.add(module);
            }
            /*@NonNull*/ /*@NonInvalid*/ LookupEnvironment acc = context;
            /*@Nullable*/ Iterator<?> ITERATOR_element_25 = elements.iterator();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment iterate;
            while (true) {
                if (!ITERATOR_element_25.hasNext()) {
                    iterate = acc;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ Object element_25 = (Object)ITERATOR_element_25.next();
                /**
                 * _'null' : lookup::LookupEnvironment[?]
                 */
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment envForChild = this.envForChild(element_25, null);
                //
                acc = envForChild;
            }
            if (iterate == null) {
                throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::hasFinalResult() : Boolean[?]\'");
            }
            final /*@Thrown*/ boolean hasFinalResult_0 = iterate.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult_0) {
                symbol_0 = iterate;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_9);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        return symbol_1;
    }
    
    /**
     * visitMappingBody(element : qvtoperational::MappingBody[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.content->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.variable)
     *     .addElements(
     *       element.content->select(x |
     *         element.content->indexOf(x) <
     *         element.content->indexOf(child))
     *       ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if element.initSection->includes(child)
     *   then
     *     let
     *       inner : lookup::LookupEnvironment[1] = context.addElements(element.variable)
     *       .addElements(
     *         element.content->select(x |
     *           element.initSection->indexOf(x) <
     *           element.initSection->indexOf(child))
     *         ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     if element.endSection->includes(child)
     *     then
     *       let
     *         inner : lookup::LookupEnvironment[1] = context.addElements(element.variable)
     *         .addElements(
     *           element.content->select(x |
     *             element.endSection->indexOf(x) <
     *             element.endSection->indexOf(child))
     *           ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     else this.parentEnv(element)
     *     endif
     *   endif
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitMappingBody(final /*@NonNull*/ /*@NonInvalid*/ MappingBody element_10) {
        final /*@NonNull*/ /*@Thrown*/ List<OCLExpression> content = element_10.getContent();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_content = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, content);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_content, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_5;
        if (includes) {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_imperativeocl_c_c_VariableInitExp_0 = idResolver.getClass(CLSSid_VariableInitExp, null);
            final /*@NonNull*/ /*@Thrown*/ List<Variable> variable = element_10.getVariable();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = context.addElements(variable);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
            /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_content.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ OCLExpression x = (OCLExpression)ITERATOR_x.next();
                /**
                 * element.content->indexOf(x) < element.content->indexOf(child)
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, x);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, select, TYP_imperativeocl_c_c_VariableInitExp_0);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
            /*@NonNull*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                /*@NonNull*/ /*@NonInvalid*/ VariableInitExp _1 = (VariableInitExp)ITERATOR__1.next();
                /**
                 * referredVariable
                 */
                final /*@NonNull*/ /*@Thrown*/ Variable referredVariable = _1.getReferredVariable();
                //
                accumulator_0.add(referredVariable);
            }
            final /*@NonNull*/ /*@Thrown*/ List<Variable> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, collect);
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ECORE_collect);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_10);
                symbol_0 = parentEnv;
            }
            symbol_5 = symbol_0;
        }
        else {
            final /*@NonNull*/ /*@Thrown*/ List<OCLExpression> initSection = element_10.getInitSection();
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_initSection = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, initSection);
            final /*@Thrown*/ boolean includes_0 = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_initSection, child).booleanValue();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_4;
            if (includes_0) {
                final /*@NonNull*/ /*@NonInvalid*/ Class TYP_imperativeocl_c_c_VariableInitExp_1 = idResolver.getClass(CLSSid_VariableInitExp, null);
                final /*@NonNull*/ /*@Thrown*/ List<Variable> variable_0 = element_10.getVariable();
                final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_0 = context.addElements(variable_0);
                /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator_1 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
                /*@Nullable*/ Iterator<?> ITERATOR_x_0 = BOXED_content.iterator();
                /*@NonNull*/ /*@Thrown*/ OrderedSetValue select_0;
                while (true) {
                    if (!ITERATOR_x_0.hasNext()) {
                        select_0 = accumulator_1;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ OCLExpression x_0 = (OCLExpression)ITERATOR_x_0.next();
                    /**
                     * element.initSection->indexOf(x) < element.initSection->indexOf(child)
                     */
                    final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_1 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_initSection, x_0);
                    final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_2 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_initSection, child);
                    final /*@Thrown*/ boolean lt_0 = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf_1, indexOf_2).booleanValue();
                    //
                    if (lt_0 == ValueUtil.TRUE_VALUE) {
                        accumulator_1.add(x_0);
                    }
                }
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, select_0, TYP_imperativeocl_c_c_VariableInitExp_1);
                /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_2 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
                /*@NonNull*/ Iterator<?> ITERATOR__1_0 = selectByKind_0.iterator();
                /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
                while (true) {
                    if (!ITERATOR__1_0.hasNext()) {
                        collect_0 = accumulator_2;
                        break;
                    }
                    /*@NonNull*/ /*@NonInvalid*/ VariableInitExp _1_0 = (VariableInitExp)ITERATOR__1_0.next();
                    /**
                     * referredVariable
                     */
                    final /*@NonNull*/ /*@Thrown*/ Variable referredVariable_0 = _1_0.getReferredVariable();
                    //
                    accumulator_2.add(referredVariable_0);
                }
                final /*@NonNull*/ /*@Thrown*/ List<Variable> ECORE_collect_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, collect_0);
                final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner_0 = addElements_0.addElements(ECORE_collect_0);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_10);
                    symbol_1 = parentEnv_0;
                }
                symbol_4 = symbol_1;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ List<OCLExpression> endSection = element_10.getEndSection();
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_endSection = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, endSection);
                final /*@Thrown*/ boolean includes_1 = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_endSection, child).booleanValue();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_3;
                if (includes_1) {
                    final /*@NonNull*/ /*@NonInvalid*/ Class TYP_imperativeocl_c_c_VariableInitExp_2 = idResolver.getClass(CLSSid_VariableInitExp, null);
                    final /*@NonNull*/ /*@Thrown*/ List<Variable> variable_1 = element_10.getVariable();
                    final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_1 = context.addElements(variable_1);
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator_3 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
                    /*@Nullable*/ Iterator<?> ITERATOR_x_1 = BOXED_content.iterator();
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue select_1;
                    while (true) {
                        if (!ITERATOR_x_1.hasNext()) {
                            select_1 = accumulator_3;
                            break;
                        }
                        /*@Nullable*/ /*@NonInvalid*/ OCLExpression x_1 = (OCLExpression)ITERATOR_x_1.next();
                        /**
                         * element.endSection->indexOf(x) < element.endSection->indexOf(child)
                         */
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_3 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_endSection, x_1);
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_4 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_endSection, child);
                        final /*@Thrown*/ boolean lt_1 = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf_3, indexOf_4).booleanValue();
                        //
                        if (lt_1 == ValueUtil.TRUE_VALUE) {
                            accumulator_3.add(x_1);
                        }
                    }
                    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind_1 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, select_1, TYP_imperativeocl_c_c_VariableInitExp_2);
                    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_4 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
                    /*@NonNull*/ Iterator<?> ITERATOR__1_1 = selectByKind_1.iterator();
                    /*@NonNull*/ /*@Thrown*/ SequenceValue collect_1;
                    while (true) {
                        if (!ITERATOR__1_1.hasNext()) {
                            collect_1 = accumulator_4;
                            break;
                        }
                        /*@NonNull*/ /*@NonInvalid*/ VariableInitExp _1_1 = (VariableInitExp)ITERATOR__1_1.next();
                        /**
                         * referredVariable
                         */
                        final /*@NonNull*/ /*@Thrown*/ Variable referredVariable_1 = _1_1.getReferredVariable();
                        //
                        accumulator_4.add(referredVariable_1);
                    }
                    final /*@NonNull*/ /*@Thrown*/ List<Variable> ECORE_collect_1 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, collect_1);
                    final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner_1 = addElements_1.addElements(ECORE_collect_1);
                    final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                    /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_2;
                    if (hasFinalResult_1) {
                        symbol_2 = inner_1;
                    }
                    else {
                        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_1 = this.parentEnv(element_10);
                        symbol_2 = parentEnv_1;
                    }
                    symbol_3 = symbol_2;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_2 = this.parentEnv(element_10);
                    symbol_3 = parentEnv_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * visitMappingCallExp(element : qvtoperational::MappingCallExp[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitMappingCallExp(final /*@NonNull*/ /*@NonInvalid*/ MappingCallExp element_11) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_11);
        return parentEnv;
    }
    
    /**
     * visitMappingOperation(element : qvtoperational::MappingOperation[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.body = child
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElement(element.context)
     *     .addElements(element.result)
     *     .addElements(element.ownedParameters)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if element.when = child
     *   then
     *     let
     *       inner : lookup::LookupEnvironment[1] = context.addElement(element.context)
     *       .addElements(element.ownedParameters)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     if element.where = child
     *     then
     *       let
     *         inner : lookup::LookupEnvironment[1] = context.addElement(element.context)
     *         .addElements(element.ownedParameters)
     *         .addElements(element.result)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     else this.parentEnv(element)
     *     endif
     *   endif
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitMappingOperation(final /*@NonNull*/ /*@NonInvalid*/ MappingOperation element_12) {
        final /*@Nullable*/ /*@Thrown*/ OperationBody body = element_12.getBody();
        final /*@Thrown*/ boolean eq = (body != null) ? body.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_5;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ VarParameter context_0 = element_12.getContext();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElement = context.addElement(context_0);
            final /*@NonNull*/ /*@Thrown*/ List<VarParameter> result = element_12.getResult();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = addElement.addElements(result);
            final /*@NonNull*/ /*@Thrown*/ List<Parameter> ownedParameters = element_12.getOwnedParameters();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ownedParameters);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_12);
                symbol_0 = parentEnv;
            }
            symbol_5 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ OCLExpression when = element_12.getWhen();
            final /*@Thrown*/ boolean eq_0 = (when != null) ? when.equals(child) : (child == null);
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_4;
            if (eq_0) {
                final /*@Nullable*/ /*@Thrown*/ VarParameter context_1 = element_12.getContext();
                final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElement_0 = context.addElement(context_1);
                final /*@NonNull*/ /*@Thrown*/ List<Parameter> ownedParameters_0 = element_12.getOwnedParameters();
                final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner_0 = addElement_0.addElements(ownedParameters_0);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_12);
                    symbol_1 = parentEnv_0;
                }
                symbol_4 = symbol_1;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ OCLExpression where = element_12.getWhere();
                final /*@Thrown*/ boolean eq_1 = (where != null) ? where.equals(child) : (child == null);
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_3;
                if (eq_1) {
                    final /*@Nullable*/ /*@Thrown*/ VarParameter context_2 = element_12.getContext();
                    final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElement_1 = context.addElement(context_2);
                    final /*@NonNull*/ /*@Thrown*/ List<Parameter> ownedParameters_1 = element_12.getOwnedParameters();
                    final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_0 = addElement_1.addElements(ownedParameters_1);
                    final /*@NonNull*/ /*@Thrown*/ List<VarParameter> result_0 = element_12.getResult();
                    final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner_1 = addElements_0.addElements(result_0);
                    final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                    /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_2;
                    if (hasFinalResult_1) {
                        symbol_2 = inner_1;
                    }
                    else {
                        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_1 = this.parentEnv(element_12);
                        symbol_2 = parentEnv_1;
                    }
                    symbol_3 = symbol_2;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_2 = this.parentEnv(element_12);
                    symbol_3 = parentEnv_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * visitMappingParameter(element : qvtoperational::MappingParameter[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitMappingParameter(final /*@NonNull*/ /*@NonInvalid*/ MappingParameter element_13) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_13);
        return parentEnv;
    }
    
    /**
     * visitModelParameter(element : qvtoperational::ModelParameter[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitModelParameter(final /*@NonNull*/ /*@NonInvalid*/ ModelParameter element_14) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_14);
        return parentEnv;
    }
    
    /**
     * visitModelType(element : qvtoperational::ModelType[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.additionalCondition->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.metamodel)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.metamodel)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitModelType(final /*@NonNull*/ /*@NonInvalid*/ ModelType element_15) {
        final /*@NonNull*/ /*@Thrown*/ List<Package> metamodel_0 = element_15.getMetamodel();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner_0 = context.addElements(metamodel_0);
        final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (hasFinalResult_0) {
            symbol_1 = inner_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_15);
            symbol_1 = parentEnv_0;
        }
        final /*@NonNull*/ /*@Thrown*/ List<OCLExpression> additionalCondition = element_15.getAdditionalCondition();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_additionalCondition = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, additionalCondition);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_additionalCondition, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_2;
        if (includes) {
            symbol_2 = symbol_1;
        }
        else {
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitModule(element : qvtoperational::Module[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedProperties)
     *   .addElements(element.ownedOperations)
     *   .addElements(element.ownedVariable)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else
     *     let
     *       inner : lookup::LookupEnvironment[?] = context.addElementsOf(element.moduleImport.module)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitModule(final /*@NonNull*/ /*@NonInvalid*/ Module element_16) {
        final /*@NonNull*/ /*@Thrown*/ List<Property> ownedProperties = element_16.getOwnedProperties();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedProperties);
        final /*@NonNull*/ /*@Thrown*/ List<Operation> ownedOperations = element_16.getOwnedOperations();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ownedOperations);
        final /*@NonNull*/ /*@Thrown*/ List<Variable> ownedVariable = element_16.getOwnedVariable();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements(ownedVariable);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (hasFinalResult) {
            symbol_1 = inner;
        }
        else {
            final /*@NonNull*/ /*@Thrown*/ List<ModuleImport> moduleImport = element_16.getModuleImport();
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_moduleImport = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleImport, moduleImport);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Module);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_moduleImport.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue elements;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    elements = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ ModuleImport _1 = (ModuleImport)ITERATOR__1.next();
                /**
                 * _'null' : qvtoperational::Module[?]
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/pivot/1.0/QVTOperational\'::ModuleImport::module\'");
                }
                final /*@Nullable*/ /*@Thrown*/ Module module = _1.getModule();
                //
                accumulator.add(module);
            }
            /*@NonNull*/ /*@NonInvalid*/ LookupEnvironment acc = context;
            /*@Nullable*/ Iterator<?> ITERATOR_element_25 = elements.iterator();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment iterate;
            while (true) {
                if (!ITERATOR_element_25.hasNext()) {
                    iterate = acc;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ Object element_25 = (Object)ITERATOR_element_25.next();
                /**
                 * _'null' : lookup::LookupEnvironment[?]
                 */
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment envForChild = this.envForChild(element_25, null);
                //
                acc = envForChild;
            }
            if (iterate == null) {
                throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::hasFinalResult() : Boolean[?]\'");
            }
            final /*@Thrown*/ boolean hasFinalResult_0 = iterate.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult_0) {
                symbol_0 = iterate;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_16);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        return symbol_1;
    }
    
    /**
     * visitModuleImport(element : qvtoperational::ModuleImport[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitModuleImport(final /*@NonNull*/ /*@NonInvalid*/ ModuleImport element_17) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_17);
        return parentEnv;
    }
    
    /**
     * visitObjectExp(element : qvtoperational::ObjectExp[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitObjectExp(final /*@NonNull*/ /*@NonInvalid*/ ObjectExp element_18) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_18);
        return parentEnv;
    }
    
    /**
     * visitOperationBody(element : qvtoperational::OperationBody[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.content->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.variable)
     *     .addElements(
     *       element.content->select(x |
     *         element.content->indexOf(x) <
     *         element.content->indexOf(child))
     *       ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitOperationBody(final /*@NonNull*/ /*@NonInvalid*/ OperationBody element_19) {
        final /*@NonNull*/ /*@Thrown*/ List<OCLExpression> content = element_19.getContent();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_content = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, content);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_content, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (includes) {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_imperativeocl_c_c_VariableInitExp_0 = idResolver.getClass(CLSSid_VariableInitExp, null);
            final /*@NonNull*/ /*@Thrown*/ List<Variable> variable = element_19.getVariable();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = context.addElements(variable);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
            /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_content.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ OCLExpression x = (OCLExpression)ITERATOR_x.next();
                /**
                 * element.content->indexOf(x) < element.content->indexOf(child)
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, x);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, select, TYP_imperativeocl_c_c_VariableInitExp_0);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
            /*@NonNull*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                /*@NonNull*/ /*@NonInvalid*/ VariableInitExp _1 = (VariableInitExp)ITERATOR__1.next();
                /**
                 * referredVariable
                 */
                final /*@NonNull*/ /*@Thrown*/ Variable referredVariable = _1.getReferredVariable();
                //
                accumulator_0.add(referredVariable);
            }
            final /*@NonNull*/ /*@Thrown*/ List<Variable> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, collect);
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ECORE_collect);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_19);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_19);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitOperationalTransformation(element : qvtoperational::OperationalTransformation[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.modelParameter->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedProperties)
     *     .addElements(element.ownedOperations)
     *     .addElements(element.ownedVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else
     *       let
     *         inner : lookup::LookupEnvironment[?] = context.addElementsOf(element.moduleImport.module)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     endif
     * else
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedProperties)
     *     .addElements(element.ownedOperations)
     *     .addElements(element.ownedVariable)
     *     .addElements(element.modelParameter)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else
     *       let
     *         inner : lookup::LookupEnvironment[?] = context.addElementsOf(element.moduleImport.module)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     endif
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitOperationalTransformation(final /*@NonNull*/ /*@NonInvalid*/ OperationalTransformation element_20) {
        final /*@NonNull*/ /*@Thrown*/ List<ModelParameter> modelParameter = element_20.getModelParameter();
        final /*@NonNull*/ /*@Thrown*/ List<Operation> ownedOperations = element_20.getOwnedOperations();
        final /*@NonNull*/ /*@Thrown*/ List<Property> ownedProperties = element_20.getOwnedProperties();
        final /*@NonNull*/ /*@Thrown*/ List<Variable> ownedVariable = element_20.getOwnedVariable();
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedProperties);
        final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ownedOperations);
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModelParameter, modelParameter);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_modelParameter, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_4;
        if (includes) {
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements(ownedVariable);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
            if (hasFinalResult) {
                symbol_1 = inner;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ List<ModuleImport> moduleImport = element_20.getModuleImport();
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_moduleImport = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleImport, moduleImport);
                /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Module);
                /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_moduleImport.iterator();
                /*@NonNull*/ /*@Thrown*/ SequenceValue elements;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        elements = accumulator;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ ModuleImport _1 = (ModuleImport)ITERATOR__1.next();
                    /**
                     * _'null' : qvtoperational::Module[?]
                     */
                    if (_1 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/pivot/1.0/QVTOperational\'::ModuleImport::module\'");
                    }
                    final /*@Nullable*/ /*@Thrown*/ Module module = _1.getModule();
                    //
                    accumulator.add(module);
                }
                /*@NonNull*/ /*@NonInvalid*/ LookupEnvironment acc = context;
                /*@Nullable*/ Iterator<?> ITERATOR_element_25 = elements.iterator();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment iterate;
                while (true) {
                    if (!ITERATOR_element_25.hasNext()) {
                        iterate = acc;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ Object element_25 = (Object)ITERATOR_element_25.next();
                    /**
                     * _'null' : lookup::LookupEnvironment[?]
                     */
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment envForChild = this.envForChild(element_25, null);
                    //
                    acc = envForChild;
                }
                if (iterate == null) {
                    throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::hasFinalResult() : Boolean[?]\'");
                }
                final /*@Thrown*/ boolean hasFinalResult_0 = iterate.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
                if (hasFinalResult_0) {
                    symbol_0 = iterate;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_20);
                    symbol_0 = parentEnv;
                }
                symbol_1 = symbol_0;
            }
            symbol_4 = symbol_1;
        }
        else {
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment addElements_3 = addElements_0.addElements(ownedVariable);
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner_0 = addElements_3.addElements(modelParameter);
            final /*@Thrown*/ boolean hasFinalResult_1 = inner_0.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_3;
            if (hasFinalResult_1) {
                symbol_3 = inner_0;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ List<ModuleImport> moduleImport_0 = element_20.getModuleImport();
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_moduleImport_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleImport, moduleImport_0);
                /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Module);
                /*@Nullable*/ Iterator<?> ITERATOR__1_0 = BOXED_moduleImport_0.iterator();
                /*@NonNull*/ /*@Thrown*/ SequenceValue elements_0;
                while (true) {
                    if (!ITERATOR__1_0.hasNext()) {
                        elements_0 = accumulator_0;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ ModuleImport _1_0 = (ModuleImport)ITERATOR__1_0.next();
                    /**
                     * _'null' : qvtoperational::Module[?]
                     */
                    if (_1_0 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/pivot/1.0/QVTOperational\'::ModuleImport::module\'");
                    }
                    final /*@Nullable*/ /*@Thrown*/ Module module_0 = _1_0.getModule();
                    //
                    accumulator_0.add(module_0);
                }
                /*@NonNull*/ /*@NonInvalid*/ LookupEnvironment acc_0 = context;
                /*@Nullable*/ Iterator<?> ITERATOR_element_26 = elements_0.iterator();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment iterate_0;
                while (true) {
                    if (!ITERATOR_element_26.hasNext()) {
                        iterate_0 = acc_0;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ Object element_26 = (Object)ITERATOR_element_26.next();
                    /**
                     * _'null' : lookup::LookupEnvironment[?]
                     */
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment envForChild_0 = this.envForChild(element_26, null);
                    //
                    acc_0 = envForChild_0;
                }
                if (iterate_0 == null) {
                    throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::hasFinalResult() : Boolean[?]\'");
                }
                final /*@Thrown*/ boolean hasFinalResult_2 = iterate_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_2;
                if (hasFinalResult_2) {
                    symbol_2 = iterate_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_20);
                    symbol_2 = parentEnv_0;
                }
                symbol_3 = symbol_2;
            }
            symbol_4 = symbol_3;
        }
        return symbol_4;
    }
    
    /**
     * visitResolveExp(element : qvtoperational::ResolveExp[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if element.condition = child
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElement(element.target)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitResolveExp(final /*@NonNull*/ /*@NonInvalid*/ ResolveExp element_21) {
        final /*@Nullable*/ /*@Thrown*/ OCLExpression condition = element_21.getCondition();
        final /*@Thrown*/ boolean eq = (condition != null) ? condition.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_1;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ Variable target = element_21.getTarget();
            final /*@NonNull*/ /*@Thrown*/ LookupEnvironment inner = context.addElement(target);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_21);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_21);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitResolveInExp(element : qvtoperational::ResolveInExp[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitResolveInExp(final /*@NonNull*/ /*@NonInvalid*/ ResolveInExp element_22) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_22);
        return parentEnv;
    }
    
    /**
     * visitTag(element : qvtoperational::Tag[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitTag(final /*@NonNull*/ /*@NonInvalid*/ Tag element_23) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_23);
        return parentEnv;
    }
    
    /**
     * visitVarParameter(element : qvtoperational::VarParameter[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ LookupEnvironment visitVarParameter(final /*@NonNull*/ /*@NonInvalid*/ VarParameter element_24) {
        final /*@Nullable*/ /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_24);
        return parentEnv;
    }
}
