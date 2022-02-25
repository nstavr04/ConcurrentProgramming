package cp.week8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExercise2
{
	/*
	- Create a stream of lines for the file created in StreamExercise1.
	- Use Stream::filter and Stream::collector (the one with three parameters)
	  to create an ArrayList of all lines that start with a "C".
	- Suggestion: look at https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#collect-java.util.function.Supplier-java.util.function.BiConsumer-java.util.function.BiConsumer-
	*/

	public static void main(String[] args) {
		
		final  Path path = Paths.get("C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week8/textFile.txt");
		//printLinesWithResource(path);
		createArrayList(path);

	}

	private static void printLinesWithResource( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			lines.forEach( System.out::println );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

	// Create an ArrayList of all lines that start with a "C"
	private static void createArrayList( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			List<String> arList = lines
				.filter(s -> s.startsWith("C"))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
				System.out.println(arList.toString());
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

}
