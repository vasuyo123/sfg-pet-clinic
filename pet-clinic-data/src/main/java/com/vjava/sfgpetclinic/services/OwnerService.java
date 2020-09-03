package com.vjava.sfgpetclinic.services;

import com.vjava.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
