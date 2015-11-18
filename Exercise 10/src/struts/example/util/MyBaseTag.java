package struts.example.util;

import org.apache.struts.Globals;

import org.apache.struts.taglib.html.BaseTag;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class MyBaseTag extends BaseTag {
  @Override

  public int doStartTag() throws JspException {

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    String baseTag = renderBaseElement(request.getScheme(),
        request.getServerName(), request.getServerPort(),
        request.getContextPath());
    JspWriter out = pageContext.getOut();
    try {
      out.write(baseTag);
    } catch (IOException e) {
      pageContext.setAttribute(Globals.EXCEPTION_KEY, e,
          PageContext.REQUEST_SCOPE);
      throw new JspException(e.toString());
    }
    return EVAL_BODY_INCLUDE;
  }

}
