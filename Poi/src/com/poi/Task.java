package com.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lanou.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年8月27日下午2:26:04
 **/
public class Task {

	public static void main(String[] args) throws IOException, SQLException {

		String sql = "select * from msg";
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		ResultSetMetaData data = rs.getMetaData();
		int columnCount = data.getColumnCount();
		String name[] = new String[columnCount];
		for (int i = 0; i <= columnCount-1; i++) {
			name[i] = data.getColumnName(i+1);
		}
		// 创建工作库
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("task");
		rs.last();
		int countRows = rs.getRow();
		rs.first();
		for (int i = 1; i <=countRows; i++) {
			if (i>=2) {
				rs.next();
			}
			// 创建行
			HSSFRow row = sheet.createRow(i-1);
			for (int j = 1; j <= columnCount; j++) {
				// 创建列
				HSSFCell cell = row.createCell(j-1);
				if (i == 1) {
					cell.setCellValue(name[j-1]);
				} else {
					if (j == 1) {
						cell.setCellValue(rs.getInt(j));
					} else {
						cell.setCellValue(rs.getString(j));
					}
				}

			}
		}

		// System.out.println(cell.getAddress());
		// // 向单元格添加值
		// cell.setCellValue("这是一个单元格");

		// 创建一个file
		String path = "/Users/xalo/Desktop/theFirstExcel.xls";
		// 获取输出流对象
		FileOutputStream out = new FileOutputStream(path);
		// 写入文件
		workbook.write(out);
		out.close();
	}

}
