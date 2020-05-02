package test.exceltest.contact;

public class Contact {

    public String firstName, lastName,  joinDate, emailAddress;
    int salary, batch;

//    private String gender,
//    private String phone,
//    private String subject,
//    private String section,
//    private String birthDate,
//    private String department,
//    private String password,
//    private String premanentAddress,
//    private int teacherId,

    public Contact(String firstName, String lastName, String joinDate, String emailAddress, int salary, int batch){

        this.firstName=firstName;
        this.lastName=lastName;
        this.joinDate=joinDate;
        this.emailAddress=emailAddress;
        this.salary=salary;
        this.batch=batch;

    }



}
