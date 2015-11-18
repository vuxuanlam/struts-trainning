package struts.example.search;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.example.customer.delegate.CustomerDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCustomersAction extends Action {

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String[] isSelected;
    ActionForward forward = null;
    ManageCustomersForm manageCust = (ManageCustomersForm) form;

    if (manageCust.getNewButton().isSelected()) {
      forward = mapping.findForward("add");
    } else
      if (manageCust.getDeleteButton().isSelected()) {

        CustomerDelegate delegate = new CustomerDelegate();
        isSelected = manageCust.getIdSelections();

        if (isSelected.length > 0 && isSelected != null) {

          for (int i = 0; i < isSelected.length; i++) {
            int id = Integer.parseInt(isSelected[i]);
            delegate.deleteCustomer(id);
          }
        }
        forward = mapping.findForward("deleteSuccess");
      }

    // TODO Auto-generated method stub
    return forward;
  }
}
