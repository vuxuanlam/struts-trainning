package struts.example.exception;

import org.apache.commons.logging.Log;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import org.apache.commons.logging.Log;

/**
 * @author lamvx.
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class BaseException extends Exception {

  private Throwable throwable;

  private String userMessageKey;

  private Serializable[] valueReplacementArray;

  private String uniqueId;

  private ErrorLevel errorLevel;

  private boolean logged;

  /**
   * Base Exeption.
   */
  public BaseException(Throwable canThrowable, String anUserMessageKey,
      Serializable[] anValueReplacementArray, ErrorLevel level) {

    this.throwable = canThrowable;
    this.userMessageKey = anUserMessageKey;
    this.valueReplacementArray = anValueReplacementArray;
    this.errorLevel = level;
    this.uniqueId = new Double(Math.random()).toString();
  }

  /**
   * log.
   */
  public void log(Log log) {

    if (errorLevel.equals(ErrorLevel.INFO) && log.isDebugEnabled()) {
      log.debug("Info Message: ID - " + uniqueId + " User Message: "
          + userMessageKey);
      log.debug(StackTracer.getStackTrace(throwable));
    } else
      if (errorLevel.equals(ErrorLevel.WARNING) && log.isWarnEnabled()) {
        log.warn("Warn Message: ID - " + uniqueId + " User Message: "
            + userMessageKey);
        log.warn(StackTracer.getStackTrace(throwable));
      } else
        if (errorLevel.equals(ErrorLevel.ERROR) && log.isErrorEnabled()) {
          log.error("Error Message: ID - " + uniqueId + " User Message: "
              + userMessageKey);
          log.error(StackTracer.getStackTrace(throwable));
        } else
          if (errorLevel.equals(ErrorLevel.FATAL) && log.isFatalEnabled()) {
            log.fatal("Fatal Message: ID - " + uniqueId + " User Message: "
                + userMessageKey);
            log.fatal(StackTracer.getStackTrace(throwable));
          }
    logged = true;
  }

  public boolean isLogged() {

    return logged;
  }

  private static class StackTracer {

    static String getStackTrace(Throwable exception) {

      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      pw.print(" [ ");
      pw.print(exception.getClass().getName());
      pw.print(" ] ");
      exception.printStackTrace(pw);
      return sw.toString();
    }
  }

  
  public String getUserMessageKey() {

    return userMessageKey;
  }

  public String getUniqueId() {

    return uniqueId;
  }

  
  public Serializable[] getValueReplacementArray() {

    return valueReplacementArray;
  }

}
