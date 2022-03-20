package cp.week12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import cp.week10.Words;

public class SynchronizedMap2
{
	public static void main()
	{

        AtomicInteger totalL = new AtomicInteger(0);

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
				computeOccurrences( filename, occurrences, totalL );
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
	}
	
	private static void computeOccurrences( String filename, Map< String, Integer > occurrences, AtomicInteger totalL )
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

                    Files.lines(Paths.get(filename))
                    .flatMap(Words::extractWords)
                    .filter(s -> s.startsWith("L"))
                    .forEach(s -> {
                        totalL.getAndIncrement();
                    });

		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}


