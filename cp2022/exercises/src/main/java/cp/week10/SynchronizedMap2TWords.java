package cp.week10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SynchronizedMap2TWords {
	public static void main() {
		// word -> number of times that it appears over all files
		// Map< String, Integer > occurrences = new HashMap<>();

		// Thread t1 = new Thread( () -> computeOccurrences( "text1.txt", occurrences ) );
		// Thread t2 = new Thread( () -> computeOccurrences( "text2.txt", occurrences ) );

		// t1.start();
		// t2.start();
		// try {
		// 	t1.join();
		// 	t2.join();
		// } catch( InterruptedException e ) {
		// 	e.printStackTrace();
		// }

		// occurrences.forEach( (word, n) -> System.out.println( word + ": " + n ) );
        List<String> filenames = List.of(
            "C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week10/text1.txt",
            "C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week10/text1.txt",
            "C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week10/text1.txt"
        );

        System.out.println(computeOccurrencesSequential(filenames.stream()));
        System.out.println(computeOccurrencesConcurrent(filenames.stream()));
	}

    public static Map<String,Integer> computeOccurrencesSequential(Stream<String> filenames){
        Map< String, Integer > occurrences = new HashMap<>();

        filenames.forEach(s -> computeOccurrences(s, occurrences));

        return occurrences;
    }

    public static Map<String,Integer> computeOccurrencesConcurrent(Stream<String> filenames){
        Map< String, Integer > occurrences = new HashMap<>();

        List<Thread> threads = new ArrayList<>();

        filenames.forEach(s -> {
            Thread t = new Thread(() -> computeOccurrences(s, occurrences));
            threads.add(t);
        });

        for(Thread thread : threads)
            thread.start();
        
        try{
            for(Thread thread : threads)
                thread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        return occurrences;
    }

    private static void computeOccurrences(String filename, Map<String, Integer> occurrences) {
		try {
			Files.lines( Paths.get( filename ) ).flatMap( Words::extractWords ).map( String::toLowerCase ).forEach( s -> {
				synchronized( occurrences ) {
					occurrences.merge( s, 1, Integer::sum );
				}
			} );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}