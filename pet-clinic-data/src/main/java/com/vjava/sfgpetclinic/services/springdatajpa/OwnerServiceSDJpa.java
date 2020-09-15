package com.vjava.sfgpetclinic.services.springdatajpa;

import com.vjava.sfgpetclinic.model.Owner;
import com.vjava.sfgpetclinic.repositories.OwnerRepository;
import com.vjava.sfgpetclinic.repositories.PetRepository;
import com.vjava.sfgpetclinic.repositories.PetTypeRepository;
import com.vjava.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerServiceSDJpa implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceSDJpa(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameIgnoreCaseLike(String lastName) {
        return ownerRepository.findAllByLastNameIgnoreCaseLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
