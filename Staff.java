/**
 * @author Emily Louk
 */

public class Staff extends Employee{

  private double hoursWorked;
  private double payrate;

  // Constructors ---------------------------------------------------
  public Staff() {
    super();
  }

  public Staff(String name, double hoursWorked, double payrate) {
    super(name);
    this.hoursWorked = hoursWorked;
    this.payrate = payrate;
  }

  public Staff(Staff copy) {
    super(copy.getName());
    this.hoursWorked = copy.hoursWorked;
    this.payrate = copy.payrate;
  }


  // Methods -------------------------------------------------------
  public double getHoursWorked() {
  return hoursWorked;
  }

  public double getPayrate() {
  return payrate;
  }

  public void setHoursWorked(double hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  public void setPayrate(double payrate) {
    this.payrate = payrate;
  }


  public double getSalary() {
    double salary = 0;
    if(hoursWorked > 40)
        salary = Math.round(hoursWorked * (payrate * 1.5) * 100) / 100;   
    else  
      salary = Math.round((hoursWorked * payrate) * 100) / 100;    
  return salary;
  }

  public boolean equals(Staff staff) {
    boolean flag = false;
    if (this.getName().equalsIgnoreCase(staff.getName()) && 
        this.hoursWorked == staff.hoursWorked &&
        this.payrate == staff.payrate)
      flag = true;
    return flag;
  }

  public String toString() {
    String str = "";
    str += "\nStaff Member: ";
    str += super.toString();
    str += "\nWeekly Salary: $" + getSalary();
    str += "\nHours Worked: " + hoursWorked;
    str += "\nPayrate: $" + payrate;
    return str;
  }

}