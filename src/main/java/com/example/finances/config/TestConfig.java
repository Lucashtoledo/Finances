/*Essa classe define uma configuração específica para o
perfil test e executa o método run quando a
aplicação é iniciada nesse perfil*/

package com.example.finances.config;

import com.example.finances.entities.User;
import com.example.finances.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // Marca essa classe como uma classe de configuração Spring
@Profile("test") // Indica que essa classe de configuração será ativada apenas quando o perfil ativo for "test"
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository Repository;

    @Override
    /* O método run é executado automaticamente logo após a inicialização do contexto Spring,
    permitindo que você execute algum código específico no início da aplicação.*/
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Bob", "bob@mail.com", 5500.00);
        User u2 = new User(null, "Maria", "maria@mail.com", 6000.00);

        Repository.save(u1);
        Repository.save(u2);

    }
}
