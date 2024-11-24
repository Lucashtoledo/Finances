package com.example.finances.services;

import com.example.finances.entities.Expense;
import com.example.finances.entities.FamilyMember;
import com.example.finances.entities.ReportData;
import com.example.finances.repositories.ExpenseRepository;
import com.example.finances.repositories.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    FamilyMemberRepository  familyMemberRepository;

    public List<Double> ExpenseReport() {
        List<Expense> expenses = expenseRepository.findAll();
        List<Double> expensesReport = new ArrayList<>();
        for (Expense expense : expenses) {
            expensesReport.add(expense.getAmount());
        }
        return expensesReport;
    }

    public List<Double> SalaryReport() {
        // Recupera todos os membros da família do repositório
        List<FamilyMember> familyMembers = familyMemberRepository.findAll();

        return familyMembers
                .stream()  // Cria o stream a partir da lista
                .map(FamilyMember::getSalary)  // Mapeia cada FamilyMember para seu salário
                .collect(Collectors.toList());  // Coleta os resultados em uma lista de Double
    }


    public List<Expense> getMonthlyTotalAmount(String ld){
        LocalDate date = LocalDate.parse(ld);
        List<Expense> expenses = expenseRepository.findAll();
        List<Expense> presentExpenses = new ArrayList<>();

        expenses.forEach(expense ->{
            if (expense.getInstallmentCount() == 9999){
                presentExpenses.add(expense);
            }else if (expense.getInstallmentCount() > 0 && expense.getInstallmentCount() < 9999){
                long daysDifference = ChronoUnit.DAYS.between(date, expense.getFinalDate());
                if (daysDifference > 0){
                    presentExpenses.add(expense);
                }
            }
        });

        return presentExpenses;
    }

    public ReportData getReport(){
        return new ReportData(SalaryReport(), ExpenseReport());
    }


}
