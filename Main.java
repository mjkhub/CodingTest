import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); int l = Integer.parseInt(s[1]);

        Sign[] map = new Sign[l]; // 0 ~ l

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int d = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);
            int g = Integer.parseInt(line[2]);
            Sign sign = new Sign(d, r, g);
            map[d] = sign;
        }

        int index = 0;
        int time = 0;
        while(index < l){ // index == l 는 다리의 끝까지 갔음을 의미함
            if(map[index] == null ){
                index++;
            }else{ // there is a sign
                Sign sign = map[index];
                int period = sign.r + sign.g;
                int mod = (time) % (sign.r + sign.g);
                if(sign.r<= mod && mod < period) //means green
                    index++;
            }
            time++;
        }
        System.out.println(time);
    }

    static class Sign{
        int d;
        int r;
        int g;

        public Sign(int d, int r, int g){
            this.d = d;
            this.r = r;
            this.g = g;
        }
    }



}
