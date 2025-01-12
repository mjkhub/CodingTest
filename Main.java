import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] map;

    public static int n, l, r;

    public static boolean[][] visit;

    public static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int count = 0;
        while (true) {
            boolean hasMoved = false; // point

            visit = new boolean[n][n];
            List<Country> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) { //point
                        Country country = bfs(new Position(i, j));
                        if (country.list.size() > 1) { // point
                            result.add(country);
                            hasMoved = true;
                        }
                    }
                }
            }
            if (!hasMoved) break;
            result.forEach(Main::update);
            count++;
        }

        System.out.println(count);
    }

    public static boolean isWithin(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    public static Country bfs(Position start) { // start: Position 객체

        Country c = new Country();
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            int row = temp.row;
            int col = temp.col;

            if (visit[row][col]) continue;

            visit[row][col] = true;
            c.add(temp);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isWithin(newRow, newCol) && !visit[newRow][newCol]) {
                    int abs = Math.abs(map[row][col] - map[newRow][newCol]);
                    if (l <= abs && abs <= r)
                        queue.offer(new Position(newRow, newCol));
                }
            }
        }
        return c;
    }

    public static void update(Country country) {
        List<Position> list = country.list;
        int avg = country.sum / list.size();

        for (Position pos : list) {
            map[pos.row][pos.col] = avg;
        }
    }

    static class Country {
        int sum = 0;
        List<Position> list = new ArrayList<>();

        public void add(Position pos) {
            list.add(pos);
            sum += map[pos.row][pos.col];
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Country)) return false;
            Country c = (Country) obj;
            return this.list.equals(c.list); // 모든 위치가 같은지 확인
        }
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Position)) return false;
            Position p = (Position) obj;
            return this.row == p.row && this.col == p.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
