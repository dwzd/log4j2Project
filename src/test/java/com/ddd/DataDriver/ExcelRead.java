package com.ddd.DataDriver;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelRead {
    public static void main(String[] args) {
        //调用pui 里面的类 ,分别读取excel 的文件，sheet， cell, 分别声明这三个类型的变量
        XSSFWorkbook excelWorkBook;
        XSSFSheet excelWorkSheet;
        XSSFCell excelWorkCell;

        String path = "D:\\Java\\log4jProj\\src\\test\\utilities\\ExcelRead.xlsx";
        String sheetName = "Sheet1";
        //调用文件流的类
        try {
            FileInputStream excelFile = new FileInputStream(path);
            //初始化这三个对象
            excelWorkBook = new XSSFWorkbook(excelFile);
            excelWorkSheet = excelWorkBook.getSheet(sheetName);
            excelWorkCell = excelWorkSheet.getRow(0).getCell(0);
            String cellData = excelWorkCell.getStringCellValue();
            System.out.println("The cell data: " + cellData);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
