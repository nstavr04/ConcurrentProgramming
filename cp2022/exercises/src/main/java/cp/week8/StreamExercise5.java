package cp.week8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamExercise5
{
	/* ! (Exercises marked with ! are more difficult.)
	
	- Create a stream of lines for the file created in StreamExercise1.
	- Use Stream::map to map each line to a HashMap<String, Integer> that
	  stores how many times each character appears in the line.
	  For example, for the line "abbc" you would produce a map with entries:
	    a -> 1
	    b -> 2
	    c -> 1
	- Use Stream::reduce(T identity, BinaryOperator<T> accumulator)
	  to produce a single HashMap<String, Integer> that stores
	  the results for the entire file.
	*/

	public static void main(String[] args) {
		
		final  Path path = Paths.get("C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week8/textFile.txt");
		//printLinesWithResource(path);
		countCharAppearances(path);

	}

	private static void printLinesWithResource( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			lines.forEach( System.out::println );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

	// Count how many times each character appears in the lines
	private static void countCharAppearances( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			//long result = lines
			//	.flatMap(line -> Stream.of(line.split("\n")))
			//	.map(line -> {
			//		Map<String>
			//	})
			lines
				.flatMap(line -> Stream.of(line.split(" ")))
				.map(word -> {
					Map<String, Integer> m = new HashMap<>();
					m.put(word,1);
					return m;
				})
				.reduce( new HashMap< String, Integer >(), ( m1, m2 ) -> {
					Map< String, Integer > result = new HashMap<>( m1 );
					m2.forEach( ( key, value ) -> result.merge( key, value, Integer::sum ) );
					return result;
				} )
				.forEach( ( word, value ) -> System.out.println( word + " -> " + value ) );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

}
