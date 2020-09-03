package com.vjava.sfgpetclinic.services;

import com.vjava.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();

}
