package com.nazarov.neoflex.service;

import com.nazarov.neoflex.util.DayClassifier;
import com.nazarov.neoflex.entities.SalaryRequest;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class VacationSalaryService {

    public Double calculateVacationSum(SalaryRequest request) {
        int workDays = getWorkingDaysBetweenTwoDates(request.getStartDate(), request.getEndDate()); //считаем рабочие дни
        double averagePerDay = request.getAverageSalary()*12/(12*29.3); // считаем средний дневной заработок, где 29.3 - среднее количество дней в одном месяце
        return averagePerDay*workDays;
    }

    private int getWorkingDaysBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        int workingDays = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    currentDate.getDayOfWeek() != DayOfWeek.SUNDAY &&
                    !DayClassifier.isHoliday(currentDate)) {
                workingDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return workingDays;
    }
}
