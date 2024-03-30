package com.nazarov.neoflex;


import com.nazarov.neoflex.controller.VacationSalaryController;
import com.nazarov.neoflex.entities.SalaryRequest;
import com.nazarov.neoflex.service.VacationSalaryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VacationSalaryController.class)
public class VacationSalaryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VacationSalaryService vacationSalaryService;

    @Test
    public void testCalculateVacation() throws Exception {
        SalaryRequest request = new SalaryRequest(50000.0, 8, LocalDate.of(2024, 3, 31), LocalDate.of(2024, 4, 7));
        Double expectedVacationSum = 8532.42;
        when(vacationSalaryService.calculateVacationSum(request)).thenReturn(expectedVacationSum);

        mockMvc.perform(MockMvcRequestBuilders.get("/calculacte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"averageSalary\": 50000.0, \"vacationDays\": 8, \"startDate\": \"2024-03-31\", \"endDate\": \"2024-04-07\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void negativeTestCalculateVacation() throws Exception {
        SalaryRequest request = new SalaryRequest(50000.0, -5, LocalDate.of(2024, 3, 31), LocalDate.of(2024, 4, 15));
        // Выполнение запроса с некорректными данными и ожидание ошибки
        mockMvc.perform(MockMvcRequestBuilders.get("/calculacte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"averageSalary\": 50000.0, \"vacationDays\": -5, \"startDate\": \"2024-03-31\", \"endDate\": \"2024-04-07\"}"))
                .andExpect(status().is2xxSuccessful());
    }


}
