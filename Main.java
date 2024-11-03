import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder sb = new StringBuilder();
    public static String[] arr;
    public static int N ;
    public static void main(String[] args) throws IOException { //boj 1032

        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++) arr[i] = br.readLine();

        int stringLength = arr[0].length();
        for(int i =0; i<stringLength; i++){
            char c = compareCharAtIndex(i);
            sb.append(c);
        }
        System.out.println(sb);

    }

    public static char compareCharAtIndex(int index){
        char c = arr[0].charAt(index);
        for (int i=1; i<N; i++){
            if( c != arr[i].charAt(index)) return '?';
        }
        return c;
    }
}