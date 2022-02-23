package cp.week7;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Fabrizio Montesi
 */
public class LambdaExercise3
{
	/*
	NOTE: When I write Class::methodName, I don't mean to use a method reference (lambda expression), I'm simply
	talking about a particular method.
	*/
	
	/*
	- Create a Box that contains an ArrayList<String> with some elements of your preference.
	- Now compute a sorted version of your list by invoking Box::apply, passing a lambda expression that uses List::sort.
	*/
	public static void main(String[] args) {
		ArrayList<String> array = new  ArrayList<String>();
		array.add("d");
		array.add("b");
		array.add("a");
		array.add("c");
		Box<ArrayList<String>> itemBox = new Box<ArrayList<String>>(array);
		// Not finished 
		itemBox.apply( a -> {Collections.sort(a); return null;});

		System.out.println(itemBox.content());
	}
}
