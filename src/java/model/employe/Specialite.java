package model.employe;

import model.*;
import framework.database.annotation.*;

@Table( nomtable="Specialite")
public class Specialite extends Model {
    @Champs
    String nom;

///getters et setters
    public String getNom() { return this.nom; }
    public void setNom( String nom) { this.nom = nom; }
    
///Constructors
    public Specialite() {}
    public Specialite( String nom ) {
        setNom(nom);
    }

///Fonctions de classe
}