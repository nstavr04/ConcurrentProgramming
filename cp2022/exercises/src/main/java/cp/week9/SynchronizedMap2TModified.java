package cp.week9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// This is the example developed in the video 13-SynchronizedMap2T
public class SynchronizedMap2TModified {
	public static void main() {
		Map< Character, Long > occurrences1 = new HashMap<>();
        Map< Character, Long > occurrences2 = new HashMap<>();
        Map< Character, Long > occurrencesMerge = new HashMap<>();

		Thread t1 = new Thread( () ->
			countLetters( Paths.get( "C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week9/text1.txt" ), occurrences1 ) );
		Thread t2 = new Thread( () ->
			countLetters( Paths.get( "C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week9/text2.txt" ), occurrences2 ) );

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}

        occurrences1.forEach((key,value) -> occurrencesMerge.merge(key, value, Long::sum));
        occurrences2.forEach((key,value) -> occurrencesMerge.merge(key, value, Long::sum));
		
		System.out.println( "e -> " + occurrencesMerge.get( 'e' ) );
	}

	// Metrw tis emfaniseis olwn twn xaraktirwn
	private static void countLetters( Path textPath, Map< Character, Long > occurrences ) {
		try( Stream< String > lines = Files.lines( textPath ) ) {
			lines.forEach( line -> {
				for( int i = 0; i < line.length(); i++ ) {
					final char c = line.charAt( i );
					occurrences.merge( c, 1L, Long::sum );				
				}
			} );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}

