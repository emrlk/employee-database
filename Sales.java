/**
 * @author Emily Louk
 */

public class Sales extends Employee {

  private double salesAmount;
  private char type;

  // Constructors ----------------------------------------------
  public Sales() {
    super();
  }

  public Sales(String name, double salesAmount, char type) {
    super(name);
    this.salesAmount = salesAmount;
    this.type = type;
  }

  public Sales(Sales copy) {
    super(copy.getName());
    this.salesAmount = copy.salesAmount;
    this.type = copy.type;
  }


  // Methods --------------------------------------------------
  public double getSalesAmount() {
  return salesAmount;
  }

  public char getType() {
  return type;
  }

  public void setSalesAmount(double salesAmount) {
    this.salesAmount = salesAmount;
  }

  public void setType(char type) {
    this.type = type;
  }

  public double getSalary() {
  return Math.round((salesAmount * .10) * 100) / 100;
  }

  public boolean equals(Sales sales) {
    boolean flag = false;
    if (this.getName().equalsIgnoreCase(sales.getName()) 
        && this.salesAmount == sales.salesAmount
        && this.type == sales.type)
      flag = true;
    return flag;
  }

  public String toString() {
    String str = "";
    str += "\nSales Member:";
    str += super.toString(); 
    str += "\nWeekly Salary: $" + getSalary();
    str += "\nSales Amount: $" + salesAmount;
    str += "\nType: " + type;
    return str;
  }

}