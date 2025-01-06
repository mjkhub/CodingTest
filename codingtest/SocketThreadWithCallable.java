package codingtest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class SocketThreadWithCallable {

    public static void main(String[] args) {
        int port = 8081; // 서버가 리스닝할 포트
        System.out.println("Markdown 서버 대기 중... 포트: " + port);

        // 고정 크기의 스레드 풀 생성 (10개의 스레드)
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // 클라이언트 연결 수락
                Socket clientSocket = serverSocket.accept(); // blocking
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

                // 클라이언트 요청을 Callable 작업 으로 스레드 풀에 제출
                Future<String> future = threadPool.submit(new ClientHandler3(clientSocket));

                // 작업 결과를 Future 로 확인
                try {
                    String result = future.get(); // (blocking) -> 메인 쓰레드 블로킹 발생 ! 싱글 스레드와 다름 없음
                    System.out.println("작업 완료: " + result);
                } catch (InterruptedException | ExecutionException e) { // 기다리면서 발생할 수 있는 예외를 처리한다.
                    System.err.println("작업 처리 중 오류 발생: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 서버 종료 시 스레드 풀 정리
            threadPool.shutdown();
        }
    }
}

// 클라이언트 요청을 처리하는 Task
class ClientHandler3 implements Callable<String> {
    private final Socket clientSocket;

    public ClientHandler3(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public String call() {
        System.out.println("새로운 스레드 시작: " + Thread.currentThread().getName());
        String fileName = "received_markdown_" + clientSocket.getPort() + ".md";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {

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
            return "오류 발생: " + e.getMessage();
        } finally {
            try {
                clientSocket.close();
                System.out.println("클라이언트 연결 종료: " + clientSocket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "파일 저장 완료: " + fileName;
    }
}
