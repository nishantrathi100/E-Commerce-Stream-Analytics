/**
 * 
 */
package simulator.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import simulator.model.UserSimulator;

/**
 * @author nishantrathi
 *
 */
public class MainClass {

	private static final int MAX_PARALLEL_USER = 20;
	private static final int TOTAL_USER = (int) (Math.random() * 5000);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(MAX_PARALLEL_USER);
		for (int i = 0; i < TOTAL_USER; i++) {
			Runnable userSimulator = new UserSimulator();
			executorService.execute(userSimulator);
			Thread.sleep((long) Math.random() * 5000);
		}
		while (!executorService.isTerminated()) {
		}

	}

}
