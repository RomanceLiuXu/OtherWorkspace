package com.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lanou.util.SQLUtil2;



/**
 *
 * @author wy
 * @time 2018年8月25日下午8:39:15
 **/
public class POI_Task02 {

	public static void main(String[] args) throws SQLException, IOException {
		// 获取数据库中的数据
		String sql = "select * from msg";
		// 通过工具类获取数据
		ResultSet resultSet = SQLUtil2.queryMethod(sql, null);
		ResultSetMetaData metaData = resultSet.getMetaData();
		// 获取列数
		int columnCount = metaData.getColumnCount();
		// 获取列名
		String name[] = new String[columnCount];
		// 获取列的类型
		String type[] = new String[columnCount];
		for (int i = 0; i < columnCount; i++) {
			name[i] = metaData.getColumnName(i + 1);
			type[i] = metaData.getColumnTypeName(i + 1);
		}
		// 获取总行数
		resultSet.last();
		int countRows = resultSet.getRow();
		resultSet.first();
		// 创建表
		// 文件路径
		String ExclePath = "/Users/xalo/Desktop/TheFirstExcel.xls";
		// 创建Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建工作表
		HSSFSheet sheet = workbook.createSheet("the student message");

		// 创建单元格表头

		// 向表单中写入内容
		for (int i = 0; i <= countRows ; i++) {
			//创建行
			 HSSFRow row = sheet.createRow(i);
			 if(i>=2){
				 System.out.println("游标下移");
				 resultSet.next();
			 }
			for (int j = 0; j <= columnCount - 1; j++) {
				System.out.println("单元格坐标:x==" + i + "||y==" + j);
				HSSFCell cell = row.createCell(j);
				if (i == 0) {
					//打印表头信息
					cell.setCellValue(name[j]);
					System.out.println("打印表头" + name[j]);
				} else {
					System.out.println("列名" + name[j]+"|| "+j);
					if (j == 0) {
						//打印ID(int 类型数据)
						cell.setCellValue(resultSet.getInt(j+1));
						System.out.println("id= " + resultSet.getInt(j+1));
					} else {
						//打印其他信息
						cell.setCellValue(resultSet.getString(j+1));
						System.out.println(j + "格内容等于==" + resultSet.getString(j+1));
					}
				}
			}
			System.out.println("==============行数" + (i+1) + "=============");
		}

		// 获取输出流对象
		FileOutputStream out = new FileOutputStream(ExclePath);
		// 写入文件
		workbook.write(out);
		out.flush();
		// 关闭流
		// out.close();
	}

}
