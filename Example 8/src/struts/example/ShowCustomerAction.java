package struts.example;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import struts.example.customer.CustomerDetailObject;
import struts.example.customer.delegate.CustomerDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCustomerAction extends Action {

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    ActionForward nextPage = null;

    if ("Create".equals(request.getParameter("action"))) {
      nextPage = mapping.findForward("customerFormPage");
    } else
      if ("Edit".equals(request.getParameter("action"))) {
        CustomerDelegate delegate = new CustomerDelegate();
        CustomerDetailObject customer = delegate
            .getCustomerDetail(request.getParameter("email"));
        CustomerForm custForm = CustomerFormAssembler
            .createCustomerForm(customer);
        request.setAttribute("CustomerForm", custForm);
        nextPage = mapping.findForward("customerFormPage");

      }
    // TODO Auto-generated method stub
    return nextPage;
  }

  public ActionForward Create(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    return mapping.findForward("customerFormPage");
  }

  public ActionForward Edit(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    CustomerDelegate delegate = new CustomerDelegate();
    CustomerDetailObject customer = delegate
        .getCustomerDetail(request.getParameter("email"));
    CustomerForm custForm = CustomerFormAssembler.createCustomerForm(customer);
    request.setAttribute("CustomerForm", custForm);
    return mapping.findForward("customerFormPage");
  }

}
