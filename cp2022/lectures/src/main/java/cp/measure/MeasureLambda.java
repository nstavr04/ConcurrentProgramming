package cp.measure;

import cp.Utils;

public class MeasureLambda {
	public static int summation( int n ) {
		if( n < 1 ) {
			return 0;
		}
		return n + summation( n - 1 );
	}

	public static void main() {
		// Taking it a step further and passing it like an expression with lambda
		Utils.doAndMeasure( () -> {
			System.out.println( "Result: " + summation( 5 ) );
		} );
		// Equivalent
		// They are equivalent because doAndMeasure knows it needs a Runnable parameter
		// so java puts it and that we only need to define the run function so again
		// we dont need to declare it
		
		// Utils.doAndMeasure(new Runnable(){
		// 	public void run(){
		// 		System.out.println("Result " + summation(5));
		// 	}	
		// } );
	}
}
