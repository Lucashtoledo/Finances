/*Essa classe define uma configuração específica para o
perfil test e executa o método run quando a
aplicação é iniciada nesse perfil*/

package com.example.finances.config;

import com.example.finances.entities.Expense;
import com.example.finances.entities.FamilyMember;
import com.example.finances.repositories.ExpenseRepository;
import com.example.finances.repositories.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration // Marca essa classe como uma classe de configuração Spring
@Profile("test") // Indica que essa classe de configuração será ativada apenas quando o perfil ativo for "test"
public class TestConfig implements CommandLineRunner {

    @Autowired
    private FamilyMemberRepository Repository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    /* O método run é executado automaticamente logo após a inicialização do contexto Spring,
    permitindo que você execute algum código específico no início da aplicação.*/
    public void run(String... args) throws Exception {
        // Criar membros da família
        FamilyMember member1 = new FamilyMember(null, "Bob", "bob@mail.com", 5500.00);
        FamilyMember member2 = new FamilyMember(null, "Maria", "maria@mail.com", 6000.00);

        // Salvar membros da família
        Repository.save(member1);
        Repository.save(member2);
        // Criar despesas
        Expense expense1 = new Expense(null, "Balé da Maria", 120.00, 23, member1);
        Expense expense2 = new Expense(null, "Gás de Cozinha", 100.00, 7, member1);
        Expense expense3 = new Expense(null, "Conta de Luz", 280.00, 15, member2);
        Expense expense4 = new Expense(null, "Conta de Água", 220.00, 21, member2);
        Expense expense5 = new Expense(null, "Moto", 750.00, 21, 15, member1);


        // Salvar despesas
        expenseRepository.save(expense1);
        expenseRepository.save(expense2);
        expenseRepository.save(expense3);
        expenseRepository.save(expense4);
        expenseRepository.save(expense5);

    }

}
