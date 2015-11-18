/*
 * Created on Jul 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

package struts.example.customer.dao;

import struts.example.exception.BaseException;
import struts.example.exception.ErrorLevel;

import java.io.Serializable;

/**
 * @author lamvx.
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DaoException extends BaseException {

  public DaoException(Throwable getThrowable, String userMessageKey,
      Serializable[] valueReplacementArray, ErrorLevel level) {
    super(getThrowable, userMessageKey, valueReplacementArray, level);
  }
}
