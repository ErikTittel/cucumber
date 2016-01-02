package nicebank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class AtmServer {

    public static final int PORT = 8887;

    private Server server;
    @Inject
    private AtmServlet atmServlet;
    @Inject
    private WithdrawalServlet withdrawalServlet;

    @PostConstruct
    public void init() {
        server = new Server(PORT);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(atmServlet), "/*");
        context.addServlet(new ServletHolder(withdrawalServlet), "/withdraw");
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
        System.out.println("Server shutdown");
    }

//    public static void main(String[] args) throws Exception {
//        new AtmServer(9988).start();
//    }
}
