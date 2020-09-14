package com.vjava.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    public Person(Long id, String fistName, String lastName){
        super(id);
        this.firstName = fistName;
        this.lastName = lastName;
    }
    @Column(name = "fist_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


}
