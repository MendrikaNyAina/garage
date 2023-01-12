package model;

import framework.database.utilitaire.*;

public class Model extends ObjectBdd {
    Integer id;

///Getters et setters
    public Integer getId() { return this.id; }
    public void setId( Integer id ) { this.id = id; }

///Constructors
    public Model () {}
    public Model( Integer id ) {
        setId(id);
    }

///Fonction de la classe
}