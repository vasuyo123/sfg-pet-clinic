package com.vjava.sfgpetclinic.bootstrap;

import com.vjava.sfgpetclinic.model.Owner;
import com.vjava.sfgpetclinic.model.PetType;
import com.vjava.sfgpetclinic.model.Vet;
import com.vjava.sfgpetclinic.services.OwnerService;
import com.vjava.sfgpetclinic.services.PetTypeService;
import com.vjava.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
   private final OwnerService ownerService;
   private final VetService vetService;
   private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Vasu");
        owner3.setLastName("Neelapala");

        ownerService.save(owner3);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Paul");
        vet2.setLastName("Alexander");

        vetService.save(vet2);

        System.out.println("Loaded Vets..");

    }
}
