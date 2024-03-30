package com.nazarov.neoflex.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazarov.neoflex.entities.Holiday;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayClassifier {
    private static final List<LocalDate> holidays;

    static {
        holidays = new ArrayList<>();
        try {
            // Чтение файла holidayList.json и парсинг его в список дат
            InputStream inputStream = DayClassifier.class.getClassLoader().getResourceAsStream("holidayList.json");
            ObjectMapper objectMapper = new ObjectMapper();
            Holiday[] holidayArray = objectMapper.readValue(inputStream, Holiday[].class);
            for (Holiday holiday : holidayArray) {
                holidays.add(LocalDate.parse(holiday.getDate()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }

}
