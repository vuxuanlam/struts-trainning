package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;
import org.apache.struts.util.MessageResources;

public class CustomerForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String firstName;
	/** Customer First Name */
	private String lastName;
	/** Customer Last Name */
	private Address address;
	/** Customer Address */
	private String emailAddress;
	private String preferredCarrier;

	private boolean receiveEmail;

	private ImageButtonBean save;

	private ImageButtonBean cancel;

		public CustomerForm() {

		init();
	}

	protected void init() {
		this.firstName = "";
		this.lastName = "";
		this.emailAddress = "";
		this.preferredCarrier = "FDX";
		this.receiveEmail = true;
		this.address = new Address();
		this.save = new ImageButtonBean();
		this.cancel = new ImageButtonBean();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String s) {
		this.firstName = s;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String s) {
		this.lastName = s;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public void setReceiveEmail(boolean b) {
		receiveEmail = b;
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

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		// Need to do this explicitly now. Since the Button is not grey and its
		// name is not
		// org.apache.struts...Cancel anymore, and the validate=true still
		// remains in ActionMapping, the call to bypass validation on clicking
		// cancel image
		// has to be performed manually
		if (getCancel().isSelected()) {
			return errors;
		}

		MessageResources msgRes = (MessageResources) request.getAttribute(Globals.MESSAGES_KEY);

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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if (request.getParameter("receiveEmail") == null || request.getParameter("receiveEmail").equals("false")) {
			// Checkbox parameter was not received. Set the
			// receiveEmail to false
			receiveEmail = false;
		}
	}
}