package parking;


import member.MemberDao;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDao {

    String id = "root";
    String pw = "dbsqhals123!@#";
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/parkingcar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;


    @Test
    public void run(){
        List<CarBean> carLog =  seeLogs();
        for(CarBean carBean : carLog){
            System.out.println(carBean);
        }
    }

    private void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, pw);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void inCar(String car_number) {
        getConnection();
        MemberDao memberDao = new MemberDao();
        boolean isMember = memberDao.isMember(car_number);
        int paid = 0;
        if (isMember) {
            paid = 2;
        }
        try {
            String sql = "insert parking_log(in_time,paid,car_number) values(now(),?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, paid);
            pstmt.setString(2, car_number);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<CarBean> seeLogs() {
        List<CarBean> logs = new ArrayList<>();
        getConnection();
        try {
            stmt = con.createStatement();
            String sql = "select * from parking_log where out_time is not null";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CarBean car = new CarBean();
                car.setParking_log_id(rs.getInt(1));
                car.setIn_time(rs.getString(2));
                car.setOut_time(rs.getString(3));
                car.setPaid(rs.getInt(4));
                car.setCar_number(rs.getString(5));
                logs.add(car);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return logs;
    }

    public int outCar(String car_number) {
        getConnection();
        int result = 0;
        try {
            String sql = "update parking_log set out_time=now() where car_number=? and out_time is null";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, car_number);
            result = pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public CarBean selectOneCar(String car_number){
        getConnection();
        CarBean carBean = new CarBean();
        try {
            String sql = "select * from parking_log where car_number=?";
            pstmt= con.prepareStatement(sql);
            pstmt.setString(1,car_number);
            rs = pstmt.executeQuery();
            if(rs.next()){
                carBean.setParking_log_id(rs.getInt(1));
                carBean.setIn_time(rs.getString(2));
                carBean.setOut_time(rs.getString(3));
                carBean.setPaid(rs.getInt(4));
                carBean.setCar_number(rs.getString(5));
            }
            rs.close();
            pstmt.close();
            con.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carBean;
    }

    public boolean isPaid(String car_number) {
        getConnection();
        int paid=0;
        try {
            String sql = "select paid from parking_log where car_number=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, car_number);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                paid=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return paid == 0 ? false : true;
    }

    public boolean isParked(String car_number){
        getConnection();
        String car_num="";
        try {
            String sql = "select * from parking_log where car_number=? and paid=0";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,car_number);
            rs=pstmt.executeQuery();
            if(rs.next()){
                car_num = rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return car_num==null?false : true;
    }

    public int payed(String car_number) {
        getConnection();
        int result = 0;
        try {
            String sql = "update parking_log set paid=1 where car_number=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, car_number);
            result = pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
