package test.exceltest.school;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import pojo.RequestBody;
import test.LocalDateTest;
import utilities.APIUtility;
import utilities.ExcelUtility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class School {




   static String [] columns= {"firstName","lastName","joinDate","emailAddress",
            "salary","batch","gender", "phone","subject","section","birthDate","department",
            "password","premanentAddress"  };

   static   List <Teacher> teachers = new ArrayList<>();


 @Test
    public  void createTeacherOnExcel() throws IOException {

        Faker faker = new Faker();

        Random random = new Random();

        for (int i = 0; i <20 ; i++) {

            String firstName = faker.name().firstName();
            String lastName= faker.name().lastName();

            teachers.add(new Teacher(firstName,lastName, LocalDateTest.createRandomDate(),
                    firstName.toLowerCase() + "."+ lastName.toLowerCase() + "@gmail.com",
                    random.nextInt(100000),random.nextInt(15), "Male",
                    faker.phoneNumber().cellPhone(),faker.job().field().trim(),faker.job().position().trim(),
                    LocalDateTest.createRandomDate(),
                    faker.job().field(),String.valueOf(faker.number().randomNumber()),faker.address().fullAddress().trim()));
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Teachers");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 15);
        headerFont.setColor(IndexedColors.LIGHT_BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();

        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i <columns.length ; i++) {

            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);

        }
        int rowNum=1;
//     for (int i = 0; i <16 ; i++) {
//         Row row = sheet.createRow(rowNum++);
//         if (i==0){
//             row.createCell(i).setCellValue("Numbers");
//
//         }else{
//             row.createCell(0).setCellValue(i);
//         }
//     }

        for (Teacher teacher : teachers) {
            Row row = sheet.createRow(rowNum++);

          //  row.createCell(1).setCellValue(rowNum);
            row.createCell(0).setCellValue(teacher.firstName);
            row.createCell(1).setCellValue(teacher.lastName);
            row.createCell(2).setCellValue(teacher.joinDate);
            row.createCell(3).setCellValue(teacher.emailAddress);
            row.createCell(4).setCellValue(teacher.salary);
            row.createCell(5).setCellValue(teacher.batch);
            row.createCell(6).setCellValue(teacher.gender);
            row.createCell(7).setCellValue(teacher.phone);
            row.createCell(8).setCellValue(teacher.subject);
            row.createCell(9).setCellValue(teacher.section);
            row.createCell(10).setCellValue(teacher.birthDate);
            row.createCell(11).setCellValue(teacher.department);
            row.createCell(12).setCellValue(teacher.password);
            row.createCell(13).setCellValue(teacher.premanentAddress);

        }


        for (int i = 0; i <columns.length ; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("Teachers.xlsx");//it writing to excel
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();



    }


    @Test
    public void apiPostFromExcel(){
        ExcelUtility.openExcelFile("Teachers.xlsx","Teachers");
        RequestBody requestBody = new RequestBody();

       // String[][] dataArrayWithoutFirstRow = ExcelUtility.getDataArrayWithoutFirstRow();
        int count =0;
        for (int i = 0; i <ExcelUtility.rowCount()-1 ; i++) {
            for (int j = 0; j < ExcelUtility.columnCount(); j++) {
                int count2=0;
                requestBody.setFirstName(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]); //wanne
                requestBody.setLastName(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]); //Beer
                requestBody.setJoinDate(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]); //12/20/1996
                requestBody.setEmailAddress(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]); //wayne.beer@gmail.com
                requestBody.setSalary(Integer.parseInt(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++].substring(0, ExcelUtility.getDataArrayWithoutFirstRow()[count][count2].length() - 2)));
                requestBody.setBatch(Integer.parseInt(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++].substring(0, ExcelUtility.getDataArrayWithoutFirstRow()[count][count2].length() - 3)));
                requestBody.setGender(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]);
                requestBody.setPhone(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++].replace("-", ""));
                requestBody.setSubject(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]); //count = 1
                requestBody.setSection(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]);
                requestBody.setBirthDate(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]);
                requestBody.setDepartment(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]);
                requestBody.setPassword(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]); //count = 1
                requestBody.setPremanentAddress(ExcelUtility.getDataArrayWithoutFirstRow()[count][count2++]);  //
            }
            count++;
            APIUtility.hitPOST("/teacher/create", requestBody);
        }
    }








    @Test
    public void getCellTest(){

        ExcelUtility.openExcelFile("Teachers.xlsx","Teachers");


        System.out.println("joinDate:  "+ ExcelUtility.getCellData(0,2));

        System.out.println("Used  rows count: "+ ExcelUtility.getUsedRowsCount());

        System.out.println("Column count: "+ ExcelUtility.columnCount());

        System.out.println("Row Count: "+ExcelUtility.rowCount());

       // System.out.println("\n"+ExcelUtility.getDataList());

       //System.out.println(Arrays.deepToString(ExcelUtility.getDataArray()));

      // System.out.println(ExcelUtility.getColumnsNames());




       // System.out.println(ExcelUtility.getCellData(12,3));


      // System.out.println(Arrays.deepToString(ExcelUtility.getDataArrayWithoutFirstRow()));



     //   System.out.println(Arrays.deepToString(ExcelUtility.getDataArray()));

        System.out.println(ExcelUtility.getDataList());









    }













}
