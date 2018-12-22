package servlets;

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
import java.util.List;

@WebServlet("/NNShowMessage")
public class NNShowMessageServlet extends HttpServlet {
    NNMessageService NNMessageService;
    @Override
    public void init() {
        NNMessageService = NNMessageService.getInstance();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NNMessage> messageList = NNMessageService.findAllMessages();
        String res = NNMessageService.messagesToJson(messageList);

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

