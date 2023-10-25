import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server {
	public static void main(String args[]) throws IOException {
		ServerSocket server_socket = null;	

        while (true) {
            server_socket = new ServerSocket(7787); // 포트번호로 연결 
            System.out.println("서버 실행 ");
            
            ClientServer childserver = new ClientServer(server_socket.accept());
            childserver.start();
            server_socket.close();

        }



	}
}
