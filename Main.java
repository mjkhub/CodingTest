import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] cards;
    public static List<List<Integer>> answer;
    public static int n;
    public static int[] p, s;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        for(int i=0; i<3; i++) answer.add(new ArrayList<>());

        cards = new int[n];
        for(int i=0; i<n; i++) cards[i] = i;

        p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        makeAnswer();
        if(isAnswer()){
            System.out.println(0);
            return;
        }

        int count =0;
        while(true){
            swap();
            count++;
            if(isAnswer())
                break;
            if(count == Integer.MAX_VALUE / 10000 ){ // 이게 맞나 싶긴한데 . . .
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);

    }

    public static void makeAnswer(){
        for(int i=0; i<n; i++){
            List<Integer> playerCards = answer.get(p[i]);
            playerCards.add(i);
        }
    }

    public static void swap(){
        int[] swappedCards = new int[n];

        for(int i=0; i<n; i++){
            swappedCards[s[i]] = cards[i];
        }
        cards = swappedCards;
    }


    public static boolean isAnswer(){
        for(int i=0; i<n; i++){
            int playerNumber = i % 3;
            if(!answer.get(playerNumber).contains(cards[i])) return false;
        }
        return true;
    }


}
