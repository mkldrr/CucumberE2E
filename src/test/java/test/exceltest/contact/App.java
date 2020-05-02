package test.exceltest.contact;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

        private static String [] columns= {"First Name", "Last Name", "Join Date", "Email Address", "Salary", "Batch Number"};

        private static List<Contact> teachers =  new ArrayList<>();



     public static void main(String[] args) throws IOException {


         teachers.add(new Contact("Lionel","Messi","10/12/2008","lionel.messi@gmail.com",123445,10));

         teachers.add(new Contact("Harry","Kane","10/12/2010","harry.kane@gmail.com",3454,10));
         Workbook workbook = new XSSFWorkbook();
         Sheet sheet = workbook.createSheet("Teachers");

         Font headerFont = workbook.createFont();
         headerFont.setBold(true);
         headerFont.setFontHeightInPoints((short) 12);
         headerFont.setColor(IndexedColors.LIGHT_BLUE.getIndex());

         CellStyle headerCellStyle = workbook.createCellStyle();

         headerCellStyle.setFont(headerFont);

         Row headerRow = sheet.createRow(0);

         for (int i = 0; i <columns.length ; i++) {

             Cell cell = headerRow.createCell(i);
             cell.setCellValue(columns[i]);
             cell.setCellStyle(headerCellStyle);

         }





         int rowNum= 1;
         int count =0;

         for (Contact teacher: teachers) {
            Row row = sheet.createRow(rowNum++);
             row.createCell(0).setCellValue(teacher.firstName);
             row.createCell(1).setCellValue(teacher.lastName);
             row.createCell(2).setCellValue(teacher.joinDate);
             row.createCell(3).setCellValue(teacher.emailAddress);
             row.createCell(4).setCellValue(teacher.salary);
             row.createCell(5).setCellValue(teacher.batch);

         }


         for (int i = 0; i <columns.length ; i++) {
             sheet.autoSizeColumn(i);
         }


         FileOutputStream fileOutputStream = new FileOutputStream("Contacts.xlsx");//it writing to excel
         workbook.write(fileOutputStream);

         fileOutputStream.close();
         workbook.close();

     }


}
