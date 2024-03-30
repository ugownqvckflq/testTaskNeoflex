package com.nazarov.neoflex.controller;


import com.nazarov.neoflex.entities.SalaryRequest;
import com.nazarov.neoflex.service.VacationSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationSalaryController {
    private final VacationSalaryService vacationSalaryService;

    @Autowired
    public VacationSalaryController(VacationSalaryService vacationSalaryService) {
        this.vacationSalaryService = vacationSalaryService;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<String> calculateVacation(@RequestBody SalaryRequest request) {
        Double vacationSum = vacationSalaryService.calculateVacationSum(request);
        return ResponseEntity.ok("Сумма отпускных: " + vacationSum);
    }
}
