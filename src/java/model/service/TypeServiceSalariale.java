/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import framework.database.annotation.Champs;
import framework.database.annotation.Table;

/**
 *
 * @author ITU
 */
@Table( nomtable="v_cout_service")
public class TypeServiceSalariale extends TypeService{
    @Champs
    Double montant ;
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
    public TypeServiceSalariale(){}
    public TypeServiceSalariale(Double montant){
        setMontant(montant);
    }
    
}
