package com.example.finances.control;

import com.example.finances.entities.FamilyMember;
import com.example.finances.services.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/familyMembers")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberService Service;

    @GetMapping
    //ResponseEntity é uma classe do Spring Framework que representa a resposta HTTP completa
    private ResponseEntity<List<FamilyMember>> getAllFamilyMembers() {
        List<FamilyMember> familyMembers = Service.findAll();

        //O método body() é utilizado para definir o corpo da resposta
        //O método ok() cria uma resposta HTTP com o status 200 OK
        return ResponseEntity.ok().body(familyMembers);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FamilyMember> getFamilyMemberById(@PathVariable Long id) {
        FamilyMember familyMember = Service.findById(id);
        return ResponseEntity.ok().body(familyMember);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteFamilyMemberById(@PathVariable Long id) {
        Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    private ResponseEntity<Void> createFamilyMember(@RequestBody FamilyMember familyMember) {
        Service.save(familyMember);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    private ResponseEntity<Void> updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember familyMember) {
        Service.update(id, familyMember);
        return ResponseEntity.ok().build();
    }

}
