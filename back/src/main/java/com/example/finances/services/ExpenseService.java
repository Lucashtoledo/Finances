package com.example.finances.services;

import com.example.finances.entities.Expense;
import com.example.finances.repositories.ExpenseRepository;
import com.example.finances.repositories.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public List<Expense> findAll() {
        List<Expense> expenses = repository.findAll();
        return expenses;
    }
    public Expense findById(Long id) {
        Optional<Expense> expense = repository.findById(id);
        return expense.get();// A chamada de expense.get() pode lançar uma exceção caso o usuário não seja encontrado
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Expense save(Expense expense) {
        repository.save(expense);
        return expense;
    }
    public Expense update(Long id, Expense expense) {
        Optional<Expense> updatedExpense = repository.findById(id);
        if (updatedExpense.isPresent()) {
            updatedExpense.get().setDescription(expense.getDescription());
            updatedExpense.get().setAmount(expense.getAmount());
            updatedExpense.get().setFamilyMember(expense.getFamilyMember());
            return repository.save(updatedExpense.get());
        }
        throw new EntityNotFoundException("Expense not found");
    }
}
