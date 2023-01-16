/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import framework.database.annotation.*;
import framework.database.utilitaire.*;
import model.Model;
import java.sql.*;
/**
 *
 * @author Chalman
 */
public class TypeService extends Model {
    @Champs
    String nom;
    @Champs
    Double prix;
    @Champs
    String description;
    Double montant;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    
    
    public TypeService() {
    }

    public TypeService(String nom, Double prix, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }
    
       
    public Double calculMontant( Connection con  ) throws Exception {
        boolean iscon=true;
        if(con==null){
            iscon=false;
        }
        try {
            if (con == null) {
                con = GConnection.getSimpleConnection();
                iscon = false;
            }
            this.montant = ObjectBdd.getColByExec( "select montant from v_cout_service where id=" + getId() , 1.00, con);
        } catch (Exception e) {
            throw new Exception("Requete non faites" + e.getMessage());
        }finally{
            if(!iscon){
                con.close();
            }
        }
        return this.montant;
    }
}
