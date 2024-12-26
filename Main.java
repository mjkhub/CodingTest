import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Balloon> list = new LinkedList<>();

        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            list.add(new Balloon(i+1, Integer.parseInt(s[i])));

        int index = 0;
        while(!list.isEmpty()){
            Balloon b = list.remove(index);
            sb.append(b.number).append(' ');
            if(list.isEmpty()) break; // last case

            int move = b.weight; // 이 핵심 로직을 생각 못함
            if(move > 0 ) index = (index + b.weight - 1) % list.size();
            else index = ( index + b.weight) % list.size();
            if(index < 0) index = list.size() + index;
        }
        System.out.println(sb);
    }

    static class Balloon{
        int number; // 맨 처음에 있던 순서
        int weight; // 인덱스

        public Balloon(int number, int weight){
            this.number = number;
            this.weight = weight;
        }
    }


}
