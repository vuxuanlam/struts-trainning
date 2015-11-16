package struts.example.customer.dao;

import struts.example.exception.ErrorLevel;
import struts.example.exception.LightweightBaseException;

/**
 *
 * @author Srikanth Shenoy.
 * @version $Revision: $ $Date: $
 */
public class DuplicateCustomerException extends LightweightBaseException {

  /**
   * Duplicate customer exeption.
   */
  public DuplicateCustomerException(String userMessageKey, String email,
      String anUniqueId, ErrorLevel anErrorLevel) {
    super(userMessageKey, null, anUniqueId, anErrorLevel);
    String[] varArray = { email };
    setValueReplacementArray(varArray);
  }

}
