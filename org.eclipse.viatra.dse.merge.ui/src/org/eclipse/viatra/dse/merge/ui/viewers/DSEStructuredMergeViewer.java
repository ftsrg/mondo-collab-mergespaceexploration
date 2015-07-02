package org.eclipse.viatra.dse.merge.ui.viewers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.viatra.dse.merge.DSEMergeManager;
import org.eclipse.viatra.dse.merge.DSEMergeManager.Solution;
import org.eclipse.viatra.dse.merge.model.ChangeSet;

public class DSEStructuredMergeViewer extends TreeViewer {

	private CompareConfiguration config;
	private ChangeSet changeOR;
	private ChangeSet changeOL;
	private Resource original;
	private Resource local;
	private ReflectiveItemProviderAdapterFactory adapterFactory = new ReflectiveItemProviderAdapterFactory();
	private Solution selectedSolution;	
	
	public DSEStructuredMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent);
		this.config = config;
		initialize(parent);
	}
	
	private void initialize(Composite parent) {
		
		setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		config.addPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if(event.getProperty().equals(DSEContentMergeViewer.CHANGESET_OL)) {
					changeOL = (ChangeSet) event.getNewValue();
				}
				
				if(event.getProperty().equals(DSEContentMergeViewer.CHANGESET_OR)) {
					changeOR = (ChangeSet) event.getNewValue();
				}
				
				if(event.getProperty().equals(DSEContentMergeViewer.ANCESTOR)) {
					original = (Resource) event.getNewValue();
					Display.getDefault().syncExec(new Runnable() {
					    public void run() {
					    	setInput(original.getContents().get(0));
					    }
					});
				}
				if(event.getProperty().equals(DSEContentMergeViewer.LEFT)) {
					local = (Resource) event.getNewValue();
					
				}
				if(event.getProperty().equals(DSEContentMergeViewer.SELECTED_SOLUTION)) {
					selectedSolution = (Solution) event.getNewValue();
					applyMerge.setEnabled(true);
				}
			}
		});
		
		addActions(parent);
	}

	private Action executeMerge = new Action("Execute Merge") {
		public void run() {
			executeMerge();
		};
	};
	
	private Action applyMerge = new Action("Apply Selected Solution") {
		public void run() {
			EObject newOrigin = selectedSolution.getScope().getOrigin();
			Resource resource = local;
			resource.getContents().clear();
			resource.getContents().add(newOrigin);
			try {
				resource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	};
	
	private void addActions(Composite parent) {
		ToolBarManager tbm= CompareViewerPane.getToolBarManager(parent);
		if (tbm != null) {
			tbm.removeAll();
			tbm.add(executeMerge);
			tbm.add(applyMerge);
			applyMerge.setEnabled(false);
			tbm.update(true);
		}
	}

	private void executeMerge() {
		final DSEMergeManager manager = DSEMergeManager.create(original.getContents().get(0), changeOL, changeOR);
		
		IProgressService service = PlatformUI.getWorkbench().getProgressService();
		try {
			service.run(true, false, new IRunnableWithProgress() {
				
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Searching solutions...", 1);
					Collection<Solution> solutions = manager.start();
					monitor.worked(1);
					config.setProperty(DSEContentMergeViewer.SOLUTIONS, solutions);
					monitor.done();
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
