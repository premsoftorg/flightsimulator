package com.altimetrik.flighsimulator.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
  public static Date getDateTime() {

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    try {
      return dateFormat.parse(dateFormat.format(new Date()));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return new Date();
  }
}
