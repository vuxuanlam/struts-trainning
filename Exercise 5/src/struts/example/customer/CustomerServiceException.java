package struts.example.customer;

import struts.example.exception.ErrorLevel;
import struts.example.exception.LightweightBaseException;

import java.io.Serializable;



public class CustomerServiceException extends LightweightBaseException {

  private static final long serialVersionUID = 1L;
  
  public CustomerServiceException(String userMessageKey,
      Serializable[] valueReplacementArray, String anUniqueId,
      ErrorLevel anErrorLevel) {
    super(userMessageKey, valueReplacementArray, anUniqueId, anErrorLevel);
  }

}
