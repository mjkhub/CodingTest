import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while( t-- > 0 ){
            boolean reversed = false;
            boolean error = false;
            String[] commands = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String arrayInput = br.readLine();

            // 빈 배열 처리 수정
            if (n == 0) {
                numbers = new ArrayList<>();
            } else {
                String[] stringNumbers = arrayInput.substring(1, arrayInput.length() - 1).split(",");
                for (String num : stringNumbers) {
                    numbers.add(Integer.parseInt(num));
                }
            }

            for(String command: commands){
                if(command.equals("R")){
                    reversed = !reversed;
                }else{ // D
                    if(numbers.isEmpty()){
                        error = true;
                        break;
                    }else{
                        if(reversed) numbers.remove(numbers.size()-1);
                        else numbers.remove(0);
                    }
                }
            }
            if(error) {
                sb.append("error").append('\n');

            }else{
                sb.append("[");
                if(reversed){
                    for(int i=numbers.size()-1; i>=0; i--){
                        sb.append(numbers.get(i));
                        if(i!=0)
                            sb.append(",");
                    }
                }else{
                    for(int i=0; i< numbers.size(); i++){
                        sb.append(numbers.get(i));
                        if(i!=numbers.size()-1)
                            sb.append(",");
                    }
                }
                sb.append("]\n");
            }
            numbers = new ArrayList<>();
        }

        System.out.println(sb);
    }
}
