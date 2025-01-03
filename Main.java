import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;

    public static List<Tuple> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            arr.add(new Tuple(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }

        Tuple answer = new Tuple(0,0);
        long min = Long.MAX_VALUE;
        for(int a=1; a<=100; a++){ // 브루트 포스
            for(int b=1; b<=100; b++){
                long rss = calculateRss(a,b);
                if(rss < min){
                    min = rss;
                    answer.x = a;
                    answer.y = b;
                }
            }
        }
        System.out.println(answer.x + " " + answer.y);
    }

    public static long calculateRss(int a, int b){
        long rss = 0;
        for(int i=0; i<n; i++){
            Tuple tuple = arr.get(i);
            int xi = tuple.x;
            int yi = tuple.y;
            int fx = a * xi + b;
            rss += (long)(yi-fx) * (yi-fx); // overflow could occur
        }
        return rss;
    }

    static class Tuple{
        int x;
        int y;

        public Tuple(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
