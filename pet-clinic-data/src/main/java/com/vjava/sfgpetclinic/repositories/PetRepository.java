package com.vjava.sfgpetclinic.repositories;

import com.vjava.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
