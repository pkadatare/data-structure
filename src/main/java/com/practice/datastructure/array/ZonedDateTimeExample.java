package com.practice.datastructure.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZonedDateTimeExample {

  private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  public static void main(String[] args) throws ParseException {
    String date = "2020-06-19";
    DateTimeFormatter localTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    ZonedDateTime pst = LocalDate.parse(date, localTimeFormatter).atStartOfDay(ZoneId.of("UTC"))
        .withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

    localTimeFormatter.format(pst);

    String[] array = {"url1", "url2", "url3", "url4"};

    Stream.of(array).collect(Collectors.joining("','", "'", "'"));





  }

  public static void dustbin() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
    DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    DateTimeFormatter format2 = DateTimeFormatter.ofPattern(DATE_FORMAT);
    String dateInString = "2020-06-18 23:11:52";
    String date = "2020-06-19";
    Date dd = simpleDateFormat.parse(dateInString);
    ZonedDateTime pstZonedDateTime = ZonedDateTime.ofInstant(dd.toInstant(), ZoneId.of("UTC"));
    LocalDateTime ldt = LocalDateTime.parse(dateInString, format);
    //ZonedDateTime pstZonedDateTime = ldt.atZone(ZoneId.of("America/Los_Angeles"));
    ZonedDateTime nyDateTime = pstZonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));

    System.out.println("Date (New York) : " + format.format(nyDateTime));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    SimpleDateFormat format3 = new SimpleDateFormat(DATE_TIME_FORMAT);
    ZonedDateTime pstDate= LocalDate.parse(date).atStartOfDay(ZoneId.of("UTC"))
        .withZoneSameInstant(ZoneId.of("PST"));
    System.out.println("Final date " + format3.parse(formatter.format(pstDate)));
  }

}
