package framework.logger;

import org.apache.log4j.Logger;

public class Log {
    public static Logger logger = Logger.getLogger("Logger");

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(String format, Object... args) {
        logger.info(String.format(format, args));
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void debug(String format, Object... args) {
        logger.debug(String.format(format, args));
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String format, Object... args) {
        logger.error(String.format(format, args));
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void warn(String format, Object... args) {
        logger.warn(String.format(format, args));
    }
}