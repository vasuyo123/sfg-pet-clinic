package com.vjava.sfgpetclinic.services.map;

import com.vjava.sfgpetclinic.model.Speciality;
import com.vjava.sfgpetclinic.model.Vet;
import com.vjava.sfgpetclinic.services.SpecialityService;
import com.vjava.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    /**if we get Vet object that has Specialities that have not been persisted,
    we are going to make sure that id has been stored.*/
    public Vet save(Vet vet) {
        if(vet.getSpecialitySet().size() > 0){
            vet.getSpecialitySet().forEach(speciality -> {
                //System.out.println("checking each speciality: "+speciality +": id: "+speciality.getId());
                if(speciality.getId() == null){
                    //System.out.println("YES...speciality.getId() was NULL");
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
