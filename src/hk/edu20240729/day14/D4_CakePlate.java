package hk.edu20240729.day14;


public class D4_CakePlate {
	
	 // 빵 만들 개수를 저장함
	private int breadCount = 0;
	
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			System.out.println("빵이 남는다");
			try {
				wait();// 일시정지
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // 그게 아니라면
		breadCount++;
		System.out.println("빵을 하나 더 만듦 총 : " + breadCount + "개");
		this.notifyAll(); // wait()으로 일시정지된 스레드를 실행 대기 상태로 만든다. 이 코드는 모든 스레드를 실행대기로 만드는 것임
	}
	
	public synchronized void eatBread() {
		if(breadCount < 1)
		{
			System.out.println("빵이 모자라 기다림");
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		breadCount--;
		System.out.println("빵을 1개 먹음 총 :" + breadCount + "개");
		this.notifyAll();
	}
	
	
	

}
