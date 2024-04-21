package codingtest.string;
import java.util.*;
import java.io.*;

public class Date2024_04_21 { // boj 1764

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException{ // 1. 듣도못한 보도못한 둘을 conjunction 한 후 정렬하면 끝일듯
        // 2. 듣도못한을 집합에 넣고 보도못한을 읽으면서 값이 존재하면 arraylist에 삽입
        // TODO Auto-generated method stub
        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        ArrayList<String> intersection = new ArrayList<>(); // 최종 답이 들어갈 container

        Set<String> neverSeenSet = new HashSet<>();
        for(int i =0; i < N; i++)  neverSeenSet.add(br.readLine());
        for(int i =0; i < M; i++) {
            String neverheard = br.readLine();
            if(neverSeenSet.contains(neverheard)) {
                intersection.add(neverheard);
            }
        }
        Collections.sort(intersection, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        int n =  intersection.size();
        sb.append(n+"\n");
        for(int i=0; i<intersection.size(); i++) sb.append(intersection.get(i) +"\n");

        System.out.println(sb);
    }

}
