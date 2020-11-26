package web.servlets;

import dao.UserDao;
import model.User;
import utils.RegexUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if (RegexUtil.validateName(name)
                && RegexUtil.validatePassword(password)
                && RegexUtil.validateEmail(email)
                && password.equals(password2)) {

            User userToCreate = new User();
            userToCreate.setPassword(password);
            userToCreate.setName(name);
            userToCreate.setEmail(email);
            userToCreate.setIsAdmin(false);

            UserDao userDao = new UserDao();
            User createdUser = userDao.createUser(userToCreate);
            if(createdUser!=null){
                request.getSession().setAttribute("userId",createdUser.getId());
                response.sendRedirect("/user/panel");
            }
        }else {
            response.sendRedirect("/home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
