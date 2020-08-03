package admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/login.do")
public class AdminLoginService extends HttpServlet {
    private final String admin_id = "host";
    private final String admin_pw = "1234";

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
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("admin_id");
        String pw = req.getParameter("admin_pw");
        if(id==null || id.length()==0 || pw ==null || pw.length()==0){
            out.println("<script>alert('아이디와 비밀번호를 입력해주세요'); history.go(-1);</script>");
            out.flush();
        }else if(!admin_id.equals(id) || !admin_pw.equals(pw)){
            out.println("<script>alert('아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script>");
            out.flush();
        }else{
            out.println("<script>alert('로그인이 완료되었습니다.'); location.href='adminHome.jsp';</script>");
            out.flush();
        }
    }
}
