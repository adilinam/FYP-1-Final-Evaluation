/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mapping Extension Kind CS</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#getMappingExtensionKindCS()
 * @model
 * @generated
 */
public enum MappingExtensionKindCS implements Enumerator {
	/**
	 * The '<em><b>Disjuncts</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISJUNCTS_VALUE
	 * @generated
	 * @ordered
	 */
	DISJUNCTS(1, "disjuncts", "disjuncts"),

	/**
	 * The '<em><b>Merges</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERGES_VALUE
	 * @generated
	 * @ordered
	 */
	MERGES(2, "merges", "merges"),

	/**
	 * The '<em><b>Inherits</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERITS_VALUE
	 * @generated
	 * @ordered
	 */
	INHERITS(3, "inherits", "inherits");

	/**
	 * The '<em><b>Disjuncts</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disjuncts</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISJUNCTS
	 * @model name="disjuncts"
	 * @generated
	 * @ordered
	 */
	public static final int DISJUNCTS_VALUE = 1;

	/**
	 * The '<em><b>Merges</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Merges</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MERGES
	 * @model name="merges"
	 * @generated
	 * @ordered
	 */
	public static final int MERGES_VALUE = 2;

	/**
	 * The '<em><b>Inherits</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inherits</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INHERITS
	 * @model name="inherits"
	 * @generated
	 * @ordered
	 */
	public static final int INHERITS_VALUE = 3;

	/**
	 * An array of all the '<em><b>Mapping Extension Kind CS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MappingExtensionKindCS[] VALUES_ARRAY =
		new MappingExtensionKindCS[] {
			DISJUNCTS,
			MERGES,
			INHERITS,
		};

	/**
	 * A public read-only list of all the '<em><b>Mapping Extension Kind CS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MappingExtensionKindCS> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mapping Extension Kind CS</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MappingExtensionKindCS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MappingExtensionKindCS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mapping Extension Kind CS</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MappingExtensionKindCS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MappingExtensionKindCS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mapping Extension Kind CS</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MappingExtensionKindCS get(int value) {
		switch (value) {
			case DISJUNCTS_VALUE: return DISJUNCTS;
			case MERGES_VALUE: return MERGES;
			case INHERITS_VALUE: return INHERITS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private MappingExtensionKindCS(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //MappingExtensionKindCS
