import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class Client {
	 public static void main(String[] arg)
	    {
	        Socket socket = null;            //Server와 통신하기 위한 Socket 선언 
	        PrintWriter out = null;            //서버로 내보내기 위한 출력 스트림
	        InetAddress ia = null;			// 클라이언트의 ip 주소 
	        String echo = null;				// 에코를 출력할 스트
            BufferedReader reader = null;
	        Scanner s = new Scanner(System.in);
	        try {
	        	ia = InetAddress.getLocalHost();  //ip 할당 
	            System.out.println(ia);
	            socket = new Socket(ia,7787); // 서버와 연결 
                
	            System.out.println(socket.toString()); // 연결 정보 출력 
                System.out.println("서버 연결 완료 ");
	        } catch(IOException e) {
                throw new IllegalAccessError("echo");
	        }
	        
	        while(true) {
	        try {
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); //출력스트림 생성
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            System.out.print("서버로 보낼 메세제 : ");
	            String data = s.nextLine();            //키보드로부터 입력
	            if(data.equals("exit")) {  // 종료 
	            	System.out.println("Client 종료");
	            	socket.close();
                    s.close();
	            	System.exit(0);
	            }

                out.println(data); // 문자열을 소켓을 통해 전송
                out.flush(); // 버퍼를 비워서 데이터를 전송

                System.out.println("서버에서 보낸 echo 메세지: " + reader.readLine());
	        } catch(IOException e) {
	        	System.out.println("통신 오류 발생! ");
	        }
	        }
            
	    }
	 

}
