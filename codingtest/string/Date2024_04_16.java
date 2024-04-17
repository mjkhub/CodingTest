package codingtest.string;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Date2024_04_16 { //boj 17413

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<n; i++){
            if(s.charAt(i) =='<') {
                result.append(temp.reverse()); //기존게 있다면 비우기
                temp = new StringBuilder(); // new
                while(s.charAt(i) != '>') {
                    temp.append(s.charAt(i++));
                }
                temp.append('>');
                result.append(temp);
                temp = new StringBuilder();//clear
            }
            else if (s.charAt(i) == ' ') {
                result.append(temp.reverse()).append(' ');
                temp = new StringBuilder();
            }
            else{ //알파벳..
                temp.append(s.charAt(i));
                if(i==n-1) result.append(temp.reverse());
            }
        }
        System.out.println(result);
    }


}
