import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Server {
    static List<ClientServer> serverlist = new ArrayList<>();	
	public static void main(String args[]) throws IOException {
		ServerSocket server_socket = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            server_socket = new ServerSocket(7787); // 포트번호로 연결 
            
            ClientServer childserver = new ClientServer(server_socket.accept(), scanner);
            childserver.start();
            serverlist.add(childserver);
            server_socket.close();

        }


	}

    public static void findUser(String id, String message) throws IOException {
        for (ClientServer clientServer : serverlist) {
            if (clientServer.getID().equals(id)) {
                    System.out.println(clientServer.getID() + "를 찾음!");

                    PrintWriter out = clientServer.getPrintWriter();
                    out.println(message);
                    out.flush();
                
            }
        }
    }
}
