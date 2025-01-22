import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int n;
    public static List<Integer> player = new ArrayList<>();

    public static int beforeIndex = 0;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) player.add(i);

        for(int i=0; i<n-1; i++){
            long count = (long)Math.pow(i+1, 3);
            int removeIndex = (int)((beforeIndex + count -1) % player.size());
            player.remove(removeIndex);
            beforeIndex = removeIndex;
        }
        System.out.println(player.get(0));

    }


}
