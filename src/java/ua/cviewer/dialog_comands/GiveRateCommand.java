/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.cviewer.dialog_comands;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.cviewer.dao.ClientDAO;
import ua.cviewer.dao.DAOFactory;

/**
 *
 * @author User
 */
public class GiveRateCommand implements Command{
    final String ID ="id";
    final String PASS ="pass";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ClientDAO cdao = DAOFactory.getClientDAO();
        int id = new Integer(request.getParameter(ID));
        long pass = new Long(request.getParameter(PASS));
        int rate = cdao.getRate(id, pass);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println(rate);       
        } catch (IOException ex) {
            Logger.getLogger(GiveRateCommand.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
    
}
