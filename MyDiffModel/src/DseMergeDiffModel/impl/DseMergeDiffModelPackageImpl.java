/**
 */
package DseMergeDiffModel.impl;

import DseMergeDiffModel.Create;
import DseMergeDiffModel.Delete;
import DseMergeDiffModel.DiffContainer;
import DseMergeDiffModel.DseMergeDiffModelFactory;
import DseMergeDiffModel.DseMergeDiffModelPackage;
import DseMergeDiffModel.Identifiable;
import DseMergeDiffModel.ResetAttribute;
import DseMergeDiffModel.ResetReference;
import DseMergeDiffModel.SetAttribute;
import DseMergeDiffModel.SetReference;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DseMergeDiffModelPackageImpl extends EPackageImpl implements DseMergeDiffModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diffContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see DseMergeDiffModel.DseMergeDiffModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DseMergeDiffModelPackageImpl() {
		super(eNS_URI, DseMergeDiffModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DseMergeDiffModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DseMergeDiffModelPackage init() {
		if (isInited) return (DseMergeDiffModelPackage)EPackage.Registry.INSTANCE.getEPackage(DseMergeDiffModelPackage.eNS_URI);

		// Obtain or create and register package
		DseMergeDiffModelPackageImpl theDseMergeDiffModelPackage = (DseMergeDiffModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DseMergeDiffModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DseMergeDiffModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDseMergeDiffModelPackage.createPackageContents();

		// Initialize created meta-data
		theDseMergeDiffModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDseMergeDiffModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DseMergeDiffModelPackage.eNS_URI, theDseMergeDiffModelPackage);
		return theDseMergeDiffModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiffContainer() {
		return diffContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiffContainer_CreateDiffs() {
		return (EReference)diffContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiffContainer_DeleteDiffs() {
		return (EReference)diffContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiffContainer_SetAttrDiffs() {
		return (EReference)diffContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiffContainer_SetRefDiffs() {
		return (EReference)diffContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiffContainer_ResetAttrDiffs() {
		return (EReference)diffContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiffContainer_ResetRefDiffs() {
		return (EReference)diffContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreate() {
		return createEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreate_Type() {
		return (EAttribute)createEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreate_Attributes() {
		return (EAttribute)createEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreate_Values() {
		return (EAttribute)createEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreate_Reference() {
		return (EAttribute)createEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreate_ContainerTargetID() {
		return (EAttribute)createEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelete() {
		return deleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetAttribute() {
		return setAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetAttribute_Attribute() {
		return (EAttribute)setAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetAttribute_Value() {
		return (EAttribute)setAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetReference() {
		return setReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetReference_Reference() {
		return (EAttribute)setReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetReference_RefID() {
		return (EAttribute)setReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResetAttribute() {
		return resetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResetAttribute_Attribute() {
		return (EAttribute)resetAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResetReference() {
		return resetReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResetReference_Reference() {
		return (EAttribute)resetReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResetReference_RefID() {
		return (EAttribute)resetReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_ID() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_TargetID() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DseMergeDiffModelFactory getDseMergeDiffModelFactory() {
		return (DseMergeDiffModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		diffContainerEClass = createEClass(DIFF_CONTAINER);
		createEReference(diffContainerEClass, DIFF_CONTAINER__CREATE_DIFFS);
		createEReference(diffContainerEClass, DIFF_CONTAINER__DELETE_DIFFS);
		createEReference(diffContainerEClass, DIFF_CONTAINER__SET_ATTR_DIFFS);
		createEReference(diffContainerEClass, DIFF_CONTAINER__SET_REF_DIFFS);
		createEReference(diffContainerEClass, DIFF_CONTAINER__RESET_ATTR_DIFFS);
		createEReference(diffContainerEClass, DIFF_CONTAINER__RESET_REF_DIFFS);

		createEClass = createEClass(CREATE);
		createEAttribute(createEClass, CREATE__TYPE);
		createEAttribute(createEClass, CREATE__ATTRIBUTES);
		createEAttribute(createEClass, CREATE__VALUES);
		createEAttribute(createEClass, CREATE__REFERENCE);
		createEAttribute(createEClass, CREATE__CONTAINER_TARGET_ID);

		deleteEClass = createEClass(DELETE);

		setAttributeEClass = createEClass(SET_ATTRIBUTE);
		createEAttribute(setAttributeEClass, SET_ATTRIBUTE__ATTRIBUTE);
		createEAttribute(setAttributeEClass, SET_ATTRIBUTE__VALUE);

		setReferenceEClass = createEClass(SET_REFERENCE);
		createEAttribute(setReferenceEClass, SET_REFERENCE__REFERENCE);
		createEAttribute(setReferenceEClass, SET_REFERENCE__REF_ID);

		resetAttributeEClass = createEClass(RESET_ATTRIBUTE);
		createEAttribute(resetAttributeEClass, RESET_ATTRIBUTE__ATTRIBUTE);

		resetReferenceEClass = createEClass(RESET_REFERENCE);
		createEAttribute(resetReferenceEClass, RESET_REFERENCE__REFERENCE);
		createEAttribute(resetReferenceEClass, RESET_REFERENCE__REF_ID);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__ID);
		createEAttribute(identifiableEClass, IDENTIFIABLE__TARGET_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		createEClass.getESuperTypes().add(this.getIdentifiable());
		deleteEClass.getESuperTypes().add(this.getIdentifiable());
		setAttributeEClass.getESuperTypes().add(this.getIdentifiable());
		setReferenceEClass.getESuperTypes().add(this.getIdentifiable());
		resetAttributeEClass.getESuperTypes().add(this.getIdentifiable());
		resetReferenceEClass.getESuperTypes().add(this.getIdentifiable());

		// Initialize classes, features, and operations; add parameters
		initEClass(diffContainerEClass, DiffContainer.class, "DiffContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiffContainer_CreateDiffs(), this.getCreate(), null, "CreateDiffs", null, 0, -1, DiffContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiffContainer_DeleteDiffs(), this.getDelete(), null, "DeleteDiffs", null, 0, -1, DiffContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiffContainer_SetAttrDiffs(), this.getSetAttribute(), null, "SetAttrDiffs", null, 0, -1, DiffContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiffContainer_SetRefDiffs(), this.getSetReference(), null, "SetRefDiffs", null, 0, -1, DiffContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiffContainer_ResetAttrDiffs(), this.getResetAttribute(), null, "ResetAttrDiffs", null, 0, -1, DiffContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiffContainer_ResetRefDiffs(), this.getResetReference(), null, "ResetRefDiffs", null, 0, -1, DiffContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createEClass, Create.class, "Create", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreate_Type(), ecorePackage.getEString(), "type", null, 0, 1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreate_Attributes(), ecorePackage.getEString(), "attributes", null, 0, -1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreate_Values(), ecorePackage.getEString(), "values", null, 0, -1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreate_Reference(), ecorePackage.getEString(), "reference", null, 0, 1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreate_ContainerTargetID(), ecorePackage.getEString(), "containerTargetID", null, 0, 1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteEClass, Delete.class, "Delete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setAttributeEClass, SetAttribute.class, "SetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetAttribute_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, SetAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, SetAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setReferenceEClass, SetReference.class, "SetReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetReference_Reference(), ecorePackage.getEString(), "reference", null, 0, 1, SetReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetReference_RefID(), ecorePackage.getEString(), "refID", null, 0, 1, SetReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resetAttributeEClass, ResetAttribute.class, "ResetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResetAttribute_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, ResetAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resetReferenceEClass, ResetReference.class, "ResetReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResetReference_Reference(), ecorePackage.getEString(), "reference", null, 0, 1, ResetReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResetReference_RefID(), ecorePackage.getEString(), "refID", null, 0, 1, ResetReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_ID(), ecorePackage.getEString(), "ID", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentifiable_TargetID(), ecorePackage.getEString(), "targetID", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DseMergeDiffModelPackageImpl
