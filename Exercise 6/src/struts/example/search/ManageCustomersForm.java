package struts.example.search;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.ImageButtonBean;

public class ManageCustomersForm extends ActionForm {

  private static final long serialVersionUID = 1L;
  private String[]          idSelections;
  private ImageButtonBean   deleteButton;
  private ImageButtonBean   newButton;

  public ManageCustomersForm() {

    init();
  }

  public String[] getIdSelections() {

    return idSelections;
  }

  public ImageButtonBean getDeleteButton() {

    return deleteButton;
  }

  public ImageButtonBean getNewButton() {

    return newButton;
  }

  public void setIdSelections(String[] idSelections) {

    this.idSelections = idSelections;
  }

  /**
   * Init for manager form.
   */
  public void init() {

    idSelections = new String[] {};
    deleteButton = new ImageButtonBean();
    newButton = new ImageButtonBean();
  }
}
