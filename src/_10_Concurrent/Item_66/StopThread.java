package _10_Concurrent.Item_66;

import java.util.concurrent.TimeUnit;

//Broken! - How long would you expect this program to run?
public class StopThread {

	private static boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {

		Thread backgroundThread = new Thread(new Runnable() {

			public void run() {
				
				@SuppressWarnings("unused")
				int i = 0;

				while (!stopRequested)
					i++;
			}
		});

		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);

		stopRequested = true;
	}
}

