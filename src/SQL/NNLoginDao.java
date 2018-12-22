package SQL;

import bean.NNLogin;
import bean.NNMessage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static SQL.JDBCUtil.close;

public class NNLoginDao {
    Connection con = JDBCUtil.getConnection();
    Statement stmt=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private static NNLoginDao instance = null;

    public static NNLoginDao getInstance() {
        //双重校验锁
        if (instance == null) {
            synchronized (NNLoginDao.class) {
                if (instance == null) {
                    instance = new NNLoginDao();
                }
            }
        }
        return instance;
    }
    //建表
    public void createTable() throws SQLException {
        stmt = con.createStatement();
        stmt.executeUpdate("create table if not exists NNlogins(" +
                "name varchar(30),password varchar(30),pid int)");
        stmt.executeUpdate("create table if not exists NNmessages(id int,pid int,name varchar(30)," +
                "time varchar(30),title varchar(30),message varchar(30))");
    }
    //验证用户名是否存在
    public boolean checkUser(String name) {
        try {
            createTable();
            pstmt = con.prepareStatement("select * from NNlogins where name=? ");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;//已被注册(用户名存在)返回true
            }
            return false;//未注册(用户名不存在)返回true
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return true;
        }
    }
    //向数据库添加用户信息
    public void insertUser(String name, String password) {
        try {
            createTable();
            pstmt = con.prepareStatement("insert into NNlogins(name,password,pid) values" +
                    " (?,?,(select uid from(select max(pid)+1 as uid from NNlogins)t))");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            close(rs, pstmt, con);
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
        }
    }
    //验证用户名密码
    public NNLogin checkLogin(String name, String password) {
        try {
            createTable();
            pstmt = con.prepareStatement("select * from NNlogins where name=? " + " and password=?");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                NNLogin NNlogin = new NNLogin();
                NNlogin.setName(rs.getString(1));
                NNlogin.setPassword(rs.getString(2));
                NNlogin.setPid(rs.getInt(3));
                close(rs, pstmt, con);
                return NNlogin;
            }
            close(rs, pstmt, con);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return null;
        }
    }
    //向数据库添加留言板信息
    public boolean addInfo(NNMessage NNMessage) {
        try {
            createTable();
            pstmt = con.prepareStatement("insert into NNmessages(id,pid,name,time,title,message) " +
                    "values((select mid from(select max(id)+1 as mid from NNmessages)t),?,?,?,?,?)");
            pstmt.setInt(1, NNMessage.getPid());
            pstmt.setString(2, NNMessage.getName());
            pstmt.setDate(3, NNMessage.getTime());
            pstmt.setString(4, NNMessage.getTitle());
            pstmt.setString(5, NNMessage.getMessage());
            pstmt.executeUpdate();
            close(rs, pstmt, con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return false;
        }
    }
    //查出父节点为pid的留言的集合
    public List<NNMessage> findMessagesByPid(int pid) {
        try {
            List<NNMessage> list = new ArrayList<NNMessage>();
            pstmt = con.prepareStatement("select * from NNmessages WHERE pid = ?");
            pstmt.setInt(1, pid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                NNMessage NNms = new NNMessage();
                NNms.setId(rs.getInt("id"));
                NNms.setPid(rs.getInt("pid"));
                NNms.setName(rs.getString("name"));
                NNms.setTime(rs.getDate("time"));
                NNms.setTitle(rs.getString("title"));
                NNms.setMessage(rs.getString("message"));
                list.add(NNms);
            }
            close(rs, pstmt, con);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return null;
        }
    }
}
