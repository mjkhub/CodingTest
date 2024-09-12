package codingtest.lets_do_it;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Date_2024_09_12 { //10814

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Member> memberList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String[] ageAndName = br.readLine().split(" ");
            int age = Integer.parseInt(ageAndName[0]);
            String name = ageAndName[1];
            memberList.add(new Member(i,age,name));
        }

        memberList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age < o2.age) return -1;
                else if(o1.age == o2.age) return o1.signUpOrder - o2.signUpOrder;
                return 1;
            }
        });

        for (Member member : memberList) {
            System.out.println(member.age +" "+member.name);
        }


    }

    static class Member{
        int signUpOrder;
        int age;
        String name;

        public Member(int signUpOrder, int age, String name) {
            this.signUpOrder = signUpOrder;
            this.age = age;
            this.name = name;
        }
    }
}
