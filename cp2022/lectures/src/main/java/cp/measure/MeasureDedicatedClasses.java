package cp.measure;

import cp.Utils;

public class MeasureDedicatedClasses {
	// 1 + 2 + 3 + 4 and then we add n so 5 for example if n=5
	public static int summation( int n ) {
		if( n < 1 ) {
			return 0;
		}
		return n + summation( n - 1 );
	}

	private static class Sum5Runnable implements Runnable {
		public void run() {
			System.out.println( "Result: " + summation( 5 ) );
		}
	}

	public static void main() {
		// I use utils do and measure method so i can count the elapsed time as well
		Utils.doAndMeasure( new Sum5Runnable() );
	}
}
