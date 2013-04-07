package edu.buet.cse.hibernate.lesson13.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import edu.buet.cse.hibernate.lesson13.dao.UserDao;
import edu.buet.cse.hibernate.lesson13.model.User;

public class UserInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
  throws ServletException, IOException {
    response.setContentType("text/plain");
    PrintWriter out = response.getWriter();
    
    String idStr = request.getParameter("id");
    User user = null;
    
    if (StringUtils.isNumeric(idStr)) {
      Long id = Long.valueOf(idStr);
      UserDao userDao = (UserDao) getServletContext().getAttribute("userDao");
      user = userDao.getUser(id);
    }
    
    out.print(user);
    out.close();
  }
}
