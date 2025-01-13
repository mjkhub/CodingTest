import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        String s = br.readLine();

        int startIndex = 0;
        int endIndex = 10;

        int totalCount = (int)Math.ceil((double)s.length() / 10);
        for(int i=0; i<totalCount; i++){
            if(endIndex > s.length())
                endIndex = s.length();

            System.out.println(s.substring(startIndex,endIndex));
            startIndex += 10;
            endIndex +=10;

        }


    }

}
