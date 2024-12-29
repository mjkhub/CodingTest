import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] mapping = {{0,2,0,1}, {2,1,3,0}, {0,3,2,1}, {1,0,1,3}};
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if(n==1){
            System.out.println(s);
            return;
        }
        
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A') arr.add(0);
            else if( c=='G') arr.add(1);
            else if( c== 'C') arr.add(2);
            else arr.add(3);
        }

        while(arr.size()>1){ // 이게 왜 arr.size() !=1 이면 안될까!
            int lastIndex = arr.size()-1;
            int lastBeforeIndex = lastIndex-1;

            int m1 = getMapping(arr.get(lastBeforeIndex), arr.get(lastIndex));
            arr.remove(lastIndex);
            arr.remove(lastBeforeIndex);
            arr.add(m1);
        }

        int value = arr.get(0);
        if(value == 0) System.out.println("A");
        else if( value == 1) System.out.println("G");
        else if( value == 2) System.out.println("C");
        else System.out.println("T");
    }

    public static int getMapping(int lastIndex, int lastBeforeIndex){
        return mapping[lastBeforeIndex][lastIndex];
    }





}
