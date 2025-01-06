package codingtest;
import java.io.*;
import java.net.*;

public class SocketMain {

    public static void main(String[] args) {
        int port = 8081; // 서버가 리스닝할 포트
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Markdown 서버 대기 중... 포트: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // 클라이언트 연결
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

                // 클라이언트로부터 데이터를 받기
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     BufferedWriter fileWriter = new BufferedWriter(new FileWriter("received_markdown.md"))) {

                    String line;
                    System.out.println("마크다운 문서 수신 시작...");
                    while ((line = in.readLine()) != null) {
                        if (line.equals("END")) { // 종료 신호
                            break;
                        }
                        fileWriter.write(line);
                        fileWriter.newLine();
                    }
                    System.out.println("마크다운 문서 저장 완료: received_markdown.md");
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
