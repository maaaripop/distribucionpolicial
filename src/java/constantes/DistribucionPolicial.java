/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constantes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Mariella
 */
public class DistribucionPolicial {
    public final static SessionFactory sesFact = HibernateUtil.getSessionFactory();
    public static Session sesion=null;
}
