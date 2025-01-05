import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static int count = 0;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String s = br.readLine();
            if(checkIsGoodWord(s)) count++;
        }
        System.out.println(count);

    }

    public static boolean checkIsGoodWord(String s){
        int size = s.length();
        if( size % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<size; i++){
            char c = s.charAt(i);
            if(stack.isEmpty()) stack.push(c);
            else{ //
                if(c != stack.peek()) stack.push(c);
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

}
