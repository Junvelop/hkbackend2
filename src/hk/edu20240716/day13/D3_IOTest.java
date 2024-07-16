package hk.edu20240716.day13;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class D3_IOTest {

   public static void main(String[] args) {
	   
	   test01();
	   test02();
      

   }
//파일을 읽고 출력하기 
   public static void test01() {
      InputStream in=null; //입력파이프 선언
      FileOutputStream out =null;//출력파이프 선언 
      
      try {
         in=new FileInputStream("C:\\Users\\hkedu\\Hello.java");
         out=new FileOutputStream("C:\\Users\\hkedu\\output_Hello.txt");
         
         int i=0;//btye단위로 읽어서 데이터(실제값)를 저장할 변수
         while((i=in.read())!=-1) {//더이상 읽어들일 데이터가 없으면 -1 리턴
            System.out.println((char)i);
            out.write(i);//파일을 출력하는 코드
            
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }catch (IOException e) {
         e.printStackTrace();
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         {   
            try {
               out.close();//마지막에 실행된 객체부터 닫아준다.
               in.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
            
         }
      }
      
      
   }
   public static void test02() {
      OutputStream out=null; //출력 파이프 준비
      DataOutputStream ds =null; //출력 필터 준비, 필터니까 단독 사용 x
      
      String s="파일을 기록합니다";
      
      try {
      out=new FileOutputStream("C:\\Users\\hkedu\\Desktop\\Hello.txt");
      ds=new DataOutputStream(out);//보조스트림(필터)
      ds.writeUTF(s);//UTF-8형식으로 인코딩된 문자열을 출력한다.
                     //문자열을 자동으로 byte단위로 나눠서 처리
      }
      catch(Exception e) {
         e.printStackTrace();
         
      }finally {
         try {
            ds.close();
            out.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}


