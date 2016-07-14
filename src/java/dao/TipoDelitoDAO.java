/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import model.Tipodelito;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Mariella
 */
public class TipoDelitoDAO {
    public static ArrayList<Tipodelito> getAll(){
        Session session=null;
        ArrayList<Tipodelito> lst=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql = "from Tipodelito";
            Query q= session.createQuery(hql);
            lst=(ArrayList<Tipodelito>)q.list();
            session.close();         
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return lst;
    }
}
