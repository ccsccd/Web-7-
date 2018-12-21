package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WeclomeYou extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        resp.setContentType("text/html; charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        String user=req.getParameter("user");
        String welcomeInfo="Welcome you,"+user;
        PrintWriter out=resp.getWriter();
        out.println("<html>" +
                "<head><title>");
        out.println("Welcome Pages");
        out.println("</title>" +
                "</head>");
        out.println("<body>");
        out.println(welcomeInfo);
        out.println("<p>");
        out.println("这是doGet第二次发送的信息");
        out.println("</p>");
        out.println("</body>" +
                "</html>");
        out.close();
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        doGet(req,resp);
    }
}
