package struts.example.customer;

import java.io.Serializable;

public class HourOfOperation implements Serializable {

  private static final long     serialVersionUID = 1L;
  private static final String[] dayNames         = { "Sunday", "Monday",
      "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
  private int                   day;
  private String                openingTime;
  private String                closingTime;

  public HourOfOperation() {

  }

  public HourOfOperation(int anDay) {

    this.day = anDay;
  }

  public int getDay() {

    return day;
  }

  public void setDay(int day) {

    this.day = day;
  }

  public String getOpeningTime() {

    return openingTime;
  }

  public void setOpeningTime(String openingTime) {

    this.openingTime = openingTime;
  }

  public String getClosingTime() {

    return closingTime;
  }

  public void setClosingTime(String closingTime) {

    this.closingTime = closingTime;
  }

  public String getDayName() {

    return dayNames[day];
  }

  @Override
  public String toString() {

    return "day=" + day + "; Opening Time=" + openingTime + "; ClosingTime="
        + closingTime;
  }

}
