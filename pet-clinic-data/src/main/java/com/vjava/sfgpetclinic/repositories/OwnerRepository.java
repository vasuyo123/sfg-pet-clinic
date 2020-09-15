package com.vjava.sfgpetclinic.repositories;

import com.vjava.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
     Owner findByLastName(String lastName);

     List<Owner> findAllByLastNameIgnoreCaseLike(String lastName);
}
