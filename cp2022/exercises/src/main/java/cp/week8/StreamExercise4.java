package cp.week8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercise4
{
	/*
	- Create a stream of lines for the file created in StreamExercise1.
	- Use Stream::mapToInt and IntStream::sum to count how many times
	  the letter "C" occurs in the entire file.
	*/

	public static void main(String[] args) {
		
		final  Path path = Paths.get("C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week8/textFile.txt");
		//printLinesWithResource(path);
		countCOccur(path);

	}

	private static void printLinesWithResource( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			lines.forEach( System.out::println );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

	// Count how many times the letter "C" occurs
	private static void countCOccur( Path path ) {
		
			// char[] fileString = lines.toString().toCharArray();
			// 	Stream<char[]> cStream = Stream.of(fileString);
			// 	long result = cStream
			// 	.filter(charact -> charact.equals('C'))
			// 	.mapToInt(s -> s.length)
			// 	.sum();

			// Make the string into a stream of chars
			// filter to contain/equal 'C'
			// Make it an IntStream and get the sum
			// .flatMap(line -> Stream.of(line.))
			// .filter(word -> word.equals("C"))
			// .count();
			
			// long result = lines.toString().chars()
			// 	.filter(c -> c == 67)
			// 	.count();
			try( Stream< String > lines = Files.lines( path ) ) {
			long result = lines
				.flatMap(line -> Stream.of(line.split(" ")))
				.filter(c -> c.contains("C") )
				//.toString()
				//.chars()
				.mapToInt(c -> 1)
				.sum();
			System.out.println(result);
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

}
