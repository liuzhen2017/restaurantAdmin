/**
 * 
 */
package com.ruoyi.system.po;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.ScoreHis;

/**
 * @author liuzhen
 *
 */

public class ReadUtil {
	
    
    private static final String SUFFIX_2003 = ".xls";
    private static final String SUFFIX_2007 = ".xlsx";
    public static List<ScoreHis> resolveExcel(MultipartFile file) throws BusinessException {
    	 
    	 
        List<ScoreHis> list = new ArrayList<>();
        if (file == null) {
            throw new BusinessException("对象不能为空");
        }
        //获取文件的名字
        String originalFilename = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            if (originalFilename.endsWith(SUFFIX_2003)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (originalFilename.endsWith(SUFFIX_2007)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException( "格式错误");
        }
        if (workbook == null) {
            throw new BusinessException("格式错误");
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            //遍历这个这些表
            for (int i = 0; i < numOfSheet; i++) {
                //获取一个sheet也就是一个工作簿
                Sheet sheet = workbook.getSheetAt(i);
                int lastRowNum = sheet.getLastRowNum();
                //从第一行开始第一行一般是标题
                ScoreHis score =null;
                for (int j = 1; j <= lastRowNum; j++) {
                    Row row = sheet.getRow(j);
                    score = new ScoreHis();
                    //获取电话单元格
                    if (row.getCell(0) != null) {
						DecimalFormat df = new DecimalFormat("0");
						String cellValue = df.format(row.getCell(0).getNumericCellValue());
                        score.setMembersId(-1);
                        score.setMembersName(cellValue);
                    }
                    //score
                    if (row.getCell(1) != null) {
                    	try {
                    		DecimalFormat df = new DecimalFormat("0");
    						String cellValue = df.format(row.getCell(1).getNumericCellValue());
                    		score.setNewScore(Integer.parseInt(cellValue));
                    		score.setOlbScore(0);
                    		score.setCreateBy("admin");
                    		score.setCreatedDate(new Date());
                    		score.setDescribes("導入積分");
						} catch (Exception e) {
							e.printStackTrace();
						}
                    }
                    list.add(score);
                }
            }
        }
        return list;
    }
    
	
	
}
