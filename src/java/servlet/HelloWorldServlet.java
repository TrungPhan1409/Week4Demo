/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Person;

/**
 *
 * @author darkn
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/HelloWorldForm.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        
              
        if(firstname ==null | firstname.equals("") || lastname == null | lastname.equals("")){
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("invalid",true);
        
        getServletContext().getRequestDispatcher("/WEB-INF/HelloWorldForm.jsp")
                .forward(request, response);
    }   
        Person person =new Person (firstname, lastname);
        request.setAttribute("person", person);
        
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);
    }

}
