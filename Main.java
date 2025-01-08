import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<Circle> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        for(int i=0; i<4; i++){
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Circle circle = new Circle(arr);
            list.add(circle);
        }

        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            String[] s = br.readLine().split(" ");
            int index = Integer.parseInt(s[0])-1;
            int wise = Integer.parseInt(s[1]);

            boolean[] visit = new boolean[4];
            Queue<Job> queue = new LinkedList<>();
            queue.add(new Job(index,wise));

            while(!queue.isEmpty()){
                Job job = queue.poll();
                int idx = job.index;
                visit[idx] = true;

                if(idx == 0){
                    Circle c0 = list.get(0);
                    Circle c1 = list.get(1);
                    if(c0.getRight() != c1.getLeft() && !visit[1]){
                        queue.offer(new Job(1, job.wise*-1));
                    }
                    c0.move(job.wise);
                }else if(idx == 3){
                    Circle c0 = list.get(3);
                    Circle c1 = list.get(2);
                    if(c0.getLeft() != c1.getRight() && !visit[2]){
                        queue.offer(new Job(2, job.wise*-1));
                    }
                    c0.move(job.wise);
                }else{
                    Circle c0 = list.get(job.index);
                    Circle c1 = list.get(job.index-1);
                    Circle c2 = list.get(job.index+1);

                    if(c0.getLeft() != c1.getRight() && !visit[job.index-1]){
                        queue.offer(new Job(job.index-1, job.wise*-1));
                    }

                    if(c0.getRight() != c2.getLeft() && !visit[job.index+1]){
                        queue.offer(new Job(job.index+1, job.wise*-1));
                    }
                    c0.move(job.wise);
                }

            }

        }

        int score =0;
        for(int i=0; i<4; i++){
            Circle circle = list.get(i);
            int twelve = circle.get12();
            if(twelve == 1){
                int temp = 1;
                for(int j=0; j<i; j++){
                    temp *=2;
                }
                score+=temp;
            }
        }
        System.out.println(score);
    }


    static class Circle{
        int[] arr;

        public Circle(int[] arr){
            this.arr = arr;
        }
        public void move(int wise){
            if(wise == 1) moveClock();
            else moveUnClock();
        }
        private void moveClock(){
            int[] temp = new int[8];
            for(int i=0; i<8; i++){
                temp[i] = arr[(i+7)%8];
            }
            arr = temp;
        }

        private void moveUnClock(){
            int[] temp = new int[8];
            for(int i=0; i<8; i++){
                temp[i] = arr[(i+1)%8];
            }
            arr = temp;
        }

        public int getLeft(){
            return arr[6];
        }

        public int getRight(){
            return arr[2];
        }
        public int get12(){
            return arr[0];
        }

    }

    static class Job{
        int index;
        int wise;

        public Job(int index, int wise){
            this.index = index;
            this.wise = wise;
        }

    }




}
