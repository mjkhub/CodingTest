package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_04_17 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String[] sub = br.readLine().split("-");
        int sum = 0;
        for(int i = 0; i<sub.length; i++) {

            int temp = 0;
            String[] add = sub[i].split("\\+");
            for(int j =0; j <add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }
            if( i == 0) sum+= temp;
            else sum-=temp;

        }

        System.out.println(sum);
    }

}
