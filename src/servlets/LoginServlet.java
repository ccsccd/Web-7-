package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        resp.setContentType("text/html; charset = UTF-8");
        String name=req.getParameter("name");
        String pwd=req.getParameter("password");
        if (name!=null&&pwd!=null&&name.equals("zhangsan")&&pwd.equals("1234")){
            resp.sendRedirect("simpleLoginSuccess.html");
        }else{
            resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,"用户名不存在或密码错误!!");
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        doGet(req,resp);
    }
}
