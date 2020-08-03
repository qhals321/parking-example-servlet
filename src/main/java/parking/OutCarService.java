package parking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parking/parking_out.do")
public class OutCarService extends HttpServlet {
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
        String car_number = req.getParameter("car_number");
        ParkingDao parkingDao = new ParkingDao();

        boolean isPaid=parkingDao.isPaid(car_number);
        if(!isPaid){
            out.println("<script>alert('정산되지 않은 차량입니다'); history.go(-1);</script>");
            out.flush();
        }else{
            int result = parkingDao.outCar(car_number);
            if(result==0){
                out.println("<script>alert('없는 차량입니다, 다시 입력해주세요'); history.go(-1);");
            }else{
                out.println("<script>alert('출차 처리가 완료되었습니다'); location.href='in-out.jsp';");

            }
            out.flush();
        }
    }
}

