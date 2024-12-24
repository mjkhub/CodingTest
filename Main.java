import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n, k, q, m;
    public static int[] sum;
    public static boolean[] student;
    public static boolean[] sleep;
    public static List<Integer> qList;

    public static void main(String[] args) throws IOException { // ok 근데 이거 코딩 스타일이 너무 안좋은 것 같음

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); k = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]); m = Integer.parseInt(s[3]);
        sum = new int[n+3];
        student = new boolean[n+3]; // 3 ~ n + 2
        sleep = new boolean[n+3];
        qList = new ArrayList<>();

        // 자는 학생
        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<k; i++){
            int sleepingId = Integer.parseInt(s1[i]);
            sleep[sleepingId] = true;
        }

        String[] qInput = br.readLine().split(" ");
        for(int i=0; i<q; i++) {
            int q = Integer.parseInt(qInput[i]);
            if(!isSleeping(q))
                qList.add(Integer.parseInt(qInput[i]));
        }

        for (int i=3; i<=n+2; i++){
            if(isQ_Multiple(i)) student[i] = true;
            if(isSleeping(i)) student[i] = false;
            sum[i] = sum[i-1]  + (student[i] ? 0 : 1); // 출석이 되지 않은 학생 누적합
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");
            int count = getCount(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            sb.append(count).append('\n');
        }
        System.out.println(sb);

    }

    public static boolean isQ_Multiple(int n){ // qList 받은 애들 리스트

        for(int i=0; i<qList.size(); i++){
            if(n % qList.get(i) == 0) return true;
        }
        return false;
    }

    public static boolean isSleeping(int n){ // sleep 자는 애들 리스트

        return sleep[n];
    }

    public static int getCount(int start, int end){
        return sum[end] - sum[start-1];
    }


}
