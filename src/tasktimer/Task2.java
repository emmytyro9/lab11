package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 implements Runnable{
	
	private BufferedReader br = null;
	
	/**
	 * Process all the words in a file (one word per line) using BufferedReader
	 * and the readLine() method.  readLine() returns null when there is no more input.
	 * Display summary statistics and elapsed time.
	 */
	public Task2() {
		try {
			br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStream()) );
		} catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage());
			return;
		}
	}

	@Override
	public void run() {
		// initialize: open the words file as InputStream
		try {
			int count = 0;
			long totalsize = 0;
			String word = null;
			while( (word=br.readLine()) != null ) {
				totalsize += word.length();
				count++;
			}
			double averageLength = ((double)totalsize)/(count>0 ? count : 1);
			out.printf("Average length of %,d words is %.2f\n", count, averageLength);  
		} catch(IOException ioe) {
			out.println(ioe);
			return;
		} finally {
			try { br.close(); } catch (Exception ex) { /* ignore it */ }
		}
//		long stoptime = System.nanoTime();
//		out.printf("Elapsed time is %f sec\n",(stoptime - starttime)*1.0E-9 );

	}
	
	public String toString() {
		return "Starting task: read words using BufferedReader.readLine() with a loop";
	}
}
