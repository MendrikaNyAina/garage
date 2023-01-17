/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import framework.database.annotation.Champs;
import framework.database.annotation.Table;
import model.employe.Specialite;

/**
 *
 * @author Chalman
 */
@Table(nomtable="main_oeuvre")
public class MainOeuvre {
    @Champs
    Integer id;
    @Champs ( mapcol="id", name="specialite_id")
    Specialite specialite;
    @Champs ( name="temps_fournis")
    Double tempsFournis;
    @Champs(name="type_service_id")
    Integer serviceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Double getTempsFournis() {
        return tempsFournis;
    }

    public void setTempsFournis(Double tempsFournis) {
        this.tempsFournis = tempsFournis;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public MainOeuvre() {
    }

    public MainOeuvre(Integer id, Specialite specialite, Double tempsFournis, Integer serviceId) {
        this.id = id;
        this.specialite = specialite;
        this.tempsFournis = tempsFournis;
        this.serviceId = serviceId;
    }
    
    
}
