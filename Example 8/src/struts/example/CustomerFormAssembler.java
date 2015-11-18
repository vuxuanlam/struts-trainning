package struts.example;

import org.apache.commons.beanutils.BeanUtils;

import struts.example.customer.CustomerDetailObject;

import java.lang.reflect.InvocationTargetException;

public class CustomerFormAssembler {

  private CustomerFormAssembler() {

  }

  /**
   * create customer form.
   */
  public static final CustomerForm createCustomerForm(
      CustomerDetailObject customerDetail) {

    CustomerForm form = new CustomerForm();
    try {
      BeanUtils.copyProperties(form, customerDetail);
      BeanUtils.copyProperties(form.getAddress(), customerDetail.getAddress());
    } catch (InvocationTargetException ite) {
      ite.printStackTrace(); // do nothing for now
    } catch (IllegalAccessException iae) {
      iae.printStackTrace(); // do nothing for now
    }
    return form;
  }
}
