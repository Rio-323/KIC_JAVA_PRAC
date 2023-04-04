package pack6;

import java.time.LocalTime;

public class SleepTest1 {
	
	static class Timer extends Thread {
		public void run() {
			for(int i = 0; i < 3; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("째깍 : " + LocalTime.now());
			}
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.start();
	}

}
