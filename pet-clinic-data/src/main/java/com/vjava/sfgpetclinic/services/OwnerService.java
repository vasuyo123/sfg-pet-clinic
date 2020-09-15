package com.vjava.sfgpetclinic.services;

import com.vjava.sfgpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameIgnoreCaseLike(String lastName);

}
