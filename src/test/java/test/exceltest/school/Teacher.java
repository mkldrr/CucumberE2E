package test.exceltest.school;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Teacher {


    public String firstName;
    public String lastName;
    public String joinDate;
    public String emailAddress;
    public int salary;
    public int batch;
    public String gender;
    public String phone;
    public String subject;
    public String section;
    public String birthDate;
    public String department;
    public String password;
    public String premanentAddress;



   //private int teacherId;


    public Teacher(String firstName, String lastName, String joinDate, String emailAddress,
                   int salary, int batch, String gender, String phone, String subject,
                   String section, String birthDate, String department, String password, String premanentAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = joinDate;
        this.emailAddress = emailAddress;
        this.salary = salary;
        this.batch = batch;
        this.gender = gender;
        this.phone = phone;
        this.subject = subject;
        this.section = section;
        this.birthDate = birthDate;
        this.department = department;
        this.password = password;
        this.premanentAddress = premanentAddress;
    }


//    public static void main(String[] args) {
//
//        List<Teacher> listOfTeacher = new ArrayList<>();
//        fillTheListOfTeacher(listOfTeacher,10);
//
//    }
//
//
//    public static void fillTheListOfTeacher(List<Teacher> teachers, int numberOfTeachers){
//
//
//        Faker faker = new Faker();
//
//        Random random = new Random();
//
//
//        List<Teacher> listOfTeacher = new ArrayList<>();
//
//
//
//        for (int i = 0; i <numberOfTeachers ; i++) {
//
//            String firstName = faker.name().firstName();
//            String lastName= faker.name().lastName();
//
//
//            listOfTeacher.add(new Teacher(firstName,lastName,
//                    faker.date().birthday().toString(),
//                    firstName + "."+ lastName + "@gmail.com",
//                    random.nextInt(100000),random.nextInt(15), "Male",
//                    faker.phoneNumber().cellPhone(),faker.job().field().trim(),faker.job().position().trim(),
//                    faker.date().birthday().toString(),
//                    faker.job().field(),String.valueOf(faker.number().randomNumber()),faker.address().fullAddress().trim()));
//        }






        //return listOfTeacher;



//
//    }
//
//
//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", joinDate='" + joinDate + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", salary=" + salary +
//                ", batch=" + batch +
//                ", gender='" + gender + '\'' +
//                ", phone='" + phone + '\'' +
//                ", subject='" + subject + '\'' +
//                ", section='" + section + '\'' +
//                ", birthDate='" + birthDate + '\'' +
//                ", department='" + department + '\'' +
//                ", password='" + password + '\'' +
//                ", premanentAddress='" + premanentAddress + '\'' +
//                '}';
//    }
}
