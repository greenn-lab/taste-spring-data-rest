package com.github.greenn.lab.springdatarest;

import com.github.greenn.lab.springdatarest.todo.Todo;
import com.github.greenn.lab.springdatarest.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataRestApplication {

    private final TodoRepository repository;


    @PostConstruct
    public void init() {
        final Todo todo = new Todo();
        todo.setTitle("sleep over 6 hours");
        repository.save(todo);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }



}
