package codingtest.brute_force;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public static void main(String[] args){

        LocalDateTime now = LocalDateTime.now();

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();


        // DateTimeFormatter를 이용하여 원하는 형식 설정
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // 포맷 적용
        String formattedDate = localDate.format(dateFormatter);
        String formattedTime = localTime.format(timeFormatter);

        System.out.println("formattedTime = " + formattedDate);
        System.out.println("formattedTime = " + formattedTime);

    }
}
