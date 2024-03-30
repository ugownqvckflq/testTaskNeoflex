package com.nazarov.neoflex.entities;
import java.time.LocalDate;


public class SalaryRequest {
    private Double averageSalary;//средняя зп сотрудника за 12 месяцев
    private int vacationDays;//дни отдыха
    private LocalDate startDate;//дата начала отпуска
    private LocalDate endDate;//дата окончания отпуска

    public SalaryRequest(Double averageSalary, int vacationDays, LocalDate startDate, LocalDate endDate) {
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SalaryRequest() {

    }


    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
