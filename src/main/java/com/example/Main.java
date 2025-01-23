package com.example;

import com.example.entity.Person;
import com.example.repository.PersonRepository;

public class Main {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();

        // Добавление объектов
        repository.addPerson(new Person("Иван", 25));
        repository.addPerson(new Person("Мария", 30));

        // Получение всех объектов
        System.out.println("Все объекты: " + repository.getAllPersons());

        // Закрытие EntityManagerFactory
        PersonRepository.close();
    }
}
