import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVariableExample {
    private static final Lock lock = new ReentrantLock(); // Mutex 역할
    private static final Condition condition = lock.newCondition(); // Condition Variable 역할
    private static boolean done = false; // 상태 변수

    // 자식 스레드 역할
    public static void child() {// 상태 변경 및 신호 보내기
        System.out.println("Child thread is running...");
        lock.lock();
        try {
            done = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void thr_join() { // 상태가 완료될 때까지 wait
        lock.lock();
        try {
            while (!done)
                condition.await(); // 조건이 충족될 때까지 대기

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread childThread = new Thread(ConditionVariableExample::child);
        childThread.start();

        thr_join();
        System.out.println("Main thread resumed after child thread completion.");
    }
}
