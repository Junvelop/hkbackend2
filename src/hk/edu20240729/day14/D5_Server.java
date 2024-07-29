package hk.edu20240729.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; //자바 . io, 자바. 소켓, 자바 에스큐엘은 꼭 예외 처리를 해야돼 

public class D5_Server {
	
	public static void main(String[] args) {
		Socket clientSocket = null; // 클라이언트 소켓
		PrintWriter out = null; // 클라이언트로 출력할 때 출력 객체 
		BufferedReader in = null; // 서버로 읽어들일 때 사용하는 객체
		
		
		//서버 소켓 생성 클라이언트 소켓이 그냥 소캣 타입임
		try {
			ServerSocket serverSocket = new ServerSocket(9595);
			System.out.println("서버 이스 러닝");
			
			
			while(true){
				//클라이언트로부터 요청을 승인(연결확인)후 클라이언트 소켓 얻어옴 --> TCP 방식
				clientSocket = serverSocket.accept(); // 연결 확인 --> 요청한 클라이언트의 소켓을 확인 후 있으면 클라이언트 소켓에 저장해 놨다가 서버에서 다시 클라이언트에게 줄 때 저 소켓을 참고하여 줌 --> 엑셉트 방식이면 TCP방식으로 구현하고 있구나라고 생각할 수 있음
				
				//클라이언트 호스트 이름 가져오기 : 정보 가져오기
				System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress().getHostName()); //아이넷 어드레스로부터 정보 가져오기 . 그중에 호스트 네임 출력하기
				
				//클라이언트로 보낼 outputstream 객체 생성하고, printWriter로 생성
				out = new PrintWriter(clientSocket.getOutputStream(),true);
				
				//ㅋㄹ라이언트 소켓으로부터 읽어들일 inputsteam 객체 생성
				in = new BufferedReader(
						new InputStreamReader(
								clientSocket.getInputStream()
								)
					
						
						);
				
				String inputLine;
				while((inputLine = in.readLine())!=null) {
					System.out.println("클라이언트로부터 전달되는 메시지" + inputLine);
					//클라인터로 보낼 메시지
					out.println("니가 보낸 메시지:" + inputLine);
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(in!=null) {
					in.close();
				}
				if(out!=null) {
					in.close();
				}
				if(clientSocket!=null) {
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
