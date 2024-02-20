package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        var param = req.getParameter("name");
        var name = param == null ? "Guest" : param;
        var message = String.format("Hello, %s!", name);
        req.setAttribute("message", message);
        req.getRequestDispatcher("WEB-INF/hello.jsp").forward(req, resp);
    }
}
