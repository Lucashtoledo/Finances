package com.example.finances.services;

import com.example.finances.entities.FamilyMember;
import com.example.finances.repositories.FamilyMemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository repository;

    public List<FamilyMember> findAll() {
        List<FamilyMember> familyMembers = repository.findAll();
        return familyMembers;
    }
    public FamilyMember findById(Long id) {
        Optional<FamilyMember> familyMember = repository.findById(id);
        return familyMember.get();// A chamada de familyMember.get() pode lançar uma exceção caso o usuário não seja encontrado
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public FamilyMember save(FamilyMember familyMember) {
        repository.save(familyMember);
        return familyMember;
    }
    public FamilyMember update(Long id, FamilyMember familyMember) {
        Optional<FamilyMember> updatedFamilyMember = repository.findById(id);
        if (updatedFamilyMember.isPresent()) {
            updatedFamilyMember.get().setName(familyMember.getName());
            updatedFamilyMember.get().setEmail(familyMember.getEmail());
            updatedFamilyMember.get().setSalary(familyMember.getSalary());
            updatedFamilyMember.get().setExpenses(familyMember.getExpenses());
            return repository.save(updatedFamilyMember.get());
        }
        throw new EntityNotFoundException("FamilyMember not found");
    }
}
