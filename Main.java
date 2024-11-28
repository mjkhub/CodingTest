import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
        int N = sc.nextInt(); // 필요한 랜선의 개수
        int[] lanLengths = new int[K];

        long maxLength = 0;
        for (int i = 0; i < K; i++) {
            lanLengths[i] = sc.nextInt();
            maxLength = Math.max(maxLength, lanLengths[i]);
        }

        long low = 1, high = maxLength;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long totalLans = 0;
            for (int length : lanLengths) {
                totalLans += length / mid;
            }

            if (totalLans >= N) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
