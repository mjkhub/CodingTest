package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Date2024_04_20 { //boj 2870

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<BigInteger> results = new ArrayList<>();

        while (n-->0){
            String s = br.readLine();
            StringBuilder temp = new StringBuilder();
            int length = s.length();
            for(int i=0; i<length; i++){
                char c = s.charAt(i);
                if(!('a'<=c && c<='z')) temp.append(c); //숫자면 그냥 넣어
                else if( ('a'<=c && c<='z') && !temp.isEmpty()) {
                    results.add(new BigInteger(temp.toString()));
                    temp = new StringBuilder();
                }

                if(i==length-1 && !temp.isEmpty()) results.add(new BigInteger(temp.toString()));
            }
        }
        results.sort((o1, o2) -> o1.compareTo(o2) );
        for (BigInteger result : results) {
            System.out.println(result);
        }
    }
}
