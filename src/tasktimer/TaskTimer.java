package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer
{
	private static String DICTIONARY = "wordlist.txt";

	/** Run all the tasks. */
	public static void main(String [] args) {
		execAndPrint(new Task1());
		execAndPrint(new Task2());
		execAndPrint(new Task3());
		execAndPrint(new Task4());
		execAndPrint(new Task5());
		execAndPrint(new Task6());
	}
	
	public static void execAndPrint(Runnable task) {
		System.out.println(task.toString()) ;
		StopWatch st = new StopWatch() ;
		st.start() ;
		task.run();
		st.stop() ;
		System.out.printf("Elapsed time is %f sec\n" , st.getElapsed()) ;
	}

}
