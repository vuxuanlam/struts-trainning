package struts.example.customer.dao.msaccess;

import struts.example.customer.dao.CustomerDao;
import struts.example.customer.dao.DaoFactory;

/**
 * This is a implementation of Factory Method
 * 
 * @author Srikanth Shenoy.
 * @version $Revision: $ $Date: $
 */

public class DaoFactoryAccessImpl extends DaoFactory {

  public CustomerDao getCustomerDao() {

    return new CustomerDaoAccessImpl();
  }

}
