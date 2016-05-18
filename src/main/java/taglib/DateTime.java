package taglib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Custom tag library.
 * Shows current data ant time.
 * @author Anastasiia Rybakova
 * @since  05.2016
 */
public class DateTime extends TagSupport{

    private String mFormat;

    public void setFormat(String pFormat) {
        mFormat = pFormat;
    }

    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            Date date = new Date();
            SimpleDateFormat dateFormatter = new SimpleDateFormat(mFormat);
            out.print(dateFormatter.format(date));
        } catch(IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}