package struts.example.customer.delegate;

import struts.example.customer.*;
import struts.example.customer.dao.DuplicateCustomerException;

/**
 *
 * @author Srikanth Shenoy.
 * @version $Revision: $ $Date: $
 */
public class CustomerDelegate {
  /**
   * Customer details object.
   */
  public CustomerDetailObject getCustomerDetail(String emailAddress)
      throws CustomerServiceException {

    CustomerControllerService custService = new CustomerControllerService();
    return custService.getCustomerDetail(emailAddress);
  }
  
  /**
   * create Customer.
   */
  public void createCustomer(CustomerDetailObject customer)
      throws CustomerServiceException, DuplicateCustomerException {

    CustomerControllerService custService = new CustomerControllerService();
    custService.createCustomer(customer);
  }
  /**
   * update Customer.
   */
  public void updateCustomer(CustomerDetailObject customer)
      throws CustomerServiceException, DuplicateCustomerException {

    CustomerControllerService custService = new CustomerControllerService();
    custService.updateCustomer(customer);
  }
  /**
   * delete Customer.
   */
  public void deleteCustomer(int id) throws CustomerServiceException {

    CustomerControllerService custService = new CustomerControllerService();
    custService.deleteCustomer(id);
  }
}
