package struts.example.customer.dao;

import struts.example.customer.CustomerDetailObject;
import struts.example.customer.list.CustomerSummaryObject;

public interface CustomerDao {

  public CustomerDetailObject fetchDetail(String emailAddress)
      throws DaoException;

  public CustomerSummaryObject[] find(String lastName) throws DaoException;

  public int create(CustomerDetailObject customer)
      throws DaoException, DuplicateCustomerException;

  public void update(CustomerDetailObject customer)
      throws DaoException, DuplicateCustomerException;

  public void delete(int id) throws DaoException;

}
