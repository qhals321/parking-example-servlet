package member;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    String id = "root";
    String pw = "dbsqhals123!@#";
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/parkingcar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;


    @Test
    public void test(){
        List<MemberBean> memberBeans = selectAllMember();
        for(MemberBean member : memberBeans){
            System.out.println(member);
        }
    }


    private void getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,id,pw);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public List<MemberBean> selectAllMember(){
        List<MemberBean> list = new ArrayList<>();
        getConnection();
        try {
            stmt= con.createStatement();
            String sql = "select * from member";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                MemberBean member = new MemberBean();
                member.setCar_number(rs.getString(1));
                member.setStart_date(rs.getString(2));
                member.setEnd_date(rs.getString(3));
                member.setOwner_name(rs.getString(4));
                list.add(member);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
