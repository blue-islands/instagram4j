package jp.livlog.instagram4j.utility;


public class InstagramUtil {


    public String setUrlParameter(final StringBuffer sb, final Parameter... params) {

        int count = 0;
        for (final Parameter param : params) {
            if (count == 0) {
                sb.append("?" + param.getParameter() + "=" + param.getValue());
            } else {
                sb.append("&" + param.getParameter() + "=" + param.getValue());
            }
            count++;
        }
        return sb.toString();
    }
}
