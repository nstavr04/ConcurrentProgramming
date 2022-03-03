package cp.threads;

public class Counting {
	private static class Counter {
		private int c = 0;
	}

	public static void main() {
		Counter counter = new Counter();

		Thread t1 = new Thread( () -> {
			int i = 0;
			while( i++ < 1000 ) {
				synchronized( counter ) {
					counter.c++;
				}
			}
		} );

		Thread t2 = new Thread( () -> {
			int i = 0;
			while( i++ < 1000 ) {
				synchronized( counter ) {
					counter.c++;
				}
			}
		} );

		Thread t3 = new Thread( () -> {
			int i = 0;
			while( i++ < 1000 ) {
				synchronized( counter ) {
					counter.c++;
				}
			}
		} );

		// t1, t2, t3 have not started
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			System.out.println( counter.c );
			// Vlepw oti den athrizei sto 3000.
			// Giafto thelw otan paei na kanei ++ ena thread
			// na min epemvenei allo.
			// Afto to petigxainw me to synchronized
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
