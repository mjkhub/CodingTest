import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            if(n==0 && m==0) break;

            Map<Integer, Integer> playerMap = new HashMap<>();
            for(int i=0; i<n; i++){
                String[] line = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    int player = Integer.parseInt(line[j]);
                    playerMap.put(player, playerMap.getOrDefault(player,0) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> players = playerMap.entrySet().stream()
                    .sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue)
                            .reversed()
                            .thenComparing(Map.Entry<Integer,Integer>::getKey))
                    .collect(Collectors.toList());


            StringBuilder sb = new StringBuilder();
            sb.append(players.get(1).getKey()).append(' ');
            int secondValue = players.get(1).getValue();

            for(int i=2; i<players.size(); i++){ //이런 부분이 좀 지저분하다고 느껴질 수 있는데 중요한 포인트
                if(players.get(i).getValue() == secondValue) sb.append(players.get(i).getKey()).append(' ');
                else break;
            }

            System.out.println(sb);
        }
    }


}
