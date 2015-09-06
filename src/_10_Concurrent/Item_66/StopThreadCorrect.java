package _10_Concurrent.Item_66;

import java.util.concurrent.TimeUnit;

//Properly synchronized cooperative thread termination
public class StopThreadCorrect {
	private static boolean stopRequested;
	
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
	
	public static void main(String[] args) throws InterruptedException {
	
		Thread backgroundThread = new Thread(new Runnable() {
		
			public void run() {
			
				@SuppressWarnings("unused")
				
				int i = 0;
				
				while (!stopRequested())
					i++;
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		
		requestStop();
	}
}

/*
 * catatan bisa menggunakan volatile jika hanya ingin
 * komunikasi antar thread, dan bukan ingin untuk
 * mutual exclusion
 */
