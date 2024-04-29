package codingtest.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date2024_04_29 { //boj 2798

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub

        String N_M = br.readLine();
        String[] N_M_arr = N_M.split(" ");
        String card = br.readLine();
        String[] cardArr = card.split(" ");

        int N = Integer.parseInt(N_M_arr[0]);
        int M = Integer.parseInt(N_M_arr[1]);
        int[] arr = new int[cardArr.length];
        for(int i=0; i<cardArr.length; i++) {
            arr[i] = Integer.parseInt(cardArr[i]);
        }

        int best = 0;
        for(int i=0; i<arr.length-2; i++) {

            if(arr[i] > M) continue;
            for(int j=i+1; j<arr.length-1; j++) {

                if(arr[i] + arr[j] > M) continue;
                for(int k=j+1; k<arr.length; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if(M == temp) {
                        best = temp;
                        break;
                    }
                    if( ( M-temp > 0) && ((M-best) > (M-temp)) ) {
                        best = temp;
                    }
                }
            }
        }

        System.out.println(best);

    }

}
