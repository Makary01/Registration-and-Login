package web.servlets;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameOrEmail = request.getParameter("nameOrEmail");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User verifiedUser = userDao.verifyUser(nameOrEmail,password);
        if(verifiedUser!=null){
            request.getSession().setAttribute("userId",verifiedUser.getId());
            response.sendRedirect("/user/panel");
        }else {
            response.sendRedirect("/home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
