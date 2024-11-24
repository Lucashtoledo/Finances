package com.example.finances.control;

import com.example.finances.entities.Expense;
import com.example.finances.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService Service;

    @GetMapping
    //ResponseEntity é uma classe do Spring Framework que representa a resposta HTTP completa
    private ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = Service.findAll();

        //O método body() é utilizado para definir o corpo da resposta
        //O método ok() cria uma resposta HTTP com o status 200 OK
        return ResponseEntity.ok().body(expenses);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = Service.findById(id);
        return ResponseEntity.ok().body(expense);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteExpenseById(@PathVariable Long id) {
        Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    private ResponseEntity<Void> createExpense(@RequestBody Expense expense) {
        Service.save(expense);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    private ResponseEntity<Void> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Service.update(id, expense);
        return ResponseEntity.ok().build();
    }

}
