package struts.example.customer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import struts.example.customer.dao.CustomerDao;
import struts.example.customer.dao.DaoException;
import struts.example.customer.dao.DaoFactory;
import struts.example.customer.dao.DuplicateCustomerException;
import struts.example.exception.ErrorLevel;

/**
 * In real projects, CustomerControllerService object is often implemented as
 * Session EJB. It represents a Business Service and is Session Facade pattern
 * (Core J2EE Patterns)
 * 
 * @author Srikanth Shenoy
 * @version $Revision: $ $Date: $
 */
public class CustomerControllerService {

  /**
   * 
   * @param emailAddress.
   * 
   * @throws CustomerServiceException.
   * 
   */
  public CustomerDetailObject getCustomerDetail(String emailAddress)
      throws CustomerServiceException {

    CustomerDetailObject customer = null;
    try {
      DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
      CustomerDao dao = daoFactory.getCustomerDao();
      customer = dao.fetchDetail(emailAddress);
    } catch (DaoException de) {
      if (!de.isLogged()) {
        Log log = LogFactory.getLog("CustomerFetchService");
        de.log(log);
      }
      throw new CustomerServiceException(de.getUserMessageKey(),
          de.getValueReplacementArray(), de.getUniqueId(), ErrorLevel.ERROR);
    }

    return customer;
  }

  /**
   * @param customer.
   * @throws CustomerServiceException.
   * 
   * @throws DuplicateCustomerException.
   * 
   */
  public void createCustomer(CustomerDetailObject customer)
      throws CustomerServiceException, DuplicateCustomerException {

    try {
      customer.getAddress().setAddress1("N/A");
      customer.getAddress().setAddress2("N/A");
      DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
      CustomerDao dao = daoFactory.getCustomerDao();
      dao.create(customer);
    } catch (DaoException de) {
      if (!de.isLogged()) {
        Log log = LogFactory.getLog("CustomerInsertService");
        de.log(log);
      }
      throw new CustomerServiceException(de.getUserMessageKey(),
          de.getValueReplacementArray(), de.getUniqueId(), ErrorLevel.ERROR);
    }
  }

  /**
   * 
   * @param customer.
   * @throws CustomerServiceException.
   * 
   * @throws DuplicateCustomerException.
   * 
   */
  public void updateCustomer(CustomerDetailObject customer)
      throws CustomerServiceException, DuplicateCustomerException {

    try {
      customer.getAddress().setAddress1("N/A");
      customer.getAddress().setAddress2("N/A");
      DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
      CustomerDao dao = daoFactory.getCustomerDao();
      dao.update(customer);
    } catch (DaoException de) {
      if (!de.isLogged()) {
        Log log = LogFactory.getLog("CustomerUpdateService");
        de.log(log);
      }
      throw new CustomerServiceException(de.getUserMessageKey(),
          de.getValueReplacementArray(), de.getUniqueId(), ErrorLevel.ERROR);
    }
  }

  /**
   * 
   * @param id.
   * @throws CustomerServiceException
   *           duplicate customer
   */
  public void deleteCustomer(int id) throws CustomerServiceException {

    try {
      DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
      CustomerDao dao = daoFactory.getCustomerDao();
      dao.delete(id);
    } catch (DaoException de) {
      if (!de.isLogged()) {
        Log log = LogFactory.getLog("CustomerDeleteService");
        de.log(log);
      }
      throw new CustomerServiceException(de.getUserMessageKey(),
          de.getValueReplacementArray(), de.getUniqueId(), ErrorLevel.ERROR);
    }
  }

}
