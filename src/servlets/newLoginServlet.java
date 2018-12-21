package servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import SQL.LoginDao;
import bean.Login;

    public class newLoginServlet extends HttpServlet{
        public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("UTF-8");
            LoginDao loginDao= new LoginDao();
            HttpSession session=req.getSession();
            Login l=(Login) session.getAttribute("login");
            if(l==null)
                l = loginDao.checkLogin(req.getParameter("name"),req.getParameter("password"));
            if(l!=null){
                session.setAttribute("login",l);           //将获取的对象保存在session中
                ArrayList al=loginDao.findMbInfo();           //获取留言板的内容，返回一个数组
                session.setAttribute("al", al);            //把数组保存起来
                resp.sendRedirect("messageBoard.jsp");
            }
            else{
                resp.sendRedirect("error.html");
            }
        }
        public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
            doGet(req,resp);
        }
    }
