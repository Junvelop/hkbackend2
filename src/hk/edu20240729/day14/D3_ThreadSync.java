package hk.edu20240729.day14;

public class D3_ThreadSync {
	
	//내부 클래스
	class ShareObject{
		public synchronized void print(String title) { // synchronized는 메서드를 동기화시켜주는 기능을 한다. 동기화는 스레드1이 실행중일 때 스레드 2가 수행되지 못하도록 막아주는 것을 말한다.
			
			for (int i = 0; i < 5; i++) {
				System.out.println(title);
				
				
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		//공유 객체 생성
		ShareObject so = new D3_ThreadSync().new ShareObject();
		
		//a와 b 스레드가 동시적으로 접근
		//동기화 설정하기 : a 스레드의 작업이 종료되기까지 b 스레드는 대기
		//설정 방법 : 두가지 법 : 1: synchronized 메서드, 2: 동기화 블록 synchronized (공유 객체)
		
		
		
		Thread trA = new Thread() {
			public void run() {
				so.print("공");
			}
			
		};
		
		
		Thread trB = new Thread() {
			public void run() {
				so.print("유");
			}
			
		};
		
//		trA.start();
	//	trB.start();
		
	
		
		D3_ThreadSync d3 = new D3_ThreadSync(); // 인스턴스 메서드는 생성자를 통해서 접근을 해야 해. 인스턴스 메서드는 객체의 상태를 변화시키는 메서드를 의미해
		Thread trC = new Thread() {
			@Override
			public void run() {
				d3.sbtest("건");

			}
		};
		
		Thread trD = new Thread() {
			@Override
			public void run() {
				d3.sbtest("양");

			}
		};
		
		trC.start();
		trD.start();
		
		
	
		
	} //main 종료
	
	// 스트링 빌더에 대한 설명 -> 멀티 스레드 환경에서 동기화를 제공하지 않으면 문자열이 깨져서 저장죌 수도 있다. 스트링 빌더는 동기화를 제공하지 않아서 원래 깨져서 나와야 한다. 하지만 여기서는 그렇지 않음 왜인지는 모르겠음. 예를 들어 "ㅁㅁ"과 같이 나와야 함. 하지만 속도는 빨라. 안정적은 아니야
	// public static StringBuffer sb = new StringBuffer(); // 스트링 버퍼는 동기화 제공 -> 각각의 스레드의 무결성을 유지함 -> 스트링 빌더는 안정적
	public static StringBuilder sb = new StringBuilder(); // 동기화 제공 X
	
	
	public void sbtest(String s) {
		
		synchronized (sb) {
			sb.append(s);
			System.out.println(sb.toString());
			
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}
