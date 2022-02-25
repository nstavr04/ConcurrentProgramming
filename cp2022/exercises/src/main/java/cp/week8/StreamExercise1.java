package cp.week8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExercise1
{
	/*
	- Create a file with many (>100) lines of text.
	  For example, you can use this website: loremipsum.io
	- Use Files.lines to get a stream of the lines contained within the file.
	- Use Stream::filter and Stream::forEach to print on screen each line that ends with a dot.
	*/
	public static void main(String[] args) {
		
		final  Path path = Paths.get("C:/Users/nikol/Desktop/University/6th-Semester/Concurrent-Progamming/ConcurrentCode/cp2022/exercises/src/main/java/cp/week8/textFile.txt");
		//printLinesWithResource(path);
		printLinesWithDot(path);
		// Used to get the current working directory
		//System.out.println(System.getProperty("user.dir"));

	}

	private static void printLinesWithResource( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			lines.forEach( System.out::println );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

	// Print out every line that ends with a dot
	private static void printLinesWithDot( Path path ) {
		try( Stream< String > lines = Files.lines( path ) ) {
			lines
				.filter(s -> s.endsWith("."))
				.forEach(s -> System.out.println(s));
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

}
