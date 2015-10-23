package com.prijilevschi.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "depositController")
@RequestScoped
public class DepositController implements Serializable {
    private static final long serialVersionUID = 5930564554393379903L;

    @PostConstruct
    public void init(){

    }

}
