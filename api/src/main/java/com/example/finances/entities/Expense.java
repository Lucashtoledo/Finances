package com.example.finances.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private LocalDate date;
    private LocalDate finalDate;
    private int dueDay;
    private int installmentCount = 9999;

    @ManyToOne
    @JoinColumn(name = "family_member_id")
    private FamilyMember familyMember;

    public Expense(Long id, String description, Double amount, int dueDay, int installmentCount, FamilyMember familyMember) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
        this.dueDay = dueDay;
        this.installmentCount = installmentCount;
        this.finalDate = date.plusMonths(installmentCount);
        this.familyMember = familyMember;
    }
    public Expense(Long id, String description, Double amount, int dueDay, FamilyMember familyMember) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
        this.dueDay = dueDay;
        this.familyMember = familyMember;
    }
}
