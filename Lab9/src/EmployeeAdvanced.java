import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;

public class EmployeeAdvanced implements Externalizable {
    private String name;
    private int id;
    private double salary;
    private String department;
    private String password;

    public EmployeeAdvanced(){}  // create an empty object before calling readExternal()

    public EmployeeAdvanced(String name, int id, double salary, String department, String password) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
        this.password = password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(id);
        out.writeDouble(salary);
        out.writeObject(department);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        id = in.readInt();
        salary = in.readDouble();
        department = (String) in.readObject();
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
        return "EmployeeAdvanced | Name: " + name + " | ID: " + id + " | Salary: " + salary + " | Dept: " + department + " | Password: [not saved by Externalizable]";
    }
}