package com.lesu.servlet.pageServlet;

import com.lesu.bean.User;
import com.lesu.service.UserService;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/myfavor")
public class MyFavorPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource dataSource = (DataSource) this.getServletContext().getAttribute("dataSource");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            UserService userService = new UserService(connection, request);
            User user = userService.tryAutoLogin();

            if (user == null) {
                request.getRequestDispatcher("login").forward(request, response);
                return;
            }



            request.setAttribute("user", user);
            request.getRequestDispatcher("myfavorjsp").forward(request, response);

        } catch (Exception ignored) {
        }finally {
            DbUtils.closeQuietly(connection);
        }

    }
}
