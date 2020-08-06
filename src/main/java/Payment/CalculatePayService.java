package Payment;

import member.MemberBean;
import member.MemberDao;
import org.junit.Test;
import parking.CarBean;
import parking.ParkingDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/payingCalculate.do")
public class CalculatePayService extends HttpServlet {
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
        String car_number = req.getParameter("car_number");

        int price = calculatePrice(car_number);
        if(parkingDao.isPaid(car_number)){
            out.println("<script>alert('이미 정산된 차량입니다.'); history.go(-1);</script>");
        }else if(price<0){
            out.println("<script>alert('없는 차량입니다. 다시 확인해주세요'); history.go(-1);</script>");
            out.flush();
        }else{
            Date date= new Date();
            CarBean carBean=parkingDao.selectOneCar(car_number);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String out_time = format.format(date);
            carBean.setOut_time(out_time);
            req.setAttribute("carBean", carBean);
            req.setAttribute("price", price);

            RequestDispatcher rd = req.getRequestDispatcher("/paying/payment.jsp");
            rd.forward(req,resp);
        }
    }



    private int calculatePrice(String car_number){
        ParkingDao parkingDao = new ParkingDao();
        CarBean carBean = new CarBean();
        int price = 0;


            carBean = parkingDao.selectOneCar(car_number);
            if (carBean.getCar_number()==null) {
                return -1;
            } else {
                String in_time = carBean.getIn_time();
                try { // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서 컴파일을 할 수 없다.
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date FirstDate = format.parse(in_time);
                    Date SecondDate = new Date();

                    int calDate = (int) (SecondDate.getTime() - FirstDate.getTime());

                    //30분
                    int calDateDays = calDate / (60 * 1000 * 30);

                    //30분에 3천
                    price=3000*calDateDays;
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }

        return price;
    }
}
