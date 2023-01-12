package model.employe;

import framework.database.utilitaire.*;

public class EmployeSpecialite extends ObjectBdd {
    Integer employeId, specialiteId;

///Getterrs et setters
    public Integer getEmployeId() { return this.employeId; }
    public Integer getSpecialiteid() { return this.specialiteId; }
    public void setEmployeId( Integer employeId ) { this.employeId = employeId; }
    public void setSpecialiteId( Integer specialiteId ) { this.specialiteId = specialiteId; }

///Constructors
    public EmployeSpecialite() {}
    public EmployeSpecialite( Integer employeId, Integer specialiteId ) {
        setEmployeId(employeId);
        setSpecialiteId(specialiteId);
    }

///Fonctions de la classe

}