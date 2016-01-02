package nicebank;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WithdrawalServlet extends HttpServlet {

    @Inject
    private CashSlot cashSlot;
    @Inject
    private Account account;
    @Inject
    private AutomatedTeller teller;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int amount = Integer.parseInt(req.getParameter("amount"));
        teller.withdrawFrom(account, amount);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(
                "<html><head><title>Nice Bank ATM</title></head>" +
                "<body>Please take your $" + amount + "</body></html>"
        );
    }
}
