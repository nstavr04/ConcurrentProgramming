package cp;

import cp.measure.MeasureAnonymousClasses;
import cp.measure.MeasureDedicatedClasses;
import cp.measure.MeasureLambda;
import cp.threads.SynchronizedMap;
import cp.threads.WalkCompletionService;
import cp.threads.WalkExecutorFuture;
import cp.threads.Counting;

/**
 * Main class (entry point) of the Java Application.
 */
public final class App {
	/**
	 * Entry point method of the Java application.
	 * 
	 * @param args The arguments of the program.
	 */
	public static void main( String[] args ) {
		// FirstThread.main();
		// Counting.main();
		// Utils.doAndMeasure( SequentialMap2F::main );
		// Utils.doAndMeasure( SynchronizedMap2T::main );
		// SynchronizedMap2TWords.main();
		//SynchronizedMap.main();

		//MeasureDedicatedClasses.main();
		//MeasureAnonymousClasses.main();
		//MeasureLambda.main();


		Utils.doAndMeasure(WalkExecutorFuture::main);

		// Walk completition service is the one expected to be used in the exam
		//Utils.doAndMeasure(WalkCompletionService::main);
		
	}
}
