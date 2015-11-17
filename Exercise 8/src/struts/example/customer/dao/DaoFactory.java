package struts.example.customer.dao;

import struts.example.customer.dao.msaccess.DaoFactoryAccessImpl;
import struts.example.customer.dao.mysql.DaoFactoryMysqlImpl;

/**
 * This is a implementation of Abstract Factory
 * 
 * @author Srikanth Shenoy.
 * @version $Revision: $ $Date: $
 */
public abstract class DaoFactory {

  public static final int MS_ACCESS = 0;
  public static final int ORACLE    = 1;
  public static final int DB2       = 2;
  public static final int MYSQL     = 3;

  public abstract CustomerDao getCustomerDao();
  /**
   * choose database to use.
   * 
   * @param whichDao
   *          choose database
   */
  public static DaoFactory getDaoFactory(int whichDao) {

    DaoFactory daoFactory = null;
    switch (whichDao) {
      case MS_ACCESS:
        daoFactory = new DaoFactoryAccessImpl();
        break;
      case ORACLE:
      case DB2:
      case MYSQL:
        daoFactory = new DaoFactoryMysqlImpl();
        break;

      default:
        throw new UnsupportedOperationException(
            "On MS Access Dao Factories are currently supported");
    }
    return daoFactory;
  }

}
