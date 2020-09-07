package com.vjava.sfgpetclinic.bootstrap;

import com.vjava.sfgpetclinic.model.Owner;
import com.vjava.sfgpetclinic.model.Vet;
import com.vjava.sfgpetclinic.services.OwnerService;
import com.vjava.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
   private final OwnerService ownerService;
   private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glen");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner1.setId(3L);
        owner1.setFirstName("Vasu");
        owner1.setLastName("Neelapala");

        ownerService.save(owner3);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Paul");
        vet2.setLastName("Alexander");

        vetService.save(vet2);

        System.out.println("Loaded Vets..");

    }
}
