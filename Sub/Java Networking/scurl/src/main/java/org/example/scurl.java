package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class scurl {
    public static void main(String[] args) {
        Options options = new Options();

        options.addOption("v", null, false, "verbose, 요청, 응답 헤더를 출력한다.");
        options.addOption(Option.builder("H")
                .argName("line")
                .hasArg(true)
                .desc("임의의 헤더를 서버로 전송한다.")
                .build());

        options.addOption(Option.builder("d")
                .argName("data")
                .hasArg(true)
                .desc("POST, PUT 등에 데이터를 전송한다.")
                .build());
        options.addOption(Option.builder("X")
                .argName("command")
                .hasArg(true)
                .desc("사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET")
                .build());
        options.addOption("L", null, false, " 서버의 응답이 30x 계열이면 다음 응답을 따라 간다.");
        options.addOption(Option.builder("F")
                .argName("name=content")
                .hasArg()
                .desc("multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.")
                .build());


        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("v")) {
                //...
            }

            if (cmd.hasOption("H")) {
                //...
            }

            if (cmd.hasOption("d")) {
                //...
            }

            if (cmd.hasOption("X")) {
                String hostString = args[args.length - 1];
                String host = hostString.substring(7);
                int port = 80;

                String defalutMethod = "";
                defalutMethod = cmd.getOptionValue("X");
                if (defalutMethod.equals(hostString)) {
                    defalutMethod = "GET";
                }

                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(host, port));

                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    writer.println(defalutMethod + " /" + defalutMethod.toLowerCase()  + " HTTP/1.1");
                    writer.println("HOST: " + host);
                    writer.println();
                    writer.flush();

                    InputStream inputStream = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    socket.close();
                } catch (IOException e) {
                    System.out.println("연결 안됨.");
                }


            }

            if (cmd.hasOption("L")) {
                //...
            }

            if (cmd.hasOption("F")) {
                //...
            }

        } catch (ParseException ignore) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(scurl.class.getSimpleName(), options);
        }
    }
}
