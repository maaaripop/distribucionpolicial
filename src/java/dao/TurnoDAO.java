/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import constantes.DistribucionPolicial;
import java.util.ArrayList;
import model.Turno;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
/**
 *
 * @author Mariella
 */
public class TurnoDAO {
    public static ArrayList<Turno> getAll(){
        ArrayList<Turno> lst=null;
        if (DistribucionPolicial.sesion ==null || !DistribucionPolicial.sesion.isOpen()) {
            DistribucionPolicial.sesion = DistribucionPolicial.sesFact.openSession();
        }
        try{
            
            String hql = "from Turno";
            Query q= DistribucionPolicial.sesion.createQuery(hql);
            lst=(ArrayList<Turno>)q.list();
            DistribucionPolicial.sesion.close();         
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        finally{
            if (DistribucionPolicial.sesion !=null && DistribucionPolicial.sesion.isOpen()){
                DistribucionPolicial.sesion.close();
            }
        }
        
        return lst;
    }
}
