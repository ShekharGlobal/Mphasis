package com.example.el;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegistrationServletEL")
public class RegistrationServletEL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;

    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("count", 1);
       
		HttpSession session = request.getSession();
        session.setAttribute("count", 2);
        
        context.setAttribute("count", 3);

        User userBean = new User();
        
        userBean.setfName(request.getParameter("fnames"));
        userBean.setlName(request.getParameter("lname"));
        userBean.setGender(request.getParameter("gender"));

        request.setAttribute("userBean", userBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/EL/successel.jsp");
        dispatcher.forward(request, response);
	}

}
