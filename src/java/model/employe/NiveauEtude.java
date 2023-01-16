package model.employe;

import model.Model;
import framework.database.annotation.Champs;
import framework.database.annotation.Table;

@Table(nomtable="niveau_etude")
public class NiveauEtude extends Model{
    @Champs
    String nom;

///Getters et setters
    public String getNom() { return this.nom; }
    
    public void setNom( String nom ) { this.nom = nom; }

///Constructors
    public NiveauEtude() {}
    public NiveauEtude( String nom ) {
        setNom(nom);
    }

///Fonctions de la classe

}
