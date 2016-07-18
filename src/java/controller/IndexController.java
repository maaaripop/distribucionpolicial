/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import constantes.DistribucionPolicial;
import dao.DelitoDAO;
import dao.TipodelitoDAO;
import dao.TurnoDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Delito;
import model.Tipodelito;
import model.Turno;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Mariella
 */
public class IndexController implements Controller {
    

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv= new ModelAndView("index");
        List<Tipodelito> lstTipoDelitos= TipodelitoDAO.getAll();
        mv.addObject("tipoDelitos",lstTipoDelitos);
        List<Turno> lstTurnos= TurnoDAO.getAll();
        mv.addObject("turnos",lstTurnos);
        List<Delito> lstDelitos= DelitoDAO.getAll();
        mv.addObject("delitos",lstDelitos);
        
        
        
        return mv;
    }
}
