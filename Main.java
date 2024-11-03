import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main { // boj 1546

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { //boj 1357

        int n = Integer.parseInt(br.readLine());

        int[] gradeList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Arrays.stream(gradeList)
                .max()
                .orElse(0);

        double avg = Arrays.stream(gradeList)
                .mapToDouble(gr -> ((double) gr / max) * 100)
                .average()
                .orElse(0.0);

        System.out.println(avg);

    }

}