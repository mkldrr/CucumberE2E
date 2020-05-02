package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility {


    private static XSSFSheet excelWSheet;
    private static XSSFWorkbook excelWBook;
    private static XSSFCell cell;
    private static XSSFRow row;
    private static String excelFilePath;

    /**
     * This method is to set the File path and to open the Excel file, Pass
     * Excel Path and Sheetname as Arguments to this method
     *
     * @param path
     * @param sheetName
     */
    public static void openExcelFile(String path, String sheetName) {
        excelFilePath = path;
        try {
            File file = new File(path);
            FileInputStream ExcelFile = new FileInputStream(file);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println("Opening file catch");
        }
    }

    /**
     * This method is to read the test data from the Excel cell, in this we are
     * passing parameters as Row num and Col num
     *
     * @param rowNum
     * @param colNum
     * @return
     */
    public static String getCellData(int rowNum, int colNum) {
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            System.out.println("Non existing cell");
            return "";
        }
    }

    // This method is to write in the Excel cell, Row num and Col num are the
    // parameters
    public static void setCellData(String value, int rowNum, int colNum) {
        try {
            if (excelWSheet.getPhysicalNumberOfRows() < rowNum) {
                System.out.println("row creation");
                row = excelWSheet.createRow(rowNum);
            } else {
                row = excelWSheet.getRow(rowNum);
            }

            cell = row.getCell(colNum);


            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                //cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            excelWBook.write(fileOut);

            fileOut.close();

        } catch (Exception e) {
            System.out.println("Failed to write data");
        }
    }

    public static int getUsedRowsCount() {
        try {
            int rowCount = excelWSheet.getPhysicalNumberOfRows();
            return rowCount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }


    public static List<Map<String, String>> getDataList() {
        // get all columns
        List<String> columns = getColumnsNames();
        // this will be returned
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 0; i < rowCount(); i++) {
            // get each row
            Row row = excelWSheet.getRow(i);
            // create map of the row using the column and value
            // column map key, cell value --> map bvalue
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;

    }


    public static String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i <rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }


    //this method will return data table as 2d array
    //so we need this format because of data provider.
    public static String[][] getDataArrayWithoutFirstRow() {
        String[][] data = new String[rowCount()-1][columnCount()];

        for (int i = 1; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);  //   i(row) ==1  j (column)==0
                data[i-1][j] = value;
            }
        }
        return data;


    }



    public static List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : excelWSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }



    public static int columnCount() {
        return excelWSheet.getRow(0).getLastCellNum();
    }
    public static int rowCount() {
        return excelWSheet.getLastRowNum()+1;
    }
}
