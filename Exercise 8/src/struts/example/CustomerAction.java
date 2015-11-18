package struts.example;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.example.customer.CustomerDetailObject;
import struts.example.customer.delegate.CustomerDelegate;

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
        CustomerDetailObject custObject = CustomerDetailAssembler
            .createCustomerDetail(custForm);
        CustomerDelegate delegate = new CustomerDelegate();
        if (custObject.getId() == 0) {
          delegate.createCustomer(custObject);
        } else {
          delegate.updateCustomer(custObject);
        }
        nextPage = mapping.findForward("gotoSearchPage");
      }

    return nextPage;
  }

}
