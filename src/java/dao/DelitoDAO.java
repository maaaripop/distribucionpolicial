/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import constantes.DistribucionPolicial;
import java.util.ArrayList;
import model.Delito;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Mariella
 */
public class DelitoDAO {
    public static ArrayList<Delito> getAll(){
       
        ArrayList<Delito> lst=null;
        if (DistribucionPolicial.sesion ==null || !DistribucionPolicial.sesion.isOpen()) {
            DistribucionPolicial.sesion = DistribucionPolicial.sesFact.openSession();
        }
        
        try{
            
            String hql = "from Delito";
            Query q= DistribucionPolicial.sesion.createQuery(hql);
            lst=(ArrayList<Delito>)q.list();
            
            for (Delito del : lst) {
                Hibernate.initialize(del.getTurno());
                Hibernate.initialize(del.getTipodelito());
            }
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
    
    public static void addDelito(Delito del){
    
        if (DistribucionPolicial.sesion ==null || !DistribucionPolicial.sesion.isOpen()) {
            DistribucionPolicial.sesion = DistribucionPolicial.sesFact.openSession();
        }
        try{
            DistribucionPolicial.sesion.persist(del);
        }catch(Exception e){
        
        }
        finally{
            if (DistribucionPolicial.sesion !=null && DistribucionPolicial.sesion.isOpen()){
                DistribucionPolicial.sesion.close();
            }
        }
    
    }
}
