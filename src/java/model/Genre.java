package model;

import framework.database.annotation.Champs;

public class Genre extends Model {
    @Champs
    String nom;

///Getters et setters
    public String getNom() { return this.nom; }
    public void setNom( String nom ) { this.nom = nom; }

///Constructors
    public Genre() {}
    public Genre( String nom ) {
        setNom(nom);
    }

///Fonctions de la classe
}