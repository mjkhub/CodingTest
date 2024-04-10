package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_04_11 { //BOJ 10808

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int[] arr = new int[26];
        for(int i=0; i<length; i++){
            char c = s.charAt(i);
            arr[c-'a'] +=1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) sb.append(arr[i]).append(' ');
        System.out.println(sb);

    }
}
