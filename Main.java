import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;

    public static List<Integer> queue;

    public static int answer = 0;
    

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[m];
        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<m; i++)
            arr[i] = Integer.parseInt(s1[i]);

        queue = new ArrayList<>();
        for(int i=1; i<=n; i++) queue.add(i);

        for(int target : arr){
            int leftCount = countLeft(target);
            int rightCunt = countRight(target);
            if(leftCount < rightCunt) pickLeft(target);
            else pickRight(target);
        }

        System.out.println(answer);

    }

    public static int countLeft(int target){

        return queue.indexOf(target);
    }

    public static int countRight(int target){

        return queue.size()-queue.indexOf(target);
    }

    public static void pickLeft(int target){
        while(true){
            Integer value = queue.remove(0);
            if(value != target){
                answer++;
                queue.add(value);
            }else{
                break;
            }
        }
    }

    public static void pickRight(int target){
        while(true){
            Integer value = queue.remove(queue.size()-1);
            if(value != target){
                answer++;
                queue.add(0,value);
            }else{
                answer++;
                break;
            }
        }
    }



}
