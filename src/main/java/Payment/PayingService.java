package Payment;

import parking.ParkingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/paying.do")
public class PayingService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       proDo(req, resp);
    }

    protected void proDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ParkingDao parkingDao = new ParkingDao();
        int money = Integer.parseInt(req.getParameter("money"));
        int price = Integer.parseInt(req.getParameter("price"));
        String car_number = req.getParameter("car_number");
        int change = money-price;
        if(change<0){
            out.println("<script> alert('투입 금액이 부족합니다.'); history.go(-1); </script>");
            out.flush();
        }else if(change==0){
            parkingDao.payed(car_number);
            out.println("<script> alert('정산이 완료되었습니다.'); location.href='/index.jsp';</script>");
        }else{
            parkingDao.payed(car_number);
            out.println("<script> alert('거스름 돈은 "+change+"원 입니다.'); location.href='/index.jsp';</script>");
        }
    }
}
