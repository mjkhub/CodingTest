import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int N;
    public static char[][] binaryTree;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException { // boj 1991

        N = Integer.parseInt(br.readLine());
        binaryTree = new char[N][2];

        for(int i=0; i<N; i++){ // init
            String data = br.readLine().replace(" ", "");
            char node = data.charAt(0);
            char left = data.charAt(1);
            char right = data.charAt(2);
            binaryTree[node-'A'][0] = left;
            binaryTree[node-'A'][1] = right;
        }
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);

    }

    public static void preOrder(int n){
        sb.append((char) ('A'+ n) ); //visit
        char[] children = binaryTree[n];
        for(char child : children){
            if(child!='.'){
                preOrder(child-'A');
            }
        }
    }

    public static void postOrder(int n){
        char[] children = binaryTree[n];
        for(char child : children){
            if(child!='.'){
                postOrder(child-'A');
            }
        }
        sb.append((char) ('A'+ n) ); //visit
    }


    public static void inOrder(int n){
        char[] children = binaryTree[n];
        char left = children[0];
        char right = children[1];
        if(left != '.') inOrder(left-'A');

        sb.append((char) ('A'+ n) ); //visit
        if(right != '.') inOrder(right-'A');

    }


}