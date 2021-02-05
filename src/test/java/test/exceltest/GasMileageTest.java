package test.exceltest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.excel_pages.GasMileageCalculatorPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class GasMileageTest {


    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    @Test
    public void gasMileageCalculatorTest() throws IOException {
        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
        String path = "./src/test/resources/testdata/GasMileageTestData.xlsx";
        //loading the workbook to class
        fileInputStream = new FileInputStream(path);
        //loading the workbook to class
        workbook = new XSSFWorkbook(fileInputStream);
        //now we gonna read from excel file
        sheet = workbook.getSheet("Sheet1");
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            XSSFRow currentRow = sheet.getRow(rowNum);
            //last step
            if (!currentRow.getCell(0).toString().equals("Y")) {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.createCell(6).setCellValue("Skip Requested!");
                continue;
            }
            //double current=123000;
            double current = currentRow.getCell(1).getNumericCellValue();//this method will convert into double
           // SeleniumUtils.waitFor(3);
            gasMileageCalculatorPage.curentOdo.clear();
            gasMileageCalculatorPage.curentOdo.sendKeys(String.valueOf(current));
            //double previous=122000;
            double previous = currentRow.getCell(2).getNumericCellValue();
            gasMileageCalculatorPage.previousOdo.clear();
            gasMileageCalculatorPage.previousOdo.sendKeys(String.valueOf(previous));
            //double gas=70;
            double gas = currentRow.getCell(3).getNumericCellValue();
            gasMileageCalculatorPage.gasInput.clear();
            gasMileageCalculatorPage.gasInput.sendKeys(String.valueOf(gas));
            gasMileageCalculatorPage.calculateButton.click();
            double expectedResult = (current - previous) / gas;
            System.out.println("Expected result : " + expectedResult);
            //14.29 mpg
            String[] actualResult = gasMileageCalculatorPage.resultInGas.getText().split(" ");


            System.out.println("Actual result : " + actualResult[0]);
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");//
            System.out.println("Formatted version : " + decimalFormat.format(expectedResult));
            //if cell is empty we cannot send something directly before the creating the cell
            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }
            //here we are sending the Expected Value from our formula
            currentRow.getCell(4).setCellValue(decimalFormat.format(expectedResult));//it is sending expected result
            ///===============================================================================
            //sending the Actual RESULT That we get from APP
            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }
            currentRow.getCell(5).setCellValue(actualResult[0]);
            //==================================================================================
            //checking and comparing actual vs expected,and printing values
            if (String.valueOf(decimalFormat.format(expectedResult)).equals(actualResult[0])) {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("PASS!");
                System.out.println("Pass!");
            } else {
                currentRow.getCell(6).setCellValue("FAIL!");
                System.out.println("Fail!");
            }
            //========================================================================
            //getting localdateTime and Passing into EXCEL
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }
            currentRow.getCell(7).setCellValue(LocalDate.now().toString());
        }//closing loop
        //the rows dynamic
        //========================================================================
        fileOutputStream = new FileOutputStream(path);//it writing to excel
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();


    }









}
