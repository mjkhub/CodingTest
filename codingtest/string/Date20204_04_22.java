package codingtest.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Date20204_04_22 { //boj 1213


    public static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean flag = checkIsAvailable(input);
        if(!flag) {System.out.println("I'm Sorry Hansoo"); return;}
        StringBuilder sb = new StringBuilder();
        if(input.length() % 2 ==0 ){ //짝수
            for(int i=0; i<26; i++){
                alphabet[i] = alphabet[i] / 2;
                for(int j=0; j<alphabet[i]; j++){
                    sb.append((char)('A'+i));
                }
            }
            System.out.println(sb.toString() + sb.reverse().toString());
        }else{
            String middle = "";
            for(int i=0; i<26; i++){
                if(alphabet[i] % 2 == 1) {
                    alphabet[i] -=1;
                    middle = String.valueOf((char) ('A'+i));
                }
            }
            for(int i=0; i<26; i++){
                alphabet[i] = alphabet[i] / 2;
                for(int j=0; j<alphabet[i]; j++){
                    sb.append((char)('A'+i));
                }
            }
            System.out.println(sb.toString() +middle+ sb.reverse().toString());

        }

    }

    public static boolean checkIsAvailable(String s){

        int size = s.length();
        for(int i=0; i<size; i++){
            char c = s.charAt(i);
            alphabet[c-'A'] +=1;
        }

        if(s.length()%2 == 0){ // 짝수
            for(int i=0; i<26; i++) if(alphabet[i] % 2 == 1) return false;
            return true;
        }else{ //홀수
            int oddCount = 0;
            for(int i=0; i<26; i++) if(alphabet[i] % 2 == 1) oddCount++;
            if(oddCount>1) return false;
            return true;
        }
    }

}
