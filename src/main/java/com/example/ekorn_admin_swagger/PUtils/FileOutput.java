package com.example.ekorn_admin_swagger.PUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FileOutput {

    public InputStream file;
    public XSSFWorkbook xssfWorkbook;
    public XSSFSheet xssfSheet;

    public FileOutput(String formPath, HttpServletRequest request) throws IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String path = request.getServletContext().getRealPath(formPath);
            file =  new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(file);
            xssfSheet = xssfWorkbook.getSheetAt(0);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 엑셀 양식 다운로드
     * */
    public void makeFile(HttpServletResponse response, XSSFSheet sheet, String fileName) throws IOException {
        fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+","%20");
        response.setContentType("application/vsd.ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
        xssfWorkbook.write(response.getOutputStream());
        System.out.println(sheet);

        //close 없이 자동 해제
    }


    /**
     * poi 엑셀 스타일
     * */
    public void excelStyle(XSSFWorkbook workbook, Row row, int[] cellNum){
       //셀 스타일 및 트 설정
       CellStyle  style= workbook.createCellStyle();
       style.setWrapText(true);
       //가운데 정렬
       style.setVerticalAlignment(VerticalAlignment.CENTER);

       for(int n:cellNum){
           row.getCell(n).setCellStyle(style);
       }
    }









}
