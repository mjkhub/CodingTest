import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static Queue<Node> queue = new LinkedList<>();
    public static boolean[] visit = new boolean[100_001]; // 0 ~ 100_000
    public static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        queue.offer(new Node(n,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int value = node.value;
            visit[value] = true;

            if(value == k){
                System.out.println(node.time);
                break;
            }
            addQueue(value-1, node.time+1);
            addQueue(value+1, node.time+1);
            addQueue(value*2, node.time+1);
        }

    }

    public static void addQueue(int value, int beforeTime){
        if(0<= value && value <=100_000 && !visit[value])
            queue.offer(new Node(value, beforeTime));
    }

    static class Node{
        int value;
        int time;

        public Node(int value, int time){
            this.value = value;
            this.time = time;
        }
    }


}
