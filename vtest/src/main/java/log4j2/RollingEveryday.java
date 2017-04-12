package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by msg on 2017/4/12.
 */
public class RollingEveryday {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("log4j.configurationFile", "log4j2-Rolling.xml");
        Logger logger = LogManager.getLogger(RollingEveryday.class);
        while (true) {
            logger.info("ddddddd");
            Thread.sleep(1000);
        }
    }
}
