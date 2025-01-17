import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Student[] arr;
    public static int n;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new Student[n];
        int k = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<k; i++){
            int number = numbers[i];
            int index = contains(number);
            if(index != -1) // 이미 존재
                arr[index].count +=1;
            else{ //새로운 위치를 할당 받고 넣어야함
                index = getMinIndex();
                arr[index] = new Student(number);
            }
            updateTime(); // 시간 Up
        }


        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i] != null)
                answer.add(arr[i].number);
        }

        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++)
            System.out.print(answer.get(i)+" ");

    }

    public static int contains(int number){
        for(int i=0; i<n; i++){
            if(arr[i]!=null && arr[i].number==number)
                return i;
        }
        return -1;
    }

    public static int getMinIndex(){
        int minIndex = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == null) return i;
            else{
                if(arr[minIndex].count > arr[i].count )
                    minIndex = i;
                else if(arr[minIndex].count == arr[i].count
                && arr[minIndex].time < arr[i].time)
                    minIndex = i;
            }
        }
        return minIndex;
    }
    public static void updateTime(){
        for(int i=0; i<n; i++){
            if(arr[i]!= null){
                arr[i].updateTime();
            }
        }
    }

    static class Student{
        int number;
        int time;
        int count;

        public Student (int number){
            this.number = number;
            this.time = 0;
            this.count = 1;
        }

        public void updateTime(){
            time++;
        }

        public int getNumber(){
            return number;
        }

    }

}
