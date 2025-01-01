import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] arr;
    public static void main(String[] args) throws IOException {

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        boolean answer = false;
        while(!answer){
            for(int i=0; i<4; i++){
                if(arr[i] > arr[i+1]){
                    swap(i, i+1);
                    print();
                }
            }
            answer = isAnswer();
        }

    }

    public static boolean isAnswer(){
        for(int i=1; i<=5; i++)
            if(arr[i-1] != i) return false;
        return true;
    }

    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(){
        for(int i : arr)
            System.out.print(i+" ");
        System.out.println();

    }

}
