package servlets;

import SQL.NNLoginDao;
import bean.NNLogin;
import bean.NNMessage;
import service.NNMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/NNLeaveMessage")
public class NNLeaveMessageServlet extends HttpServlet {
    private static final String ERROR="{\"status\":\"10001\",\"data\":\"fail!!\"}";
    private static final String OK="{\"status\":\"10000\",\"data\":\"success!!\"}";
    NNMessageService NNMessageService;
    @Override
    public void init() {
        NNMessageService = NNMessageService.getInstance();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        //需要登录后才能传post
        //post只传title,message
        //title,message都可以为空
        String title=req.getParameter("title");
        String message=req.getParameter("message");
        NNLogin NNLeaveMessageBoard=(NNLogin) req.getSession().getAttribute("login");
        // 从session中取出当前用户对象
        NNMessage NNMessage = new NNMessage(NNLeaveMessageBoard.getName(), title,message, NNLeaveMessageBoard.getPid());
        String res = ERROR;
        // 判断是否插入成功
        if(new NNLoginDao().addInfo(NNMessage)){
            res = OK;
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
