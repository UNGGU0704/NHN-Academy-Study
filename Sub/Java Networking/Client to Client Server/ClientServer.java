import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ClientServer implements Runnable{
    
    private Thread thread;
    private BufferedReader in = null;            //Client로부터 데이터를 읽어들이기 위한 입력스트림
    private PrintWriter out = null;   			//Client로 에코 해줄 출력 스트
    private String input = null;
    private Socket socket;
    private String id;
    

    public ClientServer(Socket s, Scanner scanner) {
        System.out.println("자식 서버로 이동");
         System.out.print("유저 이름 입력: ");
        
        this.id = scanner.nextLine();
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

                if(input.charAt(0) == '@') {
                    StringTokenizer st = new StringTokenizer(input.substring(1));
                    String userid = st.nextToken();
        
                    Server.findUser(userid, input.substring(userid.length() + 1));
                    continue;
                }

                System.out.println( id + "로 부터 보낸 메세지 : " + input);
                
                if (input.equals("exit")) {
                    socket.close();
                }

                
            }
            catch(IOException e) {
                System.out.println("서버 통신 오류 발생. ");
            }
        }
    }

    public String getID() {
        return id;
    }

    public PrintWriter getPrintWriter() throws IOException{
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); //출력스트림 생성;
    }

    


}
