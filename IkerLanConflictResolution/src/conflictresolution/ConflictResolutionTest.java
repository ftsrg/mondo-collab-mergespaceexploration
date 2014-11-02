package conflictresolution;

import static org.junit.Assert.assertTrue;
import goals.CheckDifferences;
import goals.DifferencesSolutionStore;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.PatternWithCardinality;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.api.strategy.Strategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.designspace.impl.pojo.ConcurrentDesignSpace;
import org.eclipse.viatra.dse.statecode.graph.GraphHasherFactory;
import org.eclipse.viatra.dse.statecode.incrementalgraph.IncrementalGraphHasherFactory;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.junit.Test;

//import patterns.CountOperationsMatcher;
import patterns.CreateMatch;
import patterns.CreateMatcher;
import rules.CreateElement;
import rules.DeleteElement;
import rules.ResetAttribute;
import rules.ResetReference;
import rules.SetAttribute;
import rules.SetReference;
import statecoder.IkerLanStateCoderFactory;
import DiffModel.DiffContainer;
import DiffModel.DiffModelPackage;
import ModelContainer.MainRoot;
import ModelContainer.ModelContainerFactory;
import ModelContainer.ModelContainerPackage;
import WTSpecID.WT;
import WTSpecID.WTSpecIDPackage;

public class ConflictResolutionTest {

	@Test
	public void test() throws IncQueryException {

		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.ERROR);
		Logger.getLogger(DesignSpaceManager.class).setLevel(Level.DEBUG);
		Logger.getLogger(ConcurrentDesignSpace.class).setLevel(Level.DEBUG);

		DesignSpaceExplorer dse = new DesignSpaceExplorer();

		ResourceSet rS = new ResourceSetImpl();

		// loading models
		Resource original = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/original.wtspecid",
				true), true);

		Resource modA = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/A.wtspecid", true),
				true);

		Resource modB = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/B.wtspecid", true),
				true);

		Resource deltaOA = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/deltaOA.diffmodel",
				true), true);

		Resource deltaOB = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/deltaOB.diffmodel",
				true), true);

		MainRoot mainRoot = ModelContainerFactory.eINSTANCE.createMainRoot();

		WT originalRoot = (WT) original.getContents().get(0);
		DiffContainer deltaOBRoot = (DiffContainer) deltaOB.getContents()
				.get(0);
		DiffContainer deltaOARoot = (DiffContainer) deltaOA.getContents()
				.get(0);

		mainRoot.setOriginal(originalRoot);
		mainRoot.setDeltaOA(deltaOARoot);
		mainRoot.setDeltaOB(deltaOBRoot);

		dse.setStartingModel(mainRoot);

		// TODO setting MaxNumberOfThreads
		//dse.setMaxNumberOfThreads(1);

		// adding metamodel packages
		dse.addMetaModelPackage(ModelContainerPackage.eINSTANCE);
		dse.addMetaModelPackage(WTSpecIDPackage.eINSTANCE);
		dse.addMetaModelPackage(DiffModelPackage.eINSTANCE);

		// dse.setSerializerFactory(new IncrementalGraphHasherFactory(dse
		// .getMetaModelPackages()));
		// dse.setSerializerFactory(new GraphHasherFactory());
		dse.setSerializerFactory(new IkerLanStateCoderFactory());

		// adding rules
		dse.addTransformationRule(CreateElement.createRule());
		//dse.addTransformationRule(DeleteElement.createRule());
		dse.addTransformationRule(SetAttribute.createRule());
		dse.addTransformationRule(SetReference.createRule());
		dse.addTransformationRule(ResetAttribute.createRule());
		dse.addTransformationRule(ResetReference.createRule());

		// dse.addGoalPattern(new
		// PatternWithCardinality(CountOperationsMatcher.querySpecification()));

		dse.setSolutionStore(new DifferencesSolutionStore());

		boolean waitForTermination = true;
		Strategy strategy = Strategies.createBFSStrategy(1, 100);

		strategy.setGoalStateChecker(new CheckDifferences(original, modA, modB));

		System.out.println("BEFORE startExploration");

		dse.startExploration(strategy, waitForTermination);

		System.out.println("AFTER startExploration");

		Collection<Solution> solutions = dse.getAllSolutions();
		System.out.println(solutions.size());
		int s = 1;

		if (!solutions.isEmpty()) {
			System.out.println("there is at least 1 solution");
			Solution solution = dse.getAllSolutions().iterator().next();
			SolutionTrajectory solutionTrajectory = solution
					.getArbitraryTrajectory();

			System.out.println("BEFORE transformation");

			// Transform the model
			solutionTrajectory.setModel(IncQueryEngine.on(mainRoot));
			solutionTrajectory.doTransformation();
			
			System.out.println("AFTER transformation");

			Date d = new Date();
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
					"MM.dd.'at'.HH.mm.ss");
			String date = DATE_FORMAT.format(d);
			EMFHelper.serializeModel(mainRoot, "solution_" + date + "_Number"
					+ s++, "modelcontainer");

			System.out.println("AFTER serialization");

		}

	}

	@Test
	public void testIncQuery() throws IncQueryException {

		ResourceSet rS = new ResourceSetImpl();

		// loading models
		Resource original = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/original.wtspecid",
				true), true);

		Resource modA = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/A.wtspecid", true),
				true);

		Resource modB = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/B.wtspecid", true),
				true);

		Resource deltaOA = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/deltaOA.diffmodel",
				true), true);

		Resource deltaOB = rS.getResource(URI.createPlatformPluginURI(
				"/IkerLanConflictResolution/instancemodels/deltaOB.diffmodel",
				true), true);

		// appending models for IncQuery
		// MainRoot mainRoot = (MainRoot)
		// originalWithDeltas.getContents().get(0);
		MainRoot mainRoot = ModelContainerFactory.eINSTANCE.createMainRoot();

		WT originalRoot = (WT) original.getContents().get(0);
		DiffContainer deltaOBRoot = (DiffContainer) deltaOB.getContents()
				.get(0);
		DiffContainer deltaOARoot = (DiffContainer) deltaOA.getContents()
				.get(0);

		mainRoot.setOriginal(originalRoot);
		mainRoot.setDeltaOA(deltaOARoot);
		mainRoot.setDeltaOB(deltaOBRoot);

		CheckDifferences cd = new CheckDifferences(original, modA, modB);
		cd.isGoalState(null);

		IncQueryEngine engine = IncQueryEngine.on(mainRoot);
		CreateMatcher matcher = CreateMatcher.on(engine);
		assertTrue(matcher.countMatches() > 0);
		for (CreateMatch match : matcher.getAllMatches()) {
			System.out.println(match.getCreateOp().getID() + ": "
					+ match.getCreateOp().getTargetID());
		}
	}
}
