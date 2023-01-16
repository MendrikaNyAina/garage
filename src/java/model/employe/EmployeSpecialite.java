package model.employe;

import framework.database.utilitaire.*;
import framework.database.annotation.Champs;
import java.sql.Connection;

public class EmployeSpecialite extends ObjectBdd {
    @Champs
    Integer employeId, specialiteId;

///Getterrs et setters
    public Integer getEmployeId() { return this.employeId; }
    public Integer getSpecialiteid() { return this.specialiteId; }
    public void setEmployeId( Integer employeId ) { this.employeId = employeId; }
    public void setSpecialiteId( Integer specialiteId ) { this.specialiteId = specialiteId; }
    public void setSpecialiteId( String specialiteId ) { this.specialiteId = Integer.valueOf(specialiteId); }

///Constructors
    public EmployeSpecialite() {}
    public EmployeSpecialite( Integer employeId, Integer specialiteId ) {
        setEmployeId(employeId);
        setSpecialiteId(specialiteId);
    }
    public EmployeSpecialite( String specialiteId ) {
        setSpecialiteId(specialiteId);
    }

///Fonctions de la classe
public EmployeSpecialite[]  createEmpSpecialite(String[] allSp){
    EmployeSpecialite[] response = new EmployeSpecialite[allSp.length];
    for (int i = 0 ; i < response.length ; i++){
        response[i] = new EmployeSpecialite(allSp[i]);
    }
    return response ;
}

    void createAll(EmployeSpecialite[] liste, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}