import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] heap;
    public static int totalNode;

    public static String[] input;

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        totalNode = (int)Math.pow(2,k)-1;
        heap = new int[totalNode+1];

        fillNode(0, totalNode-1, 1);


        StringBuilder sb = new StringBuilder();
        int index = 1;
        for(int i=1; i<=k; i++){ // 각 depth
            int count = (int)Math.pow(2,i) / 2 ;
            for(int j=0; j<count; j++){
                sb.append(heap[index++]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);


    }

    public static void fillNode(int start, int end, int i){
        int mid = (start + end )/ 2;
        heap[i] = Integer.parseInt(input[mid]);

        if(start < mid) fillNode(start, mid-1, i*2);
        if(end > mid) fillNode(mid+1, end, i*2+1);
        // base case 는 start = mid

    }

}
