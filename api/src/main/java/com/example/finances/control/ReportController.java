package com.example.finances.control;

import com.example.finances.entities.Expense;
import com.example.finances.entities.ReportData;
import com.example.finances.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/expense")
    public ResponseEntity<List<Double>> ExpenseReport(){
        List<Double> expense = reportService.ExpenseReport();
        return ResponseEntity.ok().body(expense);
    }

    @GetMapping("/salary")
    public ResponseEntity<List<Double>> SalaryReport(){
        return ResponseEntity.ok().body(reportService.SalaryReport());
    }

    @GetMapping
    public ResponseEntity<ReportData> ReportData(){
        return ResponseEntity.ok().body(reportService.getReport());
    }

    @GetMapping("total")
    public ResponseEntity<List<Expense>> getMonthlyTotalAmount(@RequestParam("date") String date){
        return ResponseEntity.ok().body(reportService.getMonthlyTotalAmount(date));
    }


}
