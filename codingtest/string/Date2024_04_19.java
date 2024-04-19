package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Date2024_04_19 { //boj 4949

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        String input;
        while(!(input=br.readLine()).equals("."))
            sb.append(validateStringSeq(input)).append('\n');
        System.out.println(sb);

    }

    public static String validateStringSeq(String input){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<input.length(); i++){
            char seq = input.charAt(i);
            if(seq == '('){
                stack.push('(');
            }else if(seq == ')'){
                if(stack.isEmpty()) return "no";
                if(stack.peek() != '(') return "no";
                stack.pop();
            }

            if(seq == '['){
                stack.push('[');
            }else if(seq == ']'){
                if(stack.isEmpty()) return "no";
                if(stack.peek() != '[') return "no";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "no";
        return "yes";
    }

}
