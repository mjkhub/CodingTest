package codingtest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Date2024_04_18_2 { //9012

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append(solve(br.readLine())).append('\n');
        }

        System.out.println(sb);

    }

    public static String solve(String paren) {
        Stack<Character> st = new Stack<>();
        for (int j = 0; j < paren.length(); j++) {
            char data = paren.charAt(j);
            if (data == '(') st.push(data);

            if (data == ')') {
                if (st.isEmpty()) {
                    return "NO";
                }
                st.pop();
            }

        }
        if (st.isEmpty()) return "YES";
        else return "NO";

    }
}
