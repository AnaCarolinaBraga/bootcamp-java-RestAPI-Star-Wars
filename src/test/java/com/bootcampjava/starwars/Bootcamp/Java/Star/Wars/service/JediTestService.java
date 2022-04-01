package com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.service;

import com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.model.Jedi;
import com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.repository.JediRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JediTestService {

    @Autowired
    private JediService jediService;

    @MockBean
    private JediRepositoryImpl jediRepository;    //mock de uma classe

    @Test
    @DisplayName("Should return Jedi with success")    //Aqui é para aparecer no display o que era para ocorrer
    public void testFindBySuccess() {

        // cenario
        Jedi mockJedi = new Jedi(1, "Jedi Name", 10, 1);     //mock de um objeto
        Mockito.doReturn(Optional.of(mockJedi)).when(jediRepository).findById(1);    //o que quero que retorne

        // execucao, o que deve acontecer
        Optional<Jedi> returnedJedi  = jediService.findById(1);

        // assert, resposta
        Assertions.assertTrue(returnedJedi.isPresent(), "Jedi was not found");
        Assertions.assertSame(returnedJedi.get(), mockJedi, "Jedis must be the same");
    }

    // TODO: Criar teste de erro NOT FOUND (Entender primeiro o que foi que fizemos)

    // TODO: Criar um teste pro findAll(); (Entender primeiro o que foi que fizemos)
}
