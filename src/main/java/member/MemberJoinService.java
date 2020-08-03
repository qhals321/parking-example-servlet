package member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/member_join.do")
public class MemberJoinService extends HttpServlet {
    private final String admin_pw="1234";
    MemberDao dao = new MemberDao();
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
        String car_number = req.getParameter("car_number");
        String start_date = req.getParameter("start_date");
        String end_date = req.getParameter("end_date");
        String owner_name = req.getParameter("owner_name");

        if(car_number==null || car_number.length()==0|| start_date == null ||start_date.length()==0|| end_date==null || end_date.length()==0
            || owner_name==null || owner_name.length()==0){
            out.println("<script>alert('정보들을 입력해주세요'); history.go(-1);</script>");
            out.flush();}
        else if(!req.getParameter("admin_pw").equals(admin_pw)){
            out.println("<script>alert('관리자 비밀번호가 일치하지 않습니다.'); history.go(-1);</script>");
            out.flush();
        }else{
            int member = dao.insertMember(car_number, start_date, end_date, owner_name);
            if(member==2){
                out.println("<script>alert('이미 등록되어있는 회원입니다.'); history.go(-1);");
            }else{

                out.println("<script>alert('등록이 완료되었습니다.'); location.href='../admin/adminHome.jsp'</script>");
            }
        }

    }
}
