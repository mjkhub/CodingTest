package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Date2024_04_18 { // boj 20291

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i=1; i<=n; i++){
            String[] s = br.readLine().split("\\.");
            String exp = s[1];
            if(map.containsKey(exp))map.put(exp, map.get(exp)+1);
            else map.put(exp, 1);
        }

        ArrayList<String> arr = new ArrayList<>();
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) arr.add(it.next());
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        int size = arr.size();
        for(int i=0; i<size; i++){
            String key = arr.get(i);
            sb.append(key).append(' ').append(map.get(key)).append('\n');
        }
        System.out.println(sb);

    }

}
