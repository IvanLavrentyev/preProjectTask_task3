package controller;


import model.User;

import userService.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static userDao.UserDaoFactory.typeOfConnection;

@WebServlet(urlPatterns = "/allUsers")
public class ShowAllUsersServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List <User> userList = userService.getAllUsers();

        req.setAttribute("users", userList);
        req.setAttribute("typeOfConnection", typeOfConnection);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("allUsers.jsp");
        requestDispatcher.forward(req,resp);
    }
}
