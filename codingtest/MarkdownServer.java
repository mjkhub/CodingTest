package codingtest;


import java.io.*;
import java.net.*;

public class MarkdownServer {

    public static void main(String[] args) {
        int port = 8081; // 서버가 리스닝할 포트

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Markdown 서버 대기 중... 포트: " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

                    System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

                    String request = in.readLine();
                    System.out.println("요청 수신: " + request);

                    if ("GET_MARKDOWN".equals(request)) { // 요청이 "GET_MARKDOWN"일 경우
                        File markdownFile = new File("sample_markdown.md");

                        if (markdownFile.exists()) {
                            try (BufferedReader fileReader = new BufferedReader(new FileReader(markdownFile))) {
                                String line;
                                while ((line = fileReader.readLine()) != null) {
                                    out.write(line);
                                    out.newLine();
                                }
                                out.write("END"); // 종료 신호
                                out.newLine();
                                out.flush();
                                System.out.println("마크다운 문서 전송 완료.");
                            }
                        } else {
                            out.write("ERROR: File not found");
                            out.newLine();
                            out.flush();
                            System.out.println("요청된 파일이 존재하지 않음.");
                        }
                    } else {
                        out.write("ERROR: Invalid request");
                        out.newLine();
                        out.flush();
                        System.out.println("잘못된 요청 수신.");
                    }
                } catch (IOException e) {
                    System.out.println("클라이언트 처리 중 오류 발생: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
