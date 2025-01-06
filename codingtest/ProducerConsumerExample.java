package codingtest;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExample {
    private static final Lock lock = new ReentrantLock(); // Mutex 역할
    private static final Condition empty = lock.newCondition(); // Buffer 비었을 때 대기
    private static final Condition fill = lock.newCondition(); // Buffer 찼을 때 대기
    private static final int BUFFER_SIZE = 5; // 버퍼 크기
    private static final int[] buffer = new int[BUFFER_SIZE]; // 공유 버퍼
    private static int count = 0; // 현재 버퍼에 있는 항목 수
    private static int in = 0; // 생산자가 데이터를 넣을 인덱스
    private static int out = 0; // 소비자가 데이터를 가져갈 인덱스

    public static void main(String[] args) {
        // 여러 Producer와 Consumer 스레드 생성
        int producerCount = 3;
        int consumerCount = 3;

        for (int i = 0; i < producerCount; i++) {
            new Thread(ProducerConsumerExample::producer, "Producer-" + i).start();
        }
        for (int i = 0; i < consumerCount; i++) {
            new Thread(ProducerConsumerExample::consumer, "Consumer-" + i).start();
        }
    }

    // Producer 역할
    private static void producer() {
        try {
            for (int i = 0; i < 10; i++) { // 각 생산자가 10개의 데이터를 생산
                lock.lock(); // Mutex 잠금
                try {
                    while (count == BUFFER_SIZE) {
                        empty.await(); // 버퍼가 가득 찼으면 큐에서 대기
                    }
                    buffer[in] = i; // 데이터를 버퍼에 추가
                    System.out.println(Thread.currentThread().getName() + " produced: " + i);
                    in = (in + 1) % BUFFER_SIZE; // 원형 버퍼 인덱스 갱신
                    count++; // 버퍼 항목 수 증가
                    fill.signal(); // 소비자 스레드에 신호
                } finally {
                    lock.unlock(); // Mutex 해제
                }
                Thread.sleep(100); // 생산 속도 조절
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void consumer() {
        try {
            for (int i = 0; i < 10; i++) { // 각 소비자가 10개의 데이터를 소비
                lock.lock(); // Mutex 잠금
                try {
                    while (count == 0) {
                        fill.await();// 버퍼가 비었으면 큐에서 대기
                    }
                    int data = buffer[out]; // 버퍼에서 데이터 가져오기
                    System.out.println(Thread.currentThread().getName() + " consumed: " + data);
                    out = (out + 1) % BUFFER_SIZE; // 원형 버퍼 인덱스 갱신
                    count--; // 버퍼 항목 수 감소
                    empty.signal(); // 생산자 스레드에 신호
                } finally {
                    lock.unlock(); // Mutex 해제
                }
                Thread.sleep(150); // 소비 속도 조절
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

