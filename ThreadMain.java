public class ThreadMain {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // 쓰레드 시작

        for (int i = 0; i < 5; i++) {
            System.out.println("메인 메서드 실행 중: " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 실행 중: " + i);
                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
