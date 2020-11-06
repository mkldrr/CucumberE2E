package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import pojo.student.Company;
import pojo.student.Contact;
import pojo.student.Student;
import pojo.teacher.Teacher;
import pojo.users.Avatar;
import pojo.users.Edit;
import pojo.users.Self;
import pojo.users.Users;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBody {


    List<Student> students;
    List<Teacher> teachers;
    String message;


    private String firstName;
    private String lastName;
    private String joinDate;
    private String emailAddress;
    private int salary;
    private int batch;
    private String gender;
    private String phone;
    private String subject;
    private String section;
    private String birthDate;
    private String department;
    private String password;
    private String premanentAddress;

    private int teacherId;



    private String major;
    private String admissionNo;
    private Contact contact;
    private Company company;

    private int studentId;



    List<Users> users;
    private String id;

    private String first_name;
    private String last_name;
   // private String gender;

    private String dob;
    private String email;
    private String website;
    private String address;
    private String status;


    private Avatar avatar;
    private Edit edit;
    private Self self;


}
