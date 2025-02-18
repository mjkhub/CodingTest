import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static String s;
    public static StringBuilder t;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = new StringBuilder(br.readLine());

        while(!t.toString().equals(s)){
            if(s.length()  >= t.toString().length()){
                System.out.println(0);
                return;
            }
            int endIndex = t.length()-1;
            char ch = t.charAt(endIndex);
            if(ch == 'A')
                t.deleteCharAt(endIndex);
            else if(ch =='B'){
                t.deleteCharAt(endIndex);
                t.reverse();
            }
        }
        System.out.println(1);


    }


}
