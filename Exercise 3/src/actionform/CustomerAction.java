package actionform;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * CustomerAction handles all form submission requests for CustomerForm.
 *
 */
public class CustomerAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomerForm custForm = (CustomerForm) form;
		ActionForward nextPage = null;
		if (custForm.getCancel().isSelected()) {
			System.out.println("Cancel Operation Performed");
			return mapping.findForward("mainpage");
		}

		if (custForm.getSave().isSelected()) {
			String firstName = custForm.getFirstName();
			String lastName = custForm.getLastName();
			Address address = custForm.getAddress();

			System.out.println("Customer First name is " + firstName);
			System.out.println("Customer Last name is " + lastName);
			System.out.println("Customer City is " + address.getCity());
			System.out.println("Customer State is " + address.getState());
			System.out.println("Customer Zip is " + address.getZip());

			nextPage = mapping.findForward("success");
		}
		return nextPage;
	}

}