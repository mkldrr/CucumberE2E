package pojo.teacher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Teacher {

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


}
