package model.employe;

import framework.database.utilitaire.*;
import framework.database.annotation.Champs;
import framework.database.annotation.Table;

import java.sql.Connection;
@Table(nomtable="employe_specialite")
public class EmployeSpecialite extends ObjectBdd {
    @Champs(name="employe_id")
    private Integer employeId;
    @Champs(name="specialite_id")
    private Integer specialiteId;

///Getterrs et setters
    public Integer getEmployeId() { return this.employeId; }
    public Integer getSpecialiteId() { return this.specialiteId; }
    public void setEmployeId( Integer employeId ) { this.employeId = employeId; }
    public void setSpecialiteId( Integer specialiteId ) { this.specialiteId = specialiteId; }
    
    

///Constructors
    public EmployeSpecialite() {}
    public EmployeSpecialite( Integer employeId, Integer specialiteId ) {
        setEmployeId(employeId);
        setSpecialiteId(specialiteId);
    }
    

///Fonctions de la classe
public EmployeSpecialite[]  createEmpSpecialite(String[] allSp){
    EmployeSpecialite[] response = new EmployeSpecialite[allSp.length];
    for (int i = 0 ; i < response.length ; i++){
        response[i] = new EmployeSpecialite();
        response[i].setSpecialiteId(Integer.valueOf(allSp[i]));
    }
    return response ;
}

}