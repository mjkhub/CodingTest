import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] arr;
    public static int n;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        //init

        int count = 0;
        while(true){
            int maxIndex = getMaxIndex();
            if(maxIndex == 1)
                break;
            arr[1] +=1;
            arr[maxIndex] -=1;
            count++;
        }
        System.out.println(count);

    }

    public static int getMaxIndex(){
        int maxIndex = 1;

        for(int i=2; i<=n; i++){
            if(arr[maxIndex] <= arr[i])
                maxIndex = i;
        }
        return maxIndex;
    }



}
