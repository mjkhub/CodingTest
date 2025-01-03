import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] grid = new boolean[101][101]; // 평면 그리드 (1 ~ 100)
        int totalArea = 0;

        // 4개의 직사각형 입력 받기
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            // 직사각형 영역에 해당하는 그리드 채우기
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (!grid[x][y]) { // 아직 방문하지 않은 영역
                        grid[x][y] = true;
                        totalArea++;
                    }
                }
            }
        }

        System.out.println(totalArea); // 총 면적 출력
    }
}
