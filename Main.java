import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;

    public static String first;

    public static int[] countArr;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        first = br.readLine();
        countArr = getCountArr(first);

        while(n-->1){
            String input = br.readLine();
            if(isSimilar(input))
                answer++;
        }
        System.out.println(answer);

    }

    public static boolean isSimilar(String input){
        int[] inputArr = getCountArr(input);
        int[] subArr = new int[26];

        for(int i=0; i<26; i++)
            subArr[i] = Math.abs(inputArr[i]-countArr[i]);

        int oneCount = 0;

        for(int i=0; i<26; i++){
            if(subArr[i] > 1) return false;
            else if(subArr[i] == 1)
                oneCount +=1;
        }

        int lengthAbs = Math.abs(input.length() - first.length());
        if(oneCount == 0 ) return true;
        else if(oneCount == 1 && lengthAbs == 1 ) return true;
        else if(oneCount == 2 && lengthAbs == 0) return true;
        else return false;

    }

    public static int[] getCountArr(String input){
        int[] countArr = new int[26];
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            countArr[c-'A'] += 1;
        }
        return countArr;
    }


}
