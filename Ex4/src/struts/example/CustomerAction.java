package struts.example;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CustomerAction handles all form submission requests for CustomerForm.
 *
 * @author Srikanth Shenoy
 * @version $Revision: $ $Date: $
 */
public class CustomerAction extends Action {
  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    ActionForward nextPage = null;
    CustomerForm custForm = (CustomerForm) form;

    if (custForm.getCancel().isSelected()) {
      System.out.println("Cancel Operation Performed");
      nextPage = mapping.findForward("mainpage");
    } else
      if (custForm.getSave().isSelected()) {
        String firstName = custForm.getFirstName();
        String lastName = custForm.getLastName();

        System.out.println("Customer First name is " + firstName);
        System.out.println("Customer Last name is " + lastName);
        System.out
            .println("Customer City is " + custForm.getAddress().getCity());
        System.out
            .println("Customer State is " + custForm.getAddress().getState());
        System.out
            .println("Customer Zip code is " + custForm.getAddress().getZip());

        nextPage = mapping.findForward("success");
      }
    return nextPage;
  }

}
