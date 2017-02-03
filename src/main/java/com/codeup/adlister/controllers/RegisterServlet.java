package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // TODO: ensure the submitted information is valid
        boolean validAttempt = false;

        if (validAttempt) {
            request.getSession().setAttribute("user", username);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("email", email);
            response.sendRedirect("/profile");
        } else {
        response.sendRedirect("/register");
    }
        // TODO: create a new user based off of the submitted information

        // TODO: if a user was successfully created, send them to their profile
    }
}
