package com.sungrow.wind.global.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 0:09
 */
@Slf4j
public class ExcelFileReader implements FileReader {

    private FileInfo fileInfo;

    private Map<String, Integer> map;


    @Override
    public List<Map<String, String>> read(InputStream inputStream, FileInfo fileInfo) {
        List<Map<String, String>> list = new ArrayList<>();
        try {
            // 创建excel工作簿
            Workbook work = getWorkbook(inputStream, fileInfo.getFileName());
            if (null == work) {
                throw new RuntimeException("创建Excel工作薄为空！");
            }
            Sheet sheet = work.getSheetAt(0);

            //读表头
            //列号与HeadName映射关系。
            Map<Integer, String> headNameMapCellNum = new HashMap<>();
            this.map = headNameMapCellNum.entrySet().stream().collect(Collectors.toMap(
                    e->e.getValue(), e->e.getKey(), (k1,k2)->k2));

            Row headRow = sheet.getRow(fileInfo.getHeadRowIndex());
            for (int y = headRow.getFirstCellNum(); y < headRow.getLastCellNum(); y++) {
                Cell cell = headRow.getCell(y);
                headNameMapCellNum.put(y, cell.getStringCellValue());
            }

            //读正文
            for (int j = fileInfo.getContentStartIndex(); j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                if (row == null) {
                    continue;
                }
                Map<String, String> rowMap = new HashMap<>();
                //int emptyCnt = 0;
                for (int y = headRow.getFirstCellNum(); y < headRow.getLastCellNum(); y++) {
                    Cell cell = row.getCell(y);
                    if(cell != null) {
                        cell.setCellType(CellType.STRING);
                        rowMap.put(headNameMapCellNum.get(y), cell.getStringCellValue());
                       /* if(CellType.NUMERIC == cell.getCellTypeEnum()) {
                            cell.setCellType(CellType.STRING);
                            rowMap.put(headNameMapCellNum.get(y), cell.getStringCellValue());
                            //log.info("cell.getNumericCellValue()====>>>>>>>>>>>>>>>>>>>{}", cell.getNumericCellValue());
                            //log.info("cell.getNumericCellValue()====>>>>>>>>>>>>>>>>>>>{}", BigDecimal.valueOf(cell.getNumericCellValue()).toString());
                            //rowMap.put(headNameMapCellNum.get(y), BigDecimal.valueOf(cell.getNumericCellValue()).toString());
                        } else {
                            cell.setCellType(CellType.STRING);
                            rowMap.put(headNameMapCellNum.get(y), cell.getStringCellValue());
                        }*/

                    }
                }
                list.add(rowMap);
            }

        } catch (Exception e) {
            log.error("读取[" + fileInfo.getFileName() + "]失败。" , e);
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                }catch (Exception e) {
                    log.error("释放流[" + fileInfo.getFileName() + "]失败。" , e);
                }

            }

        }

        return list;
    }



    private static Workbook getWorkbook(InputStream in, String fileName) throws Exception {

        Workbook book = null;
        String filetype = fileName.substring(fileName.lastIndexOf("."));

        if (".xls".equalsIgnoreCase(filetype)) {
            book = new HSSFWorkbook(in);
        } else if (".xlsx".equalsIgnoreCase(filetype)) {
            book = new XSSFWorkbook(in);
        } else {
            throw new Exception("请上传excel文件！");
        }

        return book;
    }


}
