package model.employe;

import model.Model;

public class NiveauEtude extends Model{
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
