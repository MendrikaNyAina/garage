/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import model.employe.Specialite;

/**
 *
 * @author randr
 */
public class Test {
    public static void main(String[]args)throws Exception{
        Specialite spec=new Specialite();
        ArrayList<Specialite>liste=spec.findAll(null);;
        for(Specialite s:liste){
            System.out.println(s.getNom());
        }
    }
}
