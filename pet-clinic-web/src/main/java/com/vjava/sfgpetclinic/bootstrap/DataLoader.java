package com.vjava.sfgpetclinic.bootstrap;

import com.vjava.sfgpetclinic.model.*;
import com.vjava.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        System.out.println("dog Type Id: "+savedDogPetType.getId()+" :dog Type Name: "+savedDogPetType.getName());

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("cat Type Id: "+savedCatPetType.getId()+" :cat Type Name: "+savedCatPetType.getName());

        PetType tiger = new PetType();
        tiger.setName("Tiger");
        PetType savedTigerPetType = petTypeService.save(tiger);
        System.out.println("Tiger Type Id: "+savedTigerPetType.getId()+" :Tiger Type Name: "+savedTigerPetType.getName());

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Street");
        owner1.setCity("His City");
        owner1.setTelephone("234-678-5433");


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Mikes Dog");
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        petService.save(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");
        owner2.setAddress("123 Ave");
        owner2.setCity("Their City");
        owner2.setTelephone("634-678-4433");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setName("Fionas Cat");
        fionasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasPet);
        petService.save(fionasPet);
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Vasu");
        owner3.setLastName("Neelapala");
        owner3.setAddress("123 Dr");
        owner3.setCity("Happy City");
        owner3.setTelephone("534-322-4356");

        Pet vasusTiger = new Pet();
        vasusTiger.setPetType(savedTigerPetType);
        vasusTiger.setOwner(owner3);
        vasusTiger.setName("Vasus Tiger");
        vasusTiger.setBirthDate(LocalDate.now());
        owner3.getPets().add(vasusTiger);
        petService.save(vasusTiger);
        ownerService.save(owner3);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialitySet().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Paul");
        vet2.setLastName("Alexander");
        vet2.getSpecialitySet().add(savedDentistry);
        vet2.getSpecialitySet().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets..");

        Visit fionasCatVisit = new Visit();
        fionasCatVisit.setPet(fionasPet);
        fionasCatVisit.setDate(LocalDate.now());
        fionasCatVisit.setDescription("Sneezy Kitty");
        visitService.save(fionasCatVisit);

        System.out.println("Loaded Visits");
    }
}
