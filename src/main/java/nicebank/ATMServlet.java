package nicebank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ATMServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(
                "<html><head><title>Nice Bank ATM</title></head>"
                + "<body><h1>Welcome to our nice bank!</h1>" +
                        "<form action=\"/withdraw\" method=\"post\">" +
                        "<label for=\"amount\"Amount</label>" +
                        "<input type=\"text\" id=\"amount\" name=\"amount\">" +
                        "<button type=\"submit\" id=\"withdraw\">Withdraw</button>" +
                        "</form></body></html>"
        );
    }
}
