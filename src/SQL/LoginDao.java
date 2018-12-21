package SQL;

import java.sql.*;
import bean.Login;
import bean.message;
import java.util.ArrayList;
import static SQL.JDBCUtil.close;

public class LoginDao {
    Connection con = JDBCUtil.getConnection();//数据库连接对象
    Statement stmt=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    //建表
    public void createTable() throws SQLException {
        stmt = con.createStatement();
        stmt.executeUpdate("create table if not exists logins(email varchar(30)," +
                "name varchar(30),password varchar(30),id int)");
        stmt.executeUpdate("create table if not exists messages(id int,name varchar(30)," +
                "time varchar(30),title varchar(30),message varchar(30))");
    }

    //验证用户名密码
    public Login checkLogin(String name, String password) {
        try {
            createTable();
            pstmt = con.prepareStatement("select * from logins where name=? " + " and password=?");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Login login = new Login();
                login.setEmail(rs.getString(1));
                login.setName(rs.getString(2));
                login.setPassword(rs.getString(3));
                login.setId(rs.getInt(4));
                close(rs, pstmt, con);
                return login;
            }
            close(rs, pstmt, con);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return null;
        }
    }

    public ArrayList<message> findMbInfo() {
        try {
            createTable();
            ArrayList<message> al = new ArrayList<message>();
            pstmt = con.prepareStatement("select * from messages");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                message ms = new message();
                ms.setId(rs.getInt(1));
                ms.setName(rs.getString(2));
                ms.setTime(rs.getDate(3));
                ms.setTitle(rs.getString(4));
                ms.setMessage(rs.getString(5));
                al.add(ms);
            }
            close(rs, pstmt, con);
            return al;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return null;
        }
    }

    public String getName(int id) {
        String name = null;
        try {
            createTable();
            pstmt = con.prepareStatement("select name from logins where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
            close(rs, pstmt, con);
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return null;
        }
    }

    public boolean addInfo(message ms) {
        try {
            createTable();
            pstmt = con.prepareStatement("insert into messages(id,name,time,title,message) values(?,?,?,?,?)");
            pstmt.setInt(1, ms.getId());
            pstmt.setString(2, ms.getName());
            pstmt.setDate(3, ms.getTime());
            pstmt.setString(4, ms.getTitle());
            pstmt.setString(5, ms.getMessage());
            pstmt.executeUpdate();
            close(rs, pstmt, con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return false;
        }
    }

    public boolean insertUser(String email, String name, String password) {
        try {
            createTable();
            pstmt = con.prepareStatement("insert into logins(email,name,password,id) values" +
                    " (?,?,?,(select uid from(select max(id)+1 as uid from logins)t))");
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            close(rs, pstmt, con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            close(rs, pstmt, con);
            return false;
        }
    }
}