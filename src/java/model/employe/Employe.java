package model.employe;

import framework.database.annotation.Champs;
import model.*;
import java.sql.*;
import util.*;
import java.sql.Date;
import framework.database.utilitaire.GConnection;

public class Employe extends Model {
    @Champs
    private String nom;
    @Champs  
    private String  prenom;
    @Champs(name="date_embauche")
    private Date dateEmbauche;
    @Champs(name="date_naissance")
    private Date dateNaissance;
    @Champs
    private Double salaire;
    @Champs( mapcol="id", name="genre_id")
    private Genre genre;
    @Champs( mapcol="id", name="niveau_etude_id")
    private NiveauEtude niveauetude;

///Getters et setters
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public Date getDateEmbauche() { return this.dateEmbauche; }
    public Date getDateNaissance() { return this.dateNaissance; }
    public Double getSalaire() { return this.salaire; }
    public Genre getGenre() { return this.genre; }
    public NiveauEtude getNiveauetude() { return this.niveauetude; }
    
    public void setNom( String nom ) throws Exception { 
        if ( nom != null ) {
            this.nom = nom;
        }
        else {
            throw new Exception("Case nom vide");
        }
    }

    public void setPrenom( String prenom ) throws Exception { 
        if ( prenom != null ) {
            this.prenom =prenom; 
        }
        else {
            throw new Exception("Case prenom vide");
        }
    }
    public void setDateEmbauche( Date dateEmbauche ) { this.dateEmbauche = dateEmbauche; }
    public void setDateNaissance( Date dateNaissance ) throws Exception { 
        if ( UtilDate.getAge(dateNaissance) >= 18 ) {
            this.dateNaissance = dateNaissance;
        }
        else {
            throw new Exception("Vous etes encore mineure");
        }
    }

    public void setSalaire( Double salaire ) throws Exception {
        if ( salaire > 0 ) {
            this.salaire = salaire;
        }
        else {
            throw new Exception("Entrer une salaire plus grand que 0");
        }
    }
    public void setGenre( Genre genre ) throws Exception { 
        if ( genre != null && genre.getId() != null ) {
            this.genre = genre;
        }
        else {
            throw new Exception("Case genre vide");
        }
    }
    public void setNiveauetude( NiveauEtude niveauetude ) { this.niveauetude = niveauetude; }

///Constructors
    public Employe () {}
    public Employe ( String nom, String prenom, Date dateEmbauche, Date dateNaissance, Genre genre, NiveauEtude niveauetude ) throws Exception {
        try {            
            setNom(nom);
            setPrenom(prenom);
            setDateEmbauche(dateEmbauche);
            setDateNaissance(dateNaissance);
            setGenre(genre);
            setNiveauetude(niveauetude);
        } catch ( Exception e) {
            throw e;
        }
    }
        public Employe ( String nom, String prenom, Date dateEmbauche, Date dateNaissance, Genre genre ) throws Exception {
        try {            
            setNom(nom);
            setPrenom(prenom);
            setDateEmbauche(dateEmbauche);
            setDateNaissance(dateNaissance);
            setGenre(genre);
        } catch ( Exception e) {
            throw e;
        }
    }

///Fonctions de la classe
    public void create (Connection con , EmployeSpecialite[] liste) throws Exception{
        boolean b = true ;
        try{
                if (con==null){
                    con = GConnection.getSimpleConnection();
                    b = false;
                }
                con.setAutoCommit(false);
                EmployeSpecialite emp = new EmployeSpecialite();
                int employeId = sequence("employe_id_seq",con);
                this.setId(employeId);
                this.create(con);
                for (int i = 0 ; i < liste.length ; i++){
                    liste[i].setEmployeId(employeId);
                    liste[i].create(con);
                }
                
                con.commit();
        }catch (Exception exe) {
            //System.out.println(exe.getMessage());
            con.rollback();
            throw exe;
        }finally {
            if (con!=null && !b){
                con.close();
            }
        }
    }

}