package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hi extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        resp.setContentType("text/html; charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        out.println("这是doGet第一次发送的信息");
        out.close();
    }
}
