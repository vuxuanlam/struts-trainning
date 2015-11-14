package struts.example;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;
import org.apache.struts.util.MessageResources;
import struts.example.customer.Address;

import javax.servlet.http.HttpServletRequest;


/**
 * CustomerForm is the object representation of the html form for entering
 * customer's first and last name in Struts.
 *
 * @author Srikanth Shenoy
 * @version $Revision: $ $Date: $
 */
public class CustomerForm extends ActionForm {

  /** Customer First Name. */
  private String firstName;

  /** Customer Last Name. */
  private String lastName;

  private Address address;

  private String emailAddress;

  private String preferredCarrier;

  private boolean receiveEmail;

  private ImageButtonBean save;

  private ImageButtonBean cancel;
  /**
   * serialVersionUID.
   */
  public CustomerForm() {
    // Dont forget to Initialize here
    // Also dont forget to init in reset();
    init();
  }

  // Without this method to initialization, non-primitive objects such as
  // Address, ImageButtonBean will throw NullPointerException
  // or might not work as expected
  // since a getAddress(), getSave() etc. returns a null object
  protected void init() {

    firstName = "";
    lastName = "";
    emailAddress = "";
    preferredCarrier = "USP";
    receiveEmail = true;
    address = new Address();
    save = new ImageButtonBean();
    cancel = new ImageButtonBean();
  }

  @Override
  public void reset(ActionMapping mapping, HttpServletRequest request) {

    if (request.getParameter("receiveEmail") == null
        || request.getParameter("receiveEmail").equals("false")) {
      // Checkbox parameter was not received. Set the
      // receiveEmail to false
      receiveEmail = false;
    }
  }

  public String getFirstName() {

    return firstName;
  }

  public void setFirstName(String string1) {

    this.firstName = string1;
  }

  public String getLastName() {

    return lastName;
  }

  public String getEmailAddress() {

    return emailAddress;
  }

  public void setEmailAddress(String string2) {

    emailAddress = string2;
  }

  public void setLastName(String string3) {

    this.lastName = string3;
  }

  public String getPreferredCarrier() {

    return preferredCarrier;
  }

  public void setPreferredCarrier(String string) {

    preferredCarrier = string;
  }

  public boolean getReceiveEmail() {

    return receiveEmail;
  }

  public void setReceiveEmail(boolean bl) {

    receiveEmail = bl;
  }

  public Address getAddress() {

    return address;
  }

  public ImageButtonBean getCancel() {

    return cancel;
  }

  public ImageButtonBean getSave() {

    return save;
  }

  /**
   * This method is called by the RequestProcessor immediately after populating
   * the CustomerForm only if the validate=true flag is set in the
   * struts-config.xml Do validation here and return ActionErrors if any, to the
   * RequestProcessor
   */
  public ActionErrors validate(ActionMapping mapping,
      HttpServletRequest request) {

    ActionErrors errors = new ActionErrors();

    // Need to do this explicitly now. Since the Button is not grey and its name
    // is not
    // org.apache.struts...Cancel anymore, and the validate=true still
    // remains in ActionMapping, the call to bypass validation on clicking
    // cancel image
    // has to be performed manually
    if (getCancel().isSelected()) {
      return errors;
    }

    MessageResources msgRes = (MessageResources) request
        .getAttribute(Globals.MESSAGES_KEY);

    // Firstname cannot be empty
    if (firstName == null || firstName.trim().equals("")) {
      String firstName = msgRes.getMessage("prompt.customer.firstname");
      String[] rplcmntValueArr = { firstName };
      ActionError err = new ActionError("error.required", rplcmntValueArr);
      errors.add("firstName", err);
    }

    // Lastname cannot be empty
    if (lastName == null || lastName.trim().equals("")) {
      String lastName = msgRes.getMessage("prompt.customer.lastname");
      String[] rplcmntValueArr = { lastName };
      ActionError err = new ActionError("error.required", rplcmntValueArr);
      errors.add("lastName", err);
    }

    return errors;
  }

}
