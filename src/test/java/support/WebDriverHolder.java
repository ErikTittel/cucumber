package support;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WebDriverHolder {

    private MyWebDriver myWebDriver;

    public MyWebDriver getMyWebDriver() {
        if (myWebDriver == null) {
            myWebDriver = new MyWebDriver();
        }
        return myWebDriver;
    }
}
