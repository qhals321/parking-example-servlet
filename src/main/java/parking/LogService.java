package parking;


import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/log_service.do")
public class LogService extends HttpServlet {
    ParkingDao parkingDao = new ParkingDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proDo(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proDo(req, resp);
    }

    protected void proDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        List<CarBean> car_log =  parkingDao.seeLogs();
        req.setAttribute("car_log", car_log);
        req.setAttribute("hello", "hiiiiii~!@~!@~!@~!");
        RequestDispatcher rd = req.getRequestDispatcher("/parking/parking_log.jsp");
        rd.forward(req,resp);
    }


    @Test
    public void run(){
        List<CarBean> carLog =  parkingDao.seeLogs();
        for(CarBean carBean : carLog){
            System.out.println(carBean);
        }
    }
}
