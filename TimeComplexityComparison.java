import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TimeComplexityComparison {
    public static void main(String[] args) { // 데이터 개수가 많아 질수록 이진 탐색이 압도적 -> 조회 탐색 알고리즘 이 중요
        final int DATA_SIZE = 100_000_000;
        ArrayList<Integer> data = new ArrayList<>(DATA_SIZE);
        Random random = new Random();

        // 1. 데이터 생성 및 정렬
        for (int i = 0; i < DATA_SIZE; i++) {
            data.add(random.nextInt(DATA_SIZE * 10));
        }
        Collections.sort(data); // 이진 탐색을 위해 정렬

        int target = data.get(random.nextInt(DATA_SIZE)); // 찾을 데이터 중 하나를 랜덤 선택

        // 2. O(log n) - 이진 탐색
        long startTime = System.nanoTime();
        int indexLogN = binarySearch(data, target);
        long endTime = System.nanoTime();
        System.out.println("O(log n) - Binary Search Index: " + indexLogN);
        System.out.println("O(log n) - 실행 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // 3. O(n) - 선형 탐색
        startTime = System.nanoTime();
        int indexN = linearSearch(data, target);
        endTime = System.nanoTime();
        System.out.println("O(n) - Linear Search Index: " + indexN);
        System.out.println("O(n) - 실행 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // 이진 탐색 O(log n)
    public static int binarySearch(ArrayList<Integer> data, int target) {
        int left = 0, right = data.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data.get(mid) == target) return mid;
            if (data.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // 찾지 못했을 때
    }

    // 선형 탐색 O(n)
    public static int linearSearch(ArrayList<Integer> data, int target) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == target) return i;
        }
        return -1; // 찾지 못했을 때
    }
}
