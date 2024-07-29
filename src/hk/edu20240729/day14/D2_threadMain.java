package hk.edu20240729.day14;

public class D2_threadMain {
	
	public static void main(String[] args) {
		//스레드를 생성하는 방법 2가지
		
		//1. Runable을 구현하는 방법
		Runnable runObj = new D2_RunableTest(); // 인터페이스 타입으로 구현 받기 런어블테스트가 런어블을 구현하기 때문에 런어블이 더 커서 부모타입으로 자식객체 생성한 거랑 똑같은 것임
		Thread tr =new Thread(runObj); // 런어블 구현하고 트래드를 실행하는 방법
		tr.setPriority(10); // 우선순위 설정 1부터 10까지
		tr.start();
		
		//2. 트레드 클래스 상속받는 방법
		Thread thr = new D2_ThreadInheritance(); // 스레드 인 히스턴스에서 오버라이드 했음. 런을 인 히리턴스에서 재정의를 해서 자식에서 구현해놓은 런이라는 메서드가 실행되는 것
		thr.setPriority(Thread.MIN_PRIORITY); // 0을 가지고 옴
		thr.start();
		
		//메인스레드
		for (int i =0; i < 5; i++) {
			System.out.println("나는 메인 스레드야");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	}

}
