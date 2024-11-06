import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main { // boj 1051

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { //boj 1141

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        List<String> arr = new ArrayList<>();
        for(int i =0; i<N; i++) {
            String word = br.readLine();
            if(!arr.contains(word)) arr.add(word);
        }

        for(int i=0; i<arr.size(); i++){
            String a = arr.get(i);
            boolean goodToAdd = true;
            for(int j=0; j<arr.size(); j++){
                if(i != j) {
                    String b = arr.get(j);
                    if(checkPrefix(a,b) ){
                        goodToAdd = false;
                        continue;
                    }
                }
            }
            if(goodToAdd) answer++;
        }

        System.out.println(answer);

    }



    public static boolean checkPrefix(String a, String b){ //a가 b의 prefix 인지 확인
        if(a.length() > b.length()) return false;

        boolean isPrefix = true;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) isPrefix =false;
        }
        return isPrefix;
    }
}