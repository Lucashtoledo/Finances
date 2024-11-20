package com.example.finances.services;

import com.example.finances.repositories.ExpenseRepository;
import com.example.finances.repositories.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    FamilyMemberRepository  familyMemberRepository;


}
