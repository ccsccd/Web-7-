package servlets;

import SQL.NNLoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/NNRegister")
public class NNRegisterServlet extends HttpServlet {
    private static final String ERROR="{\"status\":\"10001\",\"data\":\"fail, this name has existed!!\"}";
    private static final String OK="{\"status\":\"10000\",\"data\":\"success!!\"}";
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String res = null;
        NNLoginDao NNLoginDao=new NNLoginDao();
        if(NNLoginDao.checkUser(name)) {//验证该用户名是否已被注册
            res = ERROR;
        }else{//向数据库插入用户信息
            NNLoginDao.insertUser(name,password);
            res = OK;
        }
        BufferedWriter writer = new BufferedWriter(//返回json数据
                new OutputStreamWriter(
                        resp.getOutputStream()
                )
        );
        writer.write(res);
        writer.flush();
        writer.close();
    }
}
