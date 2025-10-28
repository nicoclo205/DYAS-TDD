package edu.unisabana.tyvs.domain.service;

import edu.unisabana.tyvs.domain.model.*;
import java.util.ArrayList;
import java.util.List;

public class Registry {

    // 🔹 Constantes descriptivas para evitar "números mágicos"
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 120;

    // Lista que almacena los votantes registrados
    private final List<Person> registeredVoters;

    public Registry() {
        this.registeredVoters = new ArrayList<>();
        initializeVoters();
    }

    /**
     * Inicializa el registro con algunos votantes preexistentes.
     * Esto simula una base de datos inicial.
     */
    private void initializeVoters() {
        registeredVoters.add(new Person("Juan Pérez", 1001, 25, Gender.MALE, true));
        registeredVoters.add(new Person("María García", 1002, 30, Gender.FEMALE, true));
        registeredVoters.add(new Person("Carlos Rodríguez", 1003, 45, Gender.MALE, true));
        registeredVoters.add(new Person("Ana Martínez", 1004, 22, Gender.FEMALE, true));
        registeredVoters.add(new Person("Pedro López", 1005, 17, Gender.MALE, true));
        registeredVoters.add(new Person("Laura Sánchez", 1006, 80, Gender.FEMALE, false)); 
    }

    private boolean isPersonRegistered(int id) {
        return registeredVoters.stream()
                .anyMatch(voter -> voter.getId() == id);
    }


    public RegisterResult registerVoter(Person person) {

        // Validaciones de entrada
        if (person == null || person.getName() == null || person.getGender() == null) {
            return RegisterResult.INVALID;
        }

        // Validación de edad y ID
        if (person.getAge() < MIN_AGE || person.getAge() > MAX_AGE || person.getId() <= 0) {
            return RegisterResult.INVALID;
        }

        // Verificación de estado vital
        if (!person.isAlive()) {
            return RegisterResult.INVALID; 
        }

        // Evitar duplicados
        if (isPersonRegistered(person.getId())) {
            return RegisterResult.DUPLICATED;
        }

        // Registro exitoso
        registeredVoters.add(person);
        return RegisterResult.VALID;
    }
}
