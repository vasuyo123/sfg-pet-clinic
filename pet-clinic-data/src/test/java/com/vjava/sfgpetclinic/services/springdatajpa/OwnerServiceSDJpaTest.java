package com.vjava.sfgpetclinic.services.springdatajpa;

import com.vjava.sfgpetclinic.repositories.OwnerRepository;
import com.vjava.sfgpetclinic.repositories.PetRepository;
import com.vjava.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJpaTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceSDJpa ownerServiceSDJpa;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {

    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}