package cp.week9;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class ThreadsExercise1
{
	/*
	- Create a Counter class storing an integer (a field called i), with an increment and decrement method.
	- Make Counter thread-safe (see Chapter 2 in the book)
	- Does it make a different to declare i private or public?
	-> Seems like it doesn't make a difference
	*/
	public static void main(String[] args) {
		counter count = new counter(1);

		count.increment();
		count.increment();
		count.decrement();
		System.out.println(count.getI());
	}
}
