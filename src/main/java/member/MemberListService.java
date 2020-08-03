package member;


import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/member/member_list.do")
public class MemberListService extends HttpServlet {
    MemberDao memberDao = new MemberDao();
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
        List<MemberBean> members =memberDao.selectAllMember();
        req.setAttribute("members", members);
        RequestDispatcher rd = req.getRequestDispatcher("memberList.jsp");
        rd.forward(req,resp);
    }

}
