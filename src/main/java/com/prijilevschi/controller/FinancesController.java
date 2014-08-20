package com.prijilevschi.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "financesController")
@RequestScoped
public class FinancesController implements Serializable {
    private static final long serialVersionUID = 5930564554393379903L;

    @PostConstruct
    public void init(){

    }

}
