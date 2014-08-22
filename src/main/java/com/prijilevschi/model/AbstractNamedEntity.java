package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractNamedEntity extends AbstractEntity {
    private static final long serialVersionUID = 8962077784688615358L;

    private String name;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
