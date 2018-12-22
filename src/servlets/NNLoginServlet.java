package servlets;

import SQL.NNLoginDao;
import bean.NNLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/NNLogin")
public class NNLoginServlet extends HttpServlet {
    private static final String ERROR2 = "{\"status\":\"10002\",\"data\":\"fail,this name doesn't exist!!\"}";
    private static final String ERROR1 = "{\"status\":\"10001\",\"data\":\"fail,this password is wrong!!\"}";
    private static final String OK = "{\"status\":\"10000\",\"data\":\"success!!\"}";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String res = ERROR1;
        NNLoginDao NNLoginDao = new NNLoginDao();
        HttpSession session = req.getSession();
        NNLogin l = (NNLogin) session.getAttribute("login");
        if (!NNLoginDao.checkUser(name)) {//验证该用户名是否存在
            res = ERROR2;
        } else {
            if (l == null)
                l = NNLoginDao.checkLogin(name, password);//验证密码是否正确
            if (l != null) {
                session.setAttribute("login", l);
                res = OK;
            }
        }
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        resp.getOutputStream()
                )
        );
        writer.write(res);
        writer.flush();
        writer.close();
    }

}
