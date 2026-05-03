import java.io.Serializable;  // allows object to be saved/loaded as bytes

public class EmployeeBasic implements Serializable {

    private static final long serialVersionUID = 1L; //serialization version control

    private String name;
    private int id;
    private double salary;
    private String department;  // save above files when serialized

    private transient String password;

    //creates employeeBasic
    public EmployeeBasic(String name, int id, double salary, String department, String password) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
        this.password = password; // will not be saved when serialized
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public double getSalary(){
        return salary;
    }
    public String getDepartment(){
        return department;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "EmployeeBasic | Name: " + name + " | ID: " + id + " | Salary: " + salary + " | Dept: " + department + " | Password: " + (password == null ? "[hidden after load]" : password);
    }
}