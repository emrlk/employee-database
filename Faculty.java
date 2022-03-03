/**
 * Faculty is a child of the Employee class.
 * 
 * @author Emily Louk
 * @since 5-01-2021
 */

public class Faculty extends Employee {

  private double yearlyPay;
  private String department;

  // Contructors---------------------------------------------------
  /**
   * Default constructor
   */
  public Faculty() {
    super();
  }

  /**
   * Overloaded constructor
   * 
   * @param yearlyPay  the members yearly pay
   * @param department the members department
   */
  public Faculty(String name, double yearlyPay, String department) {
    super(name);
    this.yearlyPay = yearlyPay;
    this.department = department;
  }

  /**
   * Copy constructor
   * 
   * @param copy the member to copy attributes from
   */
  public Faculty(Faculty copy) {
    super(copy.getName());
    this.yearlyPay = copy.yearlyPay;
    this.department = copy.department;
  }

  // Methods -----------------------------------------------------

  /**
   * getYearlyPay
   * 
   * @return the members yearly pay
   */
  public double getYearlyPay() {
    return yearlyPay;
  }

  /**
   * getDepartment
   * 
   * @return the members department
   */
  public String getDepartment() {
    return department;
  }

  /**
   * setYearlyPay
   * 
   * @param yearlyPay the yearly pay to assign
   */
  public void setYearlyPay(double yearlyPay) {
    this.yearlyPay = yearlyPay;
  }

  /**
   * setDepartment
   * 
   * @param department the department to assign
   */
  public void setDepartment(String department) {
    this.department = department;
  }

  @Override

  /**
   * getSalary overrides the parent's method
   * 
   * @return the members salary
   */
  public double getSalary() {
    double salary = Math.round((yearlyPay / 52) * 100) / 100; // Formats to .00
    return salary;
  }

  /**
   * equals compares two faculty member's attributes
   * 
   * @param faculty the other member to compare with
   * @return True if contents are the same, false otherwise
   */
  public boolean equals(Faculty faculty) {
    boolean flag = false;
    if (this.getName().equalsIgnoreCase(faculty.getName()) &&
        this.yearlyPay == faculty.yearlyPay
        && this.department == faculty.department)
      flag = true;
    return flag;
  }

  /**
   * toString
   * 
   * @return a string representation of the member's attributes
   */
  public String toString() {
    String str = "";
    str += "\nFaculty Member: ";
    str += super.toString();
    str += "\nWeekly Salary: $" + getSalary();
    str += "\nYearly Pay: $" + yearlyPay;
    str += "\nDepartment: " + department;
    return str;
  }

}