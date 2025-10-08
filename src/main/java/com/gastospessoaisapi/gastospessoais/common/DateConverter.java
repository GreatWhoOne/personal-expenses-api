package com.gastospessoaisapi.gastospessoais.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static String convertDateToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
    }
}
