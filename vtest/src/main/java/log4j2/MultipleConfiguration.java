package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by msg on 2017/2/28.
 */
public class MultipleConfiguration {

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j2-A.xml, log4j2-B.xml, log4j2-C.xml, log4j2-D.xml");
        Logger logger = LogManager.getLogger("myAsyncLog");
        long start = System.currentTimeMillis();
        for(int i = 0; i < 50000; i++) {
            logger.trace("trace level");
            logger.debug("debug level");
            logger.info("info level");
            logger.warn("warn level");
            logger.error("error level");
            logger.fatal("fatal level");
        }
        System.out.println(System.currentTimeMillis() - start);
//        try {
//            Thread.sleep(1000 * 61);
//        } catch (InterruptedException e) {}
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }
}
