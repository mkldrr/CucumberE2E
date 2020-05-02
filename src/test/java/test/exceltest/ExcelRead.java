package test.exceltest;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class ExcelRead {

    public static void main(String[] args) throws IOException {

     //  1. //create File and give a Path.
        File file = new File("src/SCHEDULE.xlsx");
        //System.out.println(file.exists());
     //   2. //Load the File into Java Memory using FileInputStream

        FileInputStream fileInputStream = new FileInputStream(file);

     //   3. //Load the work book into the java class.

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//Steps: //  WorkBook > sheet > row > cell

     //   4. //Getting the sheet from the workbook

        XSSFSheet sheet = workbook.getSheet("Schedule");

     //How to get "break" from row 10

     //   5. //Getting the row from the sheet
        // 6. // getting the cell from row

        System.out.println(sheet.getRow(9).getCell(5));

        // getPhysicalNumber : it will return only used rows count
        int numOfRows= sheet.getPhysicalNumberOfRows();
        System.out.println("total number of Rows: "+numOfRows);

        int lastUsedRow= sheet.getLastRowNum();
        System.out.println("last number of used row "+lastUsedRow);


        //TODO : create a logic that prints conclusion from the cell

//        for (int i=0; i<numOfRows; i++){
//
//            if (sheet.getRow(i).getCell(0).toString().equals("10:00 AM--11:00AM")){
//                System.out.println("'Kani' Dynamically found:  "+sheet.getRow(i).getCell(0).toString());
//            }
//        }

      //  TODO : create a logic that print what is happening in the schedule during 5:00-7:00 PM

        for (int i=0; i<numOfRows;i++){

            if (sheet.getRow(i).getCell(1).toString().equals("DINNER")){
                System.out.println("Cell is found as:  "+ sheet.getRow(i).getCell(2));
            }

        }


    }



    @Test

    public void countTest(){

        int count =0;

        System.out.println(count);


    }





}
