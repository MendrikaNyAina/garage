/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import framework.database.annotation.Champs;
import framework.database.utilitaire.*;
import java.sql.*; 
import model.Model;

/**
 *
 * @author Chalman
 */
public class Service extends Model{
    @Champs ( mapcol="id", name="type_service_id")
    private TypeService typeService;
    @Champs
    private Date date_service;
    @Champs
    private Date nom_client;

    public Service(int idService, String nomClient, Date dateService) {
        this.typeService=new TypeService(idService);
        setNom_client(nom_client);
        setDate_service(dateService);
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public Date getDate_service() {
        return date_service;
    }

    public void setDate_service(Date date_service) {
        this.date_service = date_service;
    }

    public Date getNom_client() {
        return nom_client;
    }

    public void setNom_client(Date nom_client) {
        this.nom_client = nom_client;
    }

        
    public Service() {
    }

    public Service(Integer id, TypeService typeService, Date date_service, Date nom_client) {
        setId(id);
        this.typeService = typeService;
        this.date_service = date_service;
        this.nom_client = nom_client;
    }
    public Service( TypeService typeService, Date date_service, Date nom_client) {
        this.typeService = typeService;
        this.date_service = date_service;
        this.nom_client = nom_client;
    }
    public void create (Connection con) throws Exception{
    boolean b = true ;
        try{
                if (con==null){
                    con = GConnection.getSimpleConnection();
                    b = false ;
                }
                con.setAutoCommit(false);
                Service service = new Service();
                int serviceId = this.sequence("service_id_seq",con);
                this.setId(serviceId);
                super.create(con);
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
