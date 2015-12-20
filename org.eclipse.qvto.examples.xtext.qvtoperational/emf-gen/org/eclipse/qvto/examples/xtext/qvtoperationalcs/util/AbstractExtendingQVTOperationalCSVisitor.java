/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.qvtoperational/model/QVTOperationalCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.xtext.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTOperationalCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTOperationalCSVisitor<R, C>
	extends org.eclipse.qvto.examples.xtext.imperativeoclcs.util.AbstractExtendingImperativeOCLCSVisitor<R, C>
	implements QVTOperationalCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTOperationalCSVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitClassifierDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitClassifierProperty2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS object) {
		return visitLocalPropertyCS(object);
	}

	public @Nullable R visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable R visitCompleteSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitConfigPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS object) {
		return visitModulePropertyCS(object);
	}

	public @Nullable R visitConstructorCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS object) {
		return visitMappingMethodCS(object);
	}

	public @Nullable R visitContextualPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS object) {
		return visitModulePropertyCS(object);
	}

	public @Nullable R visitElementWithBody(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody object) {
		return visitElementCS(object);
	}

	public @Nullable R visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ExceptionCS object) {
		return visitClassCS(object);
	}

	public @Nullable R visitImperativeOperationCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS object) {
		return visitCallExpCS(object);
	}

	public @Nullable R visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitLibraryImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.LibraryImportCS object) {
		return visitQVToImportCS(object);
	}

	public @Nullable R visitLocalPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS object) {
		return visitModulePropertyCS(object);
	}

	public @Nullable R visitMappingBodyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS object) {
		return visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS object) {
		return visitImperativeOperationCallExpCS(object);
	}

	public @Nullable R visitMappingEndCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingEndCS object) {
		return visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingInitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingInitCS object) {
		return visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingMethodCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitMappingOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable R visitMappingQueryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS object) {
		return visitMappingMethodCS(object);
	}

	public @Nullable R visitMappingRuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS object) {
		return visitMappingMethodCS(object);
	}

	public @Nullable R visitMappingSectionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitMappingSectionsCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS object) {
		return visitPackageCS(object);
	}

	public @Nullable R visitModelTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS object) {
		return visitClassCS(object);
	}

	public @Nullable R visitModelTypeRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeRefCS object) {
		return visitParameterCS(object);
	}

	public @Nullable R visitModuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS object) {
		return visitStructuredClassCS(object);
	}

	public @Nullable R visitModuleKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitModulePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModulePropertyCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitModuleRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitModuleUsageCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitMultiplicityDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitObjectExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS object) {
		return visitExpressionBlockCS(object);
	}

	public @Nullable R visitOppositePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPackageRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS object) {
		return visitParameterCS(object);
	}

	public @Nullable R visitPathElement2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS object) {
		return visitPivotableElementCS(object);
	}

	public @Nullable R visitPathName2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS object) {
		return visitPivotableElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.PrimitiveTypeCS object) {
		return visitDataTypeCS(object);
	}

	public @Nullable R visitQVToClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS object) {
		return visitStructuredClassCS(object);
	}

	public @Nullable R visitQVToImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS object) {
		return visitImportCS(object);
	}

	public @Nullable R visitQVToLibraryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToLibraryCS object) {
		return visitModuleCS(object);
	}

	public @Nullable R visitQVToOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable R visitRenameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitResolveExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS object) {
		return visitCallExpCS(object);
	}

	public @Nullable R visitResolveInExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS object) {
		return visitResolveExpCS(object);
	}

	public @Nullable R visitResolveOpArgsExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitScopedNameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS object) {
		return visitAnnotationCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS object) {
		return visitModuleCS(object);
	}

	public @Nullable R visitTransformationRefineCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitTypeSpecCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitTypedTypeRef2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS object) {
		return visitElementCS(object);
	}
}
