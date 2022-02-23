package cp.week7;

import javax.sound.sampled.SourceDataLine;

/**
 * 
 * @author Fabrizio Montesi
 */
 public class LambdaExercise1
 {
	/*
	Create a class Box<T> with a single final field of type T called "content".
	Its constructor must take the content as parameter and set it.
	
	Add a public method called "content()" that returns the content of the box.
	*/
	public static void main(String[] args) {
		
		Box<Integer> item = new Box<Integer>(5);

		System.out.println(item.content());
	}

 }
