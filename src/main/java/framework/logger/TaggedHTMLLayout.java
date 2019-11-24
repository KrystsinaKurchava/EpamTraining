package framework.logger;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

public class TaggedHTMLLayout extends HTMLLayout {

    @Override
    public String format(LoggingEvent event) {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append(Layout.LINE_SEP + "<tr>" + Layout.LINE_SEP);
        sbuf.append("<td>");
        sbuf.append(event.timeStamp - LoggingEvent.getStartTime());
        sbuf.append("</td>" + Layout.LINE_SEP);
        String escapedThread = event.getThreadName();
        sbuf.append("<td title=\"" + escapedThread + " thread\">");
        sbuf.append(escapedThread);
        sbuf.append("</td>" + Layout.LINE_SEP);
        sbuf.append("<td title=\"Level\">");
        if (event.getLevel().equals(Level.DEBUG)) {
            sbuf.append("<font color=\"#339933\">");
            sbuf.append(String.valueOf(event.getLevel()));
            sbuf.append("</font>");
        } else if (event.getLevel().isGreaterOrEqual(Level.WARN)) {
            sbuf.append("<font color=\"#993300\"><strong>");
            sbuf.append(String.valueOf(event.getLevel()));
            sbuf.append("</strong></font>");
        } else {
            sbuf.append(String.valueOf(event.getLevel()));
        }
        sbuf.append("</td>" + Layout.LINE_SEP);
        String escapedLogger = event.getLoggerName();
        sbuf.append("<td title=\"" + escapedLogger + " category\">");
        sbuf.append(escapedLogger);
        sbuf.append("</td>" + Layout.LINE_SEP);
        sbuf.append("<td title=\"Message\">");
        sbuf.append(event.getRenderedMessage());
        sbuf.append("</td>" + Layout.LINE_SEP);
        sbuf.append("</tr>" + Layout.LINE_SEP);
        if (event.getNDC() != null) {
            sbuf.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : xx-small;\" colspan=\"6\" title=\"Nested Diagnostic Context\">");
            sbuf.append("NDC: " + event.getNDC());
            sbuf.append("</td></tr>" + Layout.LINE_SEP);
        }
        String[] s = event.getThrowableStrRep();
        if (s != null) {
            sbuf.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : xx-small;\" colspan=\"6\">");
            sbuf.append("</td></tr>" + Layout.LINE_SEP);
        }
        return sbuf.toString();
    }
}
