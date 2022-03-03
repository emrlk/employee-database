
/** Main class for the employee database program
 * @author Emily Louk
 * @since 2021
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeesDriver {

  public static void main(String[] args) throws IOException {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    // File existence
    File infile = new File("employees.csv");
    Scanner scan = new Scanner(infile);
    if (!infile.exists()) {
      System.out.println("File not found.");
      System.exit(0);
    }

    // Testing
    fillArray(employees, scan);
    displayArray(employees);
    searchForName(employees);
    searchForDepartment(employees);
    searchForMinAmount(employees);

    Menu(employees);
  }

  // Utilities
  // ----------------------------------------------------------------------------------------

  public static void fillArray(ArrayList<Employee> employees, Scanner scan) throws IOException {
    String str = " ";

    while (scan.hasNext()) {

      str = scan.nextLine();
      String[] tokens = str.split(",");
      if (tokens[0].equalsIgnoreCase("s"))
        employees.add(new Staff(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
      else if (tokens[0].equalsIgnoreCase("r")) {
        char type = tokens[3].charAt(0);
        employees.add(new Sales(tokens[1], Double.parseDouble(tokens[2]), type));
      } else if (tokens[0].equalsIgnoreCase("f"))
        employees.add(new Faculty(tokens[1], Double.parseDouble(tokens[2]), tokens[3]));
      else
        System.out.println("Failed: possible bad data");
    }

  }

  public static void displayArray(ArrayList<Employee> employees) {
    for (Employee e : employees)
      System.out.println(e);
  }

  public static void searchForName(ArrayList<Employee> employees) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nEnter a last name to find an employee: ");
    String str = scan.nextLine();

    boolean found = false;
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getName().toLowerCase().endsWith(str.toLowerCase())) {
        if (employees.get(i) instanceof Faculty) {
          System.out.println("\nFaculty member:");
          System.out.print(employees.get(i));
          System.out.println("\n---------------------");
        }
        if (employees.get(i) instanceof Staff) {
          System.out.println("\nStaff member:");
          System.out.print(employees.get(i));
          System.out.println("\n---------------------");
        }
        if (employees.get(i) instanceof Sales) {
          System.out.println("\nSales member:");
          System.out.print(employees.get(i));
          System.out.println("\n---------------------");
        }
        found = true;
      }
    }
    if (!found)
      System.out.println("\nNo employee was found.");
  }

  public static void searchForDepartment(ArrayList<Employee> employees) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nEnter a department name to search for Faculty: ");
    String str = scan.nextLine();

    boolean found = false;
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i) instanceof Faculty) {
        if (((Faculty) employees.get(i)).getDepartment().toLowerCase().startsWith(str.toLowerCase())) {
          System.out.println("\nAn Faculty member in the " + str + " department was found:");
          System.out.println((Faculty) employees.get(i));
          found = true;
        }
      }
    }
    if (!found)
      System.out.println("No Faculty member found in that department.");
  }

  public static void searchForMinAmount(ArrayList<Employee> employees) {
    boolean found = false;
    Scanner scan = new Scanner(System.in);
    System.out.println("\nEnter a minimum weekly pay amount to list employees who earn above it: $");
    double minAmount = scan.nextDouble();
    for (int i = 0; i < employees.size(); i++) {

      if (employees.get(i) instanceof Faculty) {
        if (((Faculty) employees.get(i)).getSalary() >= minAmount) {
          System.out.println("\nFaculty member:");
          System.out.print(employees.get(i));
          System.out.println("\n---------------------");
        }
      }
      if (employees.get(i) instanceof Staff) {
        if (((Staff) employees.get(i)).getSalary() >= minAmount) {
          System.out.println("\nStaff member :");
          System.out.print(employees.get(i));
          System.out.println("\n---------------------");
        }
      }
      if (employees.get(i) instanceof Sales) {
        if (((Sales) employees.get(i)).getSalary() >= minAmount) {
          System.out.println("\nSales member :");
          System.out.print(employees.get(i));
          System.out.println("\n---------------------");
        }
      }
      found = true;
    }
    if (!found)
      System.out.println("\nNo sales employee was found with a weekly salary above " + minAmount + ".");
  }

  public static void Menu(ArrayList<Employee> employees) {
    Scanner scan = new Scanner(System.in);
    int option = 1;

    while (option >= 1 && option <= 5) {
      displayOptions();
      System.out.println("Enter an option (4 to exit): ");
      option = scan.nextInt();

      switch (option) {
        case 1:
          System.out.println("Faculty Members -----------------------------");
          for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Faculty)
              System.out.println(employees.get(i));
          }
          break;
        case 2:
          System.out.println("Staff Members -----------------------------");
          for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Staff) {
              System.out.println(employees.get(i));
            }
          }
          break;
        case 3:
          System.out.println("Sales Members -----------------------------");
          for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Sales) {
              System.out.println(employees.get(i));
            }
          }
          break;
        case 4:
          System.out.println("Exiting...");
          scan.close();
          System.exit(0);
        default:
          System.out.println("Invalid menu option. Enter a number 1 - 3.");
          break;
      }
    }

  }

  public static void displayOptions() {
    System.out.println("\nMenu -------------------------------------------- ");
    System.out.println("Select a type to view a list of employees (Enter a number): ");
    System.out.println("1 = Faculty");
    System.out.println("2 = Staff");
    System.out.println("3 = Sales");
    System.out.println("--------------------------------------------------- ");
  }

}