package hk.edu20240729.day14;

public class D1_ThreadTest {

    public static void main(String[] args) {
        // 메인 메서드에서 "안" 다섯 번 출력
        for (int i = 0; i < 5; i++) {
            System.out.println("안");
        }

        // 메인 메서드에서 "녕" 다섯 번 출력
        for (int i = 0; i < 5; i++) {
            System.out.println("녕");
        }

        // 스레드 t1 생성 및 run 메서드 오버라이딩
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("안");
                    try {
                        Thread.sleep(500); // 0.5초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // 스레드 t2 생성 및 run 메서드 오버라이딩
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("녕");
                    try {
                        Thread.sleep(500); // 0.5초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        
        
                
        

        // 스레드 시작
        t1.start();
        t2.start();
        
        //내부 클래스에 경우 부모 클래스를 객체 생성한 후에 사용할 수 있다.
        Thread t3 = new D1_ThreadTest().new ThreadObj();
        t3.start();

        // 메인 스레드가 t1, t2의 종료를 기다림
      try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 모든 스레드 완료 후 종료 메시지 출력
        System.out.println("모든 작업 완료!");
    } // main 종료
    
    
    class ThreadObj extends Thread{
    	
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		 {
    			for(int i = 0; i < 5; i++) {
    				System.out.println("ThreadTest : " + i);
    			}
    		}
    	}
    	
    }
    
}
