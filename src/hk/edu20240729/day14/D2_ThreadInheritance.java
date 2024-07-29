package hk.edu20240729.day14;

import java.util.Iterator;

public class D2_ThreadInheritance extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("나는 스레드를 상속받은 스레드야 ");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	

}
