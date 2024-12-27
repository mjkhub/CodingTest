import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++)
            queue.offer(i);

        while(queue.size()!=1){
            queue.poll(); //remove
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());

    }


}
