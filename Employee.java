/**
 * @author Emily Louk
 */
public abstract class Employee {

  private String name;
     
  // Constructors --------------------------------------------------
  public Employee() {
    name = " ";
  }

  public Employee(String name) {
    this.name = name;
  }

  public Employee(Employee copy) {
    this.name = copy.name;
  }

  // Methods ------------------------------------------------------
  public String getName() {
  return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public abstract double getSalary();

  public boolean equals(Employee employee) {
    boolean flag = false;
    if (this.name.equals(employee.name))
      flag = true;
    return flag;
  }

  public String toString() {
    String str = "";
    str += "\nEmployee's Name: " + name;
    return str;
  }

}