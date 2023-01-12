package util;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UtilDate {
    public int getAge( Date dateNaissance) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Date dateNow = Date.valueOf(dtf.format(now));
        int year = dateNaissance.getYear();
        int yearNow = dateNow.getYear()+1900;
        int age = yearNow-year;
        
        return age;        
    }
}
