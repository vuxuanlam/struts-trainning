package struts.example.customer.dao.mysql;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import struts.example.customer.Address;
import struts.example.customer.CustomerDetailObject;
import struts.example.customer.dao.CustomerDao;
import struts.example.customer.dao.DaoException;
import struts.example.customer.dao.DuplicateCustomerException;
import struts.example.customer.list.CustomerSummaryObject;
import struts.example.exception.ErrorLevel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerDAO encapsulates data access and manipulation It represents the Data
 * Access Object (DAO) Pattern. A DAO abstract the mechanisms of accessing and
 * manipulating a persistence store such as database
 * 
 * @author Lamvx
 * @version 11/05/2015
 */
public class CustomerDaoMysqllmpl implements CustomerDao {

  protected static String DB_FIELDS = "EMAIL, FIRSTNAME, LASTNAME, PREFERRED_CARRIER,"
      + " CAN_RECV_MAIL, ADDRESS1, ADDRESS2," + " CITY, STATE, ZIPCODE";

  protected static String SELECT_SQL = "SELECT ID, " + DB_FIELDS
      + " FROM CUSTOMER WHERE EMAIL = ?";

  protected static String SEARCH_SQL = "SELECT ID, " + DB_FIELDS
      + " FROM CUSTOMER WHERE LASTNAME = ? ORDER BY ID";

  protected static String INSERT_SQL = "INSERT INTO CUSTOMER ( " + DB_FIELDS
      + " ) " + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

  protected static String UPDATE_SQL = "UPDATE CUSTOMER SET EMAIL = ?, FIRSTNAME = ?,"
      + " LASTNAME = ?, PREFERRED_CARRIER = ?, "
      + " CAN_RECV_MAIL = ?, ADDRESS1 = ?, ADDRESS2 = ?,"
      + " CITY = ?, STATE = ?, ZIPCODE = ?" + " WHERE ID = ?";

  protected static String DELETE_SQL = "DELETE FROM CUSTOMER WHERE EMAIL = ?";

  protected static String DELETE_ID_SQL = "DELETE FROM CUSTOMER WHERE ID = ?";

  public CustomerDaoMysqllmpl() {

  }

  /**
   * Customer details object.
   */
  public CustomerDetailObject fetchDetail(String emailAddress)
      throws DaoException {

    PreparedStatement prepareStmt = null;
    Connection con = getConnection();
    CustomerDetailObject customer = null;
    try {
      prepareStmt = con.prepareStatement(SELECT_SQL);
      prepareStmt.setString(1, emailAddress);

      ResultSet rs = prepareStmt.executeQuery();
      if (rs.next()) {
        customer = extractCustomerDetailObjectFromResultSet(rs);
      }
    } catch (SQLException se) {
      String[] valueReplacementArray = { emailAddress };
      throw new DaoException(se, "error.database.fetch.customerdetail",
          valueReplacementArray, ErrorLevel.ERROR);
    } finally {
      try {
        con.close();
      } catch (SQLException sq) {}
    }

    return customer;
  }

  /**
   * find customer.
   */
  public CustomerSummaryObject[] find(String lastName) throws DaoException {

    PreparedStatement prepareStmt = null;
    Connection con = getConnection();
    CustomerSummaryObject customer = null;
    List list = new ArrayList();

    try {
      prepareStmt = con.prepareStatement(SEARCH_SQL);
      prepareStmt.setString(1, lastName);

      ResultSet rs = prepareStmt.executeQuery();
      while (rs.next()) {
        customer = extractCustomerSummaryObjectFromResultSet(rs);
        list.add(customer);
      }
    } catch (SQLException se) {
      String[] valueReplacementArray = { lastName };
      throw new DaoException(se, "error.database.fetch.customersummary",
          valueReplacementArray, ErrorLevel.ERROR);
    } finally {
      try {
        con.close();
      } catch (SQLException sq) {}
    }

    CustomerSummaryObject[] customers = null;
    if (list.size() > 0) {
      customers = (CustomerSummaryObject[]) list
          .toArray(new CustomerSummaryObject[list.size()]);
    }

    return customers;
  }

  /**
   * create customer.
   */
  public int create(CustomerDetailObject customer)
      throws DaoException, DuplicateCustomerException {

    int insertedRows = 0;
    PreparedStatement prepareStmt = null;
    Connection con = getConnection();
    try {
      CustomerDetailObject det = fetchDetail(customer.getEmailAddress());
      if (det != null) {
        throw new DuplicateCustomerException(
            "error.database.customer.duplicate", customer.getEmailAddress(),
            null, ErrorLevel.WARNING);
      }

      prepareStmt = con.prepareStatement(INSERT_SQL);
      prepareStmt.setString(1, customer.getEmailAddress());
      prepareStmt.setString(2, customer.getFirstName());
      prepareStmt.setString(3, customer.getLastName());
      prepareStmt.setString(4, customer.getPreferredCarrier());
      prepareStmt.setBoolean(5, customer.getReceiveEmail());
      prepareStmt.setString(6, customer.getAddress().getAddress1());
      prepareStmt.setString(7, customer.getAddress().getAddress2());
      prepareStmt.setString(8, customer.getAddress().getCity());
      prepareStmt.setString(9, customer.getAddress().getState());
      prepareStmt.setString(10, customer.getAddress().getZip());

      insertedRows = prepareStmt.executeUpdate();
    } catch (SQLException se) {
      String[] valueReplacementArray = { customer.getEmailAddress() };
      throw new DaoException(se, "error.database.customer.save",
          valueReplacementArray, ErrorLevel.ERROR);
    } finally {
      try {
        con.close();
      } catch (SQLException sq) {}
    }

    return insertedRows;
  }

  /**
   * create customer.
   */
  public void update(CustomerDetailObject customer)
      throws DaoException, DuplicateCustomerException {

    int updatedRows = 0;

    PreparedStatement prepareStmt = null;
    Connection con = getConnection();
    try {
      CustomerDetailObject det = fetchDetail(customer.getEmailAddress());
      if (det != null && det.getId() != customer.getId()) {
        throw new DuplicateCustomerException(
            "error.database.customer.duplicate", customer.getEmailAddress(),
            null, ErrorLevel.WARNING);
      }

      prepareStmt = con.prepareStatement(UPDATE_SQL);
      prepareStmt.setString(1, customer.getEmailAddress());
      prepareStmt.setString(2, customer.getFirstName());
      prepareStmt.setString(3, customer.getLastName());
      prepareStmt.setString(4, customer.getPreferredCarrier());
      prepareStmt.setBoolean(5, customer.getReceiveEmail());
      prepareStmt.setString(6, customer.getAddress().getAddress1());
      prepareStmt.setString(7, customer.getAddress().getAddress2());
      prepareStmt.setString(8, customer.getAddress().getCity());
      prepareStmt.setString(9, customer.getAddress().getState());
      prepareStmt.setString(10, customer.getAddress().getZip());
      prepareStmt.setInt(11, customer.getId());

      updatedRows = prepareStmt.executeUpdate();
    } catch (SQLException se) {
      String[] valueReplacementArray = { customer.getEmailAddress() };
      throw new DaoException(se, "error.database.customer.save",
          valueReplacementArray, ErrorLevel.ERROR);
    } finally {
      try {
        con.close();
      } catch (SQLException sq) {}
    }
  }

  /**
   * delete Customer.
   */
  public void delete(int id) throws DaoException {

    int updatedRows = 0;
    PreparedStatement prepareStmt = null;
    Connection con = getConnection();
    try {
      prepareStmt = con.prepareStatement(DELETE_ID_SQL);
      prepareStmt.setInt(1, id);
      updatedRows = prepareStmt.executeUpdate();
    } catch (SQLException se) {
      String[] valueReplacementArray = { new Integer(id).toString() };
      throw new DaoException(se, "error.database.customer.delete",
          valueReplacementArray, ErrorLevel.ERROR);
    } finally {
      try {
        con.close();
      } catch (SQLException sq) {}
    }
  }

  protected CustomerDetailObject extractCustomerDetailObjectFromResultSet(
      ResultSet rs) throws SQLException {

    CustomerDetailObject customer = new CustomerDetailObject();
    customer.setId(rs.getInt("ID"));
    customer.setEmailAddress(rs.getString("EMAIL"));
    customer.setFirstName(rs.getString("FIRSTNAME"));
    customer.setLastName(rs.getString("LASTNAME"));
    customer.setPreferredCarrier(rs.getString("PREFERRED_CARRIER"));
    customer.setReceiveEmail(rs.getBoolean("CAN_RECV_MAIL"));

    Address address = new Address();
    address.setAddress1(rs.getString("ADDRESS1"));
    address.setAddress2(rs.getString("ADDRESS2"));
    address.setCity(rs.getString("CITY"));
    address.setState(rs.getString("STATE"));
    address.setZip(rs.getString("ZIPCODE"));

    customer.setAddress(address);
    return customer;
  }

  protected CustomerSummaryObject extractCustomerSummaryObjectFromResultSet(
      ResultSet rs) throws SQLException {

    CustomerSummaryObject customer = new CustomerSummaryObject();
    customer.setId(rs.getInt("ID"));
    customer.setEmailAddress(rs.getString("EMAIL"));
    customer.setFirstName(rs.getString("FIRSTNAME"));
    customer.setLastName(rs.getString("LASTNAME"));

    return customer;
  }

  protected Connection getConnection() throws DaoException {

    Connection dbConnection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");

      // Use this for detailed debugging:
      // DriverManager.setLogStream(java.lang.System.out);
      dbConnection = DriverManager
          .getConnection("jdbc:mysql://localhost/STRUTS_TRAINING", "root", "");
    } catch (ClassNotFoundException cfe) {
      throw new DaoException(cfe, "error.database.config", null,
          ErrorLevel.FATAL);
    } catch (SQLException se) {
      throw new DaoException(se, "error.database.config", null,
          ErrorLevel.FATAL);
    }
    return dbConnection;
  }

  /**
   * main method.
   */
  public static void main(String[] args) {

    try {
      CustomerDaoMysqllmpl dao = new CustomerDaoMysqllmpl();
      CustomerDetailObject cust = dao.fetchDetail("joe.moe@yahoo.com");
      System.out.println(cust);
    } catch (DaoException e) {
      Log log = LogFactory.getLog("CustomerDao");
      e.log(log);
    }
  }
}
