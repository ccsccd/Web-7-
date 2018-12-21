package servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SQL.LoginDao;
import bean.Login;

public class newLeaveMessageServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        String title=req.getParameter("title");
        String message=req.getParameter("message");
        // 从session中取出当前用户对象
        Login leaveMessageBoard=(Login) req.getSession().getAttribute("login");
        // 建立留言表对应JavaBean对象，把数据封装进去
        bean.message ms=new bean.message();
        ms.setId(leaveMessageBoard.getId());
        ms.setName(leaveMessageBoard.getName());
        ms.setTime(new Date(System.currentTimeMillis()));
        ms.setTitle(title);
        ms.setMessage(message);
        // 判断是否插入成功
        if(new LoginDao().addInfo(ms)){
            resp.sendRedirect("success.html") ;
        }
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        doGet(req,resp);
    }
}