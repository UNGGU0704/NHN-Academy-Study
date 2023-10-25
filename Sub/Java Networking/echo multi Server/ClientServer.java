import java.io.*;
import java.net.*;
import java.util.Scanner;


public class ClientServer implements Runnable{
    
    Thread thread;
    BufferedReader in = null;            //Client로부터 데이터를 읽어들이기 위한 입력스트림
    PrintWriter out = null;   			//Client로 에코 해줄 출력 스트
    String input = null;
    Socket socket;

    public ClientServer(Socket s) {
        System.out.println("자식 서버로 이동");
        this.socket = s;
        thread = new Thread(this);
    }

    public void start(){
        thread.start();
    }

    @Override
    public void run() {

        while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    //입력스트림 생성
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); //출력스트림 생성
                input = in.readLine();                //Client로부터 데이터를 읽어옴

                System.out.println("Client로 부터 보낸 메세지 : " + input);
                
                if (input.equals("exit")) {
                    socket.close();
                }
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
