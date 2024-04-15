package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Date2024_04_15 { //boj 1316

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int count = 0;
        while(t-->0){
            String s = br.readLine();

            ArrayList<Character> previous = new ArrayList<>();
            int length = s.length();
            char previousCh = s.charAt(0);
            previous.add(previousCh);

            boolean flag = true;
            for(int i=0; i<length; i++){
                char c = s.charAt(i);
                if( c == previousCh && previous.contains(c)){} //pass
                else if( c != previousCh && previous.contains(c)){
                    flag = false;
                    break;
                }else if( c != previousCh && !previous.contains(c)){
                    previous.add(previousCh);
                    previousCh = c;
                }
            }

            if(flag) count++;
        }
        System.out.println(count);
    }
}
