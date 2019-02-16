package com.sumi.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.sumi.bean.Employee;

/**
 *
 * @author SPF
 * @time 2018年9月4日上午9:55:58
 */
public class Sheet {
	public static void getSheet(List<Employee> employees,String name,String path){
		//列字段
		String[] columnName = {"工号", "姓名", "手机", "邮箱"};
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("abc");
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 5000);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		for (int i = 0; i < employees.size()+2; i++) {
			HSSFRow row = sheet.createRow(i);
			for (int j = 0; j < columnName.length; j++) {
				HSSFCell cell = row.createCell(j);
				if (i == 0) {
					if (j == 0) {
						cell.setCellValue(name);
					}
				} else if (i == 1) {
					cell.setCellValue(columnName[j]);
				}else {
					if (j == 0) {
						cell.setCellValue(employees.get(i-2).getJobnum());
					} else if (j == 1) {
						cell.setCellValue(employees.get(i-2).getUname());
					} else if (j == 2) {
						cell.setCellValue(employees.get(i-2).getPhone());
					} else {
						cell.setCellValue(employees.get(i-2).getEmail());
					}
				}
			}
		}
		// 创建一个File
		String file = path;
		// 获取一个输出流对象
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			// 写入文件
			workbook.write(out);
			// 关闭流
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
