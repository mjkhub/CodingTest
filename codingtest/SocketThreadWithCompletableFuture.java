package codingtest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketThreadWithCompletableFuture {

    public static void main(String[] args) {
        int port = 8081;
        System.out.println("Markdown 서버 대기 중... 포트: " + port);

        // 고정 크기의 스레드 풀 생성 (10개의 스레드)
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // 클라이언트 연결 수락
                Socket clientSocket = serverSocket.accept(); // blocking
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

                // CompletableFuture 로 클라이언트 요청 처리
                CompletableFuture.supplyAsync(() -> handleClient(clientSocket), threadPool)
                        .thenAccept(result -> System.out.println("작업 완료: " + result))
                        .exceptionally(ex -> {
                            System.err.println("작업 처리 중 오류 발생: " + ex.getMessage());
                            return null;
                        }); // 비동기적으로 동작한다. 즉 작업이 끝날때까지 기다리지 않고 다음 코드로 진행된다

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 서버 종료 시 스레드 풀 정리
            threadPool.shutdown();
        }
    }

    // 클라이언트 요청을 처리하는 메서드
    private static String handleClient(Socket clientSocket) {
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
