package member;

import org.junit.Test;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public MemberBean selectOneMember(String car_number){
        getConnection();
        MemberBean member = new MemberBean();
        try {
            String sql = "select * from member where car_number=?";
            pstmt= con.prepareStatement(sql);
            pstmt.setString(1, car_number);
            rs = pstmt.executeQuery();
            if(rs.next()){
                member.setCar_number(rs.getString(1));
                member.setStart_date(rs.getString(2));
                member.setEnd_date(rs.getString(3));
                member.setOwner_name(rs.getString(4));
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }


    public int insertMember(String car_number, String start_date, String end_date, String owner_name){
        //이미 회원일 때는 2를 반환
        if(isMember(car_number)){
            return 2;
        }else{
            getConnection();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate startD = LocalDate.parse(start_date, formatter);
                LocalDate endD = LocalDate.parse(end_date, formatter);
                String sql = "insert member(car_number,start_date,end_date,owner_name) values(?,?,?,?)";
                pstmt=con.prepareStatement(sql);
                pstmt.setString(1, car_number);
                pstmt.setObject(2, startD);
                pstmt.setObject(3, endD);
                pstmt.setObject(4, owner_name);
                pstmt.executeUpdate();
                rs.close();
                pstmt.close();
                con.close();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            //요청 성공 시
            return 1;
        }


    }

    public boolean isMember(String car_number){
        MemberBean member = selectOneMember(car_number);
        if(member==null || member.getCar_number()==null){
            return false;
        }

        return true;
    }
}
