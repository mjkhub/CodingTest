package codingtest;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketThread {

    public static void main(String[] args) {
        int port = 8081; // 서버가 리스닝할 포트
        System.out.println("Markdown 서버 대기 중... 포트: " + port);
        // 서버 소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(port)) { //메인 스레드 - while 구조
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable { // 클라이언트 요청을 처리하는 클래스
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        System.out.println("새로운 스레드 시작: " + Thread.currentThread().getName());
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("received_markdown_" + clientSocket.getPort() + ".md"))) {

            System.out.println("[" + clientSocket.getPort() + "] 마크다운 문서 수신 시작...");
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("END")) { // 종료 신호
                    break;
                }
                fileWriter.write(message);
                fileWriter.newLine();
            }
            System.out.println("[" + clientSocket.getPort() + "] 마크다운 문서 저장 완료");
        } catch (IOException e) {
            System.err.println("클라이언트 처리 중 오류 발생: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("클라이언트 연결 종료: " + clientSocket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}