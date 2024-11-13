import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException { // boj 15953
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] s = br.readLine().split(" ");
            printMoney(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
    }

    public static void printMoney(int first, int second){
        int first1 = getFirst(first);
        int second1 = getSecond(second);
        System.out.println(first1 +second1);
    }

    public static int getFirst(int first){

        if(first == 1) return 5000000;
        else if(2<=first && first<=3)   return 3000000;
        else if(4<=first && first<=6)   return 2000000;
        else if(7<=first && first<=10)  return  500000;
        else if(11<=first && first<=15) return  300000;
        else if(16<=first && first<=21) return  100000;
        else return 0;
    }

    public static int getSecond(int first){

        if(first == 1) return 5120000;
        else if(2<=first && first<=3)   return 2560000;
        else if(4<=first && first<=7)   return 1280000;
        else if(8<=first && first<=15)  return  640000;
        else if(16<=first && first<=31) return  320000;
        else return 0;
    }



}