import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> arr = new LinkedList<>();
        for(int i=1; i<=n; i++) arr.add(i);

        sb.append("<");
        int index = k-1;
        while(!arr.isEmpty()){
            Integer remove = arr.remove(index);
            sb.append(remove);
            if(arr.isEmpty())
                break;
            sb.append(", ");
            index = (index-1 +k) % arr.size();
        }
        sb.append(">");
        System.out.println(sb);
    }


}
