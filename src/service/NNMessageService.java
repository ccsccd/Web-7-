package service;

import SQL.NNLoginDao;
import bean.NNMessage;

import java.util.List;

//这部分令人头疼,改的demo代码
public class NNMessageService {
    private static NNMessageService instance = null;
    private NNLoginDao messageBoardDao = null;

    public NNMessageService() {
        messageBoardDao = NNLoginDao.getInstance();
    }
    public static NNMessageService getInstance() {
        //双重校验锁
        if (instance == null) {
            synchronized (NNMessageService.class) {
                if (instance == null) {
                    instance = new NNMessageService();
                }
            }
        }
        return instance;
    }
    private List<NNMessage> findContentChild(NNMessage content) {
        //找该条评论的子节点 即pid为该条评论id的评论
        List<NNMessage> list = messageBoardDao.findMessagesByPid(content.getId());
        //遍历它的子节点 然后递归找每条评论下的评论 即节点的子节点
        for (NNMessage message : list) {
            //递归找这条评论的节点 然后赋值
            List<NNMessage> childList = findContentChild(message);
            message.setChildContent(childList);
        }
        return list;
    }
    public List<NNMessage> findAllMessages() {
        //先找到pid为0的所有留言 即留言板上所有无父节点的留言
        List<NNMessage> list = messageBoardDao.findMessagesByPid(0);
        //然后找每条留言的评论并赋值
        for (NNMessage message : list) {
            List<NNMessage> childList = findContentChild(message);
            message.setChildContent(childList);
        }
        return list;
    }
    public String messagesToJson(List<NNMessage> messageList) {
        //组装json
        StringBuffer sb = new StringBuffer();
        //前面的共同的部分
        sb.append("{\"status\":10000,\"data\":[");
        //如果它有子节点
        if (messageList != null && messageList.size() != 0) {
            //这里的思想和上面的思想一样 深度优先遍历(DFS) 组装出来评论的json
            for (NNMessage content : messageList) {
                sb.append(createJson(content));
                sb.append(",");
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        sb.append("]}");
        return sb.toString();
    }
    private String createJson(NNMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"id\":").append(message.getId())
                .append(",\"pid\":\"").append(message.getPid())
                .append(",\"name\":\"").append(message.getName())
                .append(",\"time\":\"").append(message.getTime())
                .append(",\"title\":\"").append(message.getTitle())
                .append("\",\"message\":\"").append(message.getMessage())
                .append("\"").append(",\"child\":[");
        List<NNMessage> child = message.getChildContent();
        for (NNMessage content : child) {
            String json = createJson(content);
            sb.append(json).append(",");
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("]}");
        return sb.toString();
    }
}
