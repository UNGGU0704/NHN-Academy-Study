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
    static final int port = 80;
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
                String[] argParser = argParsing(args, cmd);
                sendRequest(argParser[0], argParser[1], port, true);
            }

            if (cmd.hasOption("H")) {
                //...
            }

            if (cmd.hasOption("d")) {
                //...
            }

            if (cmd.hasOption("X")) {
                String[] argParser = argParsing(args, cmd);
                sendRequest(argParser[0], argParser[1], port, false);
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

    public static String[] argParsing(String[] args, CommandLine cmd) {
        String[] parsingArgs = new String[2];

        String hostString = args[args.length - 1];
        parsingArgs[0] = hostString.substring(7);

        parsingArgs[1] = "";
        parsingArgs[1] = cmd.getOptionValue("X");
        if (parsingArgs[1].equals(hostString)) {
            parsingArgs[1] = "GET";
        }

        return parsingArgs;
    }

    public static void sendRequest(String host, String method, int port, boolean shouldHeader) {
        String[] hosts = host.split("/");
        boolean printFlag = shouldHeader;
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(hosts[0], port));

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            //writer.println(method + " /" + method.toLowerCase()  + " HTTP/1.1");
            writer.println(method + " /" + hosts[1]  + " HTTP/1.1");
            writer.println("HOST: " + hosts[0]);
            writer.println();
            writer.flush();

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {

                if (!printFlag && line.startsWith("{")) {
                    printFlag = !printFlag;
                }

                if (printFlag) {
                    System.out.println(line);
                }
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("연결 안됨.");
        }
    }


}
