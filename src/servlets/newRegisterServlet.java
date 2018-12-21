package servlets;

import java.io.IOException;

import SQL.LoginDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newRegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email=req.getParameter("email");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        if(new LoginDao().insertUser(email ,name, password)) {
            resp.sendRedirect("login.html");
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}