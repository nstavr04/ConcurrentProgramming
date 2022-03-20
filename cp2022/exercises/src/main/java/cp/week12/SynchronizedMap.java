package cp.week12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import cp.week10.Words;

public class SynchronizedMap
{
	public static void main()
	{

        ArrayList<Integer> totalL = new ArrayList<>();

		// word -> number of times that it appears over all files
		Map< String, Integer > occurrences = new HashMap<>();
		
		List< String > filenames = List.of(
			"text1.txt",
			"text2.txt",
			"text3.txt",
			"text4.txt",
			"text5.txt",
			"text6.txt",
			"text7.txt",
			"text8.txt",
			"text9.txt",
			"text10.txt"
		);
		
		CountDownLatch latch = new CountDownLatch( filenames.size() );
		
		filenames.stream()
			.map( filename -> new Thread( () -> {
				int tot = computeOccurrences( filename, occurrences );
                synchronized(totalL){
                    totalL.add(tot);
                }
				latch.countDown();
			} ) )
			.forEach( Thread::start );

		try {
			latch.await();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
		
		occurrences.forEach( (word, n) -> System.out.println( word + ": " + n ) );
        System.out.println(totalL);
        Integer sum = 0;
        for (Integer local : totalL) {
            sum += local;
        }
        System.out.println("Total sum: " + sum);
	}
	
	private static int computeOccurrences( String filename, Map< String, Integer > occurrences )
	{
		try {
			Files.lines( Paths.get( filename ) )
				.flatMap( Words::extractWords )
				.map( String::toLowerCase )
				.forEach( s -> {
					synchronized( occurrences ) {
						occurrences.merge( s, 1, Integer::sum );
					}
				} );

                Long l = Files.lines(Paths.get(filename))
                    .flatMap(Words::extractWords)
                    .filter(s -> s.startsWith("L"))
                    .count();

                    int numberL = l.intValue();
                    return numberL;

		} catch( IOException e ) {
			e.printStackTrace();
            return 0;
		}
	}
}

