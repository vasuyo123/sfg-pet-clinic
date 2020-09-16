package com.vjava.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity{

    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }

    @Column
    private String name;


    @Override
    public String toString(){
        return name;
    }

}
