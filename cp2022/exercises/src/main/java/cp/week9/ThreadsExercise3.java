package cp.week9;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class ThreadsExercise3
{
	/*
	Modify the threads/cp/SynchronizedMap2T example such that:
	- There are now two maps (instead of just one) for accumulating results, one for each thread.
	- Each thread uses only its own map, without synchronizing on it.
	- After the threads terminate, create a new map where you merge the results of the two dedicated maps.
	
	Questions:
	- Does the resulting code work? Can you explain why?
	- Does the resulting code perform better or worse than the original example SynchronizedMap2T?
	- Can you hypothesise why?
	*/
	public static void main(String[] args) {
		SynchronizedMap2TModified.main();
	}

	/*
	Answers to the questions
	- Does the resulting code work? Can you explain why?
		- It works bcs there is no shared data being handled on different threads.
	- Does the resulting code perform better or worse than the original example SynchronizedMap2T?
		- It performs better 
	- Can you hypothesise why?
		- Because the program has way less time waiting for access to write and read.
	*/
}
