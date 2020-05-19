package test;

import com.github.javafaker.Faker;
import cucumber.api.java.sl.In;

import java.util.*;

public class Employee {


    //TODO : There are list employees with id, salary and their names. How to sort them



    private String name;
    private int salary;
    private int id;

    public Employee(int id, String name, int salary) {

        this.name= name;
        this.salary=salary;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static void fillingTheListOfEmployees(ArrayList<Employee> list, int n){
        Faker faker = new Faker();
        String name;
        int randomId=0;
        int uniqueID=0;
        Random random = new Random();
        HashMap<Integer,Integer> mapId = new HashMap<>();
        int salary;
        for (int i=0; i<n; i++){
           randomId = random.nextInt(10);
           if (!mapId.containsValue(randomId)){

               mapId.put(i,randomId);
           }else{
               mapId.put(i,random.nextInt(10));
           }

            name = faker.name().firstName();
            salary = faker.number().numberBetween(1,20000);
            Employee employee = new Employee(mapId.get(i),name, salary);
            list.add(employee);
        }
    }


    @Override
    public String toString(){
        return "\n"+ "ID: "+ this.id + " Name: "+  this.getName() + " Salary: " + this.getSalary();
    }




    public static void main(String[] args) {


        ArrayList<Employee> allEmployees = new ArrayList<>();

        fillingTheListOfEmployees(allEmployees, 10);
        System.out.println(allEmployees);

        Comparator<Employee> byName = Comparator.comparing(Employee::getName);
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
        Collections.sort(allEmployees,byName.reversed());
        Collections.sort(allEmployees, byName.thenComparing(bySalary));
        System.out.println(allEmployees);
        System.out.println(byName);


    }



}
