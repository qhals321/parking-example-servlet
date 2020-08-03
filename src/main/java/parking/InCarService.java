package parking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parking/parking_in.do")
public class InCarService extends HttpServlet {
        @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                proDo(req, resp);
            }

            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                proDo(req, resp);
            }

            protected void proDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html; charset=UTF-8");
                req.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                String car_number=req.getParameter("car_number");
                ParkingDao parkingDao = new ParkingDao();
                parkingDao.inCar(car_number);
                out.println("<script>alert('\""+car_number+"\" 차량 입차처리가 되었습니다.'); location.href='in-out.jsp'</script>");
            }
}
