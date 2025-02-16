import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static char[] buf;
    public static int l, c;
    public static char[] list;
    public static boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        l = Integer.parseInt(s[0]); // 암호 개수
        c = Integer.parseInt(s[1]); // 사용 했을 문자
        list = new char[c];
        buf = new char[l];
        String input = br.readLine();
        for(int i=0; i<c; i++)
            list[i] = input.charAt(i*2);

        Arrays.sort(list); // good idea
        dfs(0);

        System.out.println(sb);


    }

    public static void dfs(int depth){
        if(depth == l){
            int[] arr = getCountArr(new String(buf)); //이거
            if(arr[0]>=1 && arr[1]>=2){
                for (char ch : buf)
                    sb.append(ch);
                sb.append('\n');
            }
            return;
        }

        for(char ch : list){
            if(!visit[ch-'a']){
                visit[ch-'a'] = true;
                buf[depth] = ch;
                if(isOrdered(depth))
                    dfs(depth+1);
                visit[ch-'a'] = false;
            }
        }
    }

    public static boolean isOrdered(int depth){ // 사전식
        char prev = buf[0];
        for(int i=1; i<=depth; i++){
            if(prev > buf[i]) return false;
            prev = buf[i];
        }
        return true;
    }


    public static int[] getCountArr(String str){ // 모음 & 자음
        int[] arr = new int[2];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if( c == 'a' || c == 'e' || c== 'i' || c=='o' || c == 'u'){
                arr[0] += 1;
            }else{
                arr[1] += 1;
            }
        }
        return arr;
    }


}
