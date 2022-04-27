package cp.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalkParallelStream1
{
	public static void main()
	{
		// word -> number of times it appears over all files
		Map< String, Integer > occurrences = new ConcurrentHashMap<>();

		try {
			Files
				.walk( Paths.get( "data" ) )
				// whenever we have stream we can call parallel and java will use the ForkJoinPool.commonPool() which is a work stealing executor
				// from now on the tasks after eg filter for each etc are not sequential and are in an executor
				// they can be called in parallel etc and its now a concurrent operation

				// can be improved by getting all the files and then doing concurrency instead of doing it once we get a file every time
				.parallel()
				.filter( Files::isRegularFile )
				.forEach( filepath -> computeOccurrences( filepath, occurrences ) );
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
//		occurrences.forEach( (word, n) -> System.out.println( word + ": " + n ) );
	}
	
	private static void computeOccurrences( Path textFile, Map< String, Integer > occurrences )
	{
		try {
			Files.lines( textFile )
				.flatMap( Words::extractWords )
				.map( String::toLowerCase )
				.forEach( s -> occurrences.merge( s, 1, Integer::sum ) );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}
