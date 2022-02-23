package cp.week7;

import java.util.ArrayList;

/**
 * 
 * @author Fabrizio Montesi
 */
public class LambdaExercise4
{
	/*
	- Create a list of type ArrayList<String> with some elements of your preference.
	- Create a Box that contains the list.
	- Now compute the sum of the lengths of all strings in the list inside of the box,
	  by invoking Box::apply with a lambda expression.
	*/
	public static void main(String[] args) {
		ArrayList<String> array = new  ArrayList<String>();
		array.add("d");
		array.add("b");
		array.add("a");
		array.add("c");
		Box<ArrayList<String>> itemBox = new Box<ArrayList<String>>(array);
		// Not finished 
		System.out.println(itemBox.content());

		int sum = itemBox.apply((a) -> {
			int sLength = 0;
			for (String string: a)
				sLength += string.length();
			return sLength;
		});
		System.out.println("Number of chars: " + sum);
	}
}
