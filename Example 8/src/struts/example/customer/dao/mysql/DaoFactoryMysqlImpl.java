package struts.example.customer.dao.mysql;

import struts.example.customer.dao.CustomerDao;
import struts.example.customer.dao.DaoFactory;

/**
 * This is a implementation of Factory Method
 * 
 * @author Lamvx.
 * @version 11/05/2015
 */
public class DaoFactoryMysqlImpl extends DaoFactory {

  public CustomerDao getCustomerDao() {

    return new CustomerDaoMysqllmpl();
  }

}
