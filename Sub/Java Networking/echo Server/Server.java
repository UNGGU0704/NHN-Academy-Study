import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server {
	public static void main(String args[]) throws IOException {
		Socket socket = null;
		ServerSocket server_socket = null;	
		BufferedReader in = null;            //Client로부터 데이터를 읽어들이기 위한 입력스트림
        PrintWriter out = null;   			//Client로 에코 해줄 출력 스트
        String input = null;

        try{
	            server_socket = new ServerSocket(7787); // 포트번호로 연결 
	            System.out.println("서버 실행 ");
	         	socket = server_socket.accept(); // 자식 소켓에게 연결 
                System.out.println("클라이언트 연결 완료 ");
	        }catch(IOException e)
	        {
	            System.out.println("해당 포트가 열려있습니다.");
	        }
        
        
        while(true) {
            System.out.println("서버 대기중...");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    //입력스트림 생성
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); //출력스트림 생성
        
	        try {
	            input = in.readLine();                //Client로부터 데이터를 읽어옴

	            System.out.println("Client로 부터 보낸 메세지 : " + input);
	            
	            out.println(input); // 에코 해줄 데이터 Client로 보냄
	            out.flush(); // 버퍼링 제거 
	            
	        }
	        catch(IOException e)
	        {
	        	System.out.println("서버 통신 오류 발생. ");
	        }
	        
	        
        }

	}
}
