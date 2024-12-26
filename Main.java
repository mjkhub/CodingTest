import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]); // 다리 길이
        int l = Integer.parseInt(s[2]); // 최대 하중
        String[] s2 = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for (String input : s2)
            queue.offer(Integer.parseInt(input));

        int time = 1;
        Bridge br = new Bridge(w,l);
        br.add(queue.poll());

        while(true){
            time++;
            br.periodicJob();
            if(!queue.isEmpty()){
                if(br.isAddable(queue.peek())){
                    br.add(queue.poll());
                }
            }
            if(queue.isEmpty() && br.isEmpty())
                break;
        }
        System.out.println(time);
    }

    static class Bridge{
        int currentWeight=0; //현재 하중
        int w; // 다리 길이
        int l; // 최대 하중
        int[] arr;

        public Bridge(int w, int l){
            arr = new int[w];
            this.w = w;
            this.l = l;
        }
        public void periodicJob(){
            currentWeight -= arr[0]; //delete
            for(int i=1; i<=w-1; i++)
                arr[i-1] = arr[i];
            arr[w-1] = 0; //move
        }
        public boolean isAddable(int weight){
            if(currentWeight + weight <= l) return true;
            else return false;
        }
        public void add(int weight){
            arr[w-1] = weight;
            currentWeight += weight;
        }
        public boolean isEmpty(){
            return currentWeight == 0;
        }

    }

}
