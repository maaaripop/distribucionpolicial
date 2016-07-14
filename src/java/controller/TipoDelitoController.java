/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tipodelito;
import dao.TipoDelitoDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Mariella
 */
public class TipoDelitoController implements Controller{
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv= new ModelAndView("index");
        
        try {
            List<Tipodelito> lst= TipoDelitoDAO.getAll();
            mv.addObject("tipoDelitos",lst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    
}
