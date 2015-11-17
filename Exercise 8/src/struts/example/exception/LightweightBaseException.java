/*
 * Created on Jul 1, 2004

 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

package struts.example.exception;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments.
 */
public abstract class LightweightBaseException extends Exception {

  private String uniqueId;

  private ErrorLevel level;

  private String userMessageKey;

  private Serializable[] valueReplacementArray;

  public LightweightBaseException(String aUserMessageKey,
      Serializable[] aValueReplacementArray, String aUniqueId,
      ErrorLevel anErrorLevel) {
    this.userMessageKey = aUserMessageKey;
    this.valueReplacementArray = aValueReplacementArray;
    this.uniqueId = aUniqueId;
    this.level = anErrorLevel;
  }

  
  public Serializable[] getValueReplacementArray() {

    return valueReplacementArray;
  }


  protected void setValueReplacementArray(Serializable[] serializables) {

    valueReplacementArray = serializables;
  }

  public String getUserMessageKey() {

    return userMessageKey;
  }

  
  public ErrorLevel getLevel() {

    return level;
  }

  
  public String getUniqueId() {

    return uniqueId;
  }

}
