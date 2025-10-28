package edu.unisabana.tyvs.domain.service;

import edu.unisabana.tyvs.domain.model.*;
import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<Person> registeredVoters;

    public Registry(){
        this.registeredVoters = new ArrayList<>();

        initializeVoters();
    }

    private void initializeVoters(){
        registeredVoters.add(new Person("Juan Pérez", 1001, 25, Gender.MALE, true));
        registeredVoters.add(new Person("María García", 1002, 30, Gender.FEMALE, true));
        registeredVoters.add(new Person("Carlos Rodríguez", 1003, 45, Gender.MALE, true));
        registeredVoters.add(new Person("Ana Martínez", 1004, 22, Gender.FEMALE, true));
        registeredVoters.add(new Person("Pedro López", 1005, 17, Gender.MALE, true));
        registeredVoters.add(new Person("Laura Sánchez", 1006, 80, Gender.FEMALE, false)); 
    }

    private boolean isPersonRegistered(int id){
        for (Person voter: registeredVoters){
            if (voter.getId() == id){
                return true;
            }
        }
        return false;
    }

    public RegisterResult registerVoter(Person p) {
        
        if (p == null || p.getName() == null){
            return RegisterResult.INVALID;
        }

        if (p.getAge() < 18 || p.getId() <= 0){
            return RegisterResult.INVALID;
        }

        if (p.getGender() == null){
            return RegisterResult.INVALID;
        }

        if (!p.isAlive()) {
            return RegisterResult.INVALID;
        }
        
        if (isPersonRegistered(p.getId())){
            return RegisterResult.DUPLICATED;
        }

        registeredVoters.add(p);
        return RegisterResult.VALID;
    }
}