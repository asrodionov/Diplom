package ru.netology.web.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardYear {

    public static int getYearCard(int yearInc){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        LocalDateTime date = LocalDateTime.now();

        String cardYear = date.plusYears(yearInc).format(formatter);

        return Integer.parseInt(cardYear);
    }
}
