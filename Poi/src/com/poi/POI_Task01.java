package com.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
*
*@author wy
*@time 2018年8月24日下午7:47:00
**/
public class POI_Task01 {

	public static void main(String[] args) throws IOException {
	
		//======================创建单元格内容=======================
		//文件路径
		String ExclePath = "/Users/xalo/Desktop/TheFirstExcel.xls";
		//创建Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = workbook.createSheet();
		//创建工作表
		sheet = workbook.createSheet("Test");
		//创建行
		HSSFRow row = sheet.createRow(0);
		//创建行的单元格
		HSSFCell cell = row.createCell(0);
		
		
		//====================设置单元格内容==============================
		//设置单元格的内容(String)
		cell.setCellValue("单元格,位置X:01,Y:01");
		//设置单元格的内容(Boolean)
		row.createCell(1).setCellValue(true);
		//设置单元格的内容(Date)
		row.createCell(2).setCellValue(new Date());
		//设置单元格的内容(Calendar)
		row.createCell(3).setCellValue(Calendar.getInstance());
		
		
		//=========================设置文档摘要信息=======================
		//创建文档摘要信息	
		workbook.createInformationProperties();
		//文档摘要信息
		DocumentSummaryInformation information = workbook.getDocumentSummaryInformation();
		//类别
		information.setCategory("类别:Excel文件");
		//管理者
		information.setManager("管理者:王一");
		//公司
		information.setCompany("公司:蓝鸥科技");
		//摘要信息
		SummaryInformation si = workbook.getSummaryInformation();
		//主题
		si.setSubject("主题:JavaPOI测试");
		//标题
		si.setTitle("标题:测试文档");
		//作者
		si.setAuthor("作者:王一");
		//备注
		si.setComments("备注:这是备注");
		
		
		//=============================创建批注==============================
		HSSFPatriarch part = sheet.createDrawingPatriarch();
		//确定批注生成的位置
		HSSFClientAnchor anchor = part.createAnchor(0, 0, 0, 0, 5, 10, 8, 3);
		/**
		 * 	标注位置设置参数：
		 	dx1         第1个单元格中x轴的偏移量
			dy1         第1个单元格中y轴的偏移量
			dx2         第2个单元格中x轴的偏移量
			dy2         第2个单元格中y轴的偏移量
			col1        第1个单元格的列号
			row1        第1个单元格的行号
			col2        第2个单元格的列号
			row2        第2个单元格的行号
		 * 
		 */
		
		//创建批注
		HSSFComment comment = part.createCellComment(anchor);
		//设置批注内容
		comment.setString(new HSSFRichTextString("这是一个段落批注"));
		//设置批注作者
		comment.setAuthor("王一");
		//设置批注默认显示
		comment.setVisible(false);
		//将批注加到单元格上(如若不指定将添加在第一个上面)
		row.createCell(9).setCellComment(comment);
		
		//================创建页眉和页脚=============
		//获取页眉对象
		HSSFHeader header = sheet.getHeader();
		header.setLeft("页眉左");
		header.setCenter("页眉中");
		header.setRight("页眉右");
		//获取页脚对象
		HSSFFooter footer = sheet.getFooter();
		footer.setLeft("页脚左");
		footer.setCenter("页脚中");
		footer.setRight("页脚右");
		
		//=====================设置单元格显示格式=================
			//获取样式对象
			HSSFCellStyle style = workbook.createCellStyle();
			//设置日期样式(使用的是excel内嵌的样式)
			style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
			//设置小数样式(使用的是excel内嵌的样式)
			style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
			//设置货币格式(自定义格式)
			style.setDataFormat(workbook.createDataFormat().getFormat("￥#,##0"));
			//设置百分比格式
			style.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
			//将设置好的样式添加进单元格
//			cell.setCellStyle(style);
			/*
			 * HSSFDataFormat.getFormat和HSSFDataFormat.getBuiltinFormat的区别：当使用Excel内嵌的（或者说预定义）的格式时，
			 * 直接用HSSFDataFormat.getBuiltinFormat静态方法即可。当使用自己定义的格式时，必须先调用HSSFWorkbook.createDataFormat()，
			 * 因为这时在底层会先找有没有匹配的内嵌FormatRecord，如果没有就会新建一个FormatRecord，所以必须先调用这个方法，
			 * 然后你就可以用获得的HSSFDataFormat实例的getFormat方法了，当然相对而言这种方式比较麻烦，
			 * 所以内嵌格式还是用HSSFDataFormat.getBuiltinFormat静态方法更加直接一些。
			 */
			
		//======================设置合并单元格========================
			//合并列(横向)
			CellRangeAddress rangeAddress = new CellRangeAddress(0,0,0,5);
			sheet.addMergedRegion(rangeAddress);
			
			//合并行(竖向)
			CellRangeAddress rangeAddress2 = new CellRangeAddress(0,5,6,6);
			sheet.addMergedRegion(rangeAddress2);
			
			/*	CellRangeAddress参数：
			    firstRow        区域中第一个单元格的行号
				lastRow         区域中最后一个单元格的行号
				firstCol        区域中第一个单元格的列号
				lastCol         区域中最后一个单元格的列号
			 */
			
			//=================设置单个单元格格式=====================
			//获取style对象
			HSSFCellStyle style2 = workbook.createCellStyle();
			//水平居中
			style2.setAlignment(HorizontalAlignment.CENTER);
			//垂直居中
			style2.setVerticalAlignment(VerticalAlignment.CENTER);
			//自动换行
			style2.setWrapText(true);
			//缩进
			style2.setIndention((short)5);
			//文本旋转
			style2.setRotation((short)60);
			//给单元格添加属性
			cell.setCellStyle(style2);
			/*
			 * 这是老版本的但可以参考常量名
			水平对齐相关参数(HorizontalAlignment)
				如果是左侧对齐就是   HSSFCellStyle.ALIGN_FILL;
				如果是居中对齐就是   HSSFCellStyle.ALIGN_CENTER;
				如果是右侧对齐就是   HSSFCellStyle.ALIGN_RIGHT;
				如果是跨列举中就是   HSSFCellStyle.ALIGN_CENTER_SELECTION;
				如果是两端对齐就是   HSSFCellStyle.ALIGN_JUSTIFY;
				如果是填充就是       HSSFCellStyle.ALIGN_FILL;    
    			垂直对齐相关参数(VerticalAlignment)
				如果是靠上就是     HSSFCellStyle.VERTICAL_TOP;
				如果是居中就是     HSSFCellStyle.VERTICAL_CENTER;
				如果是靠下就是     HSSFCellStyle.VERTICAL_BOTTOM;
				如果是两端对齐就是  HSSFCellStyle.VERTICAL_JUSTIFY;
			 */
			//======================================================
			
			
			
			
			
			
			
			
		//=========================生成表=================================
		//获取输出流对象
		FileOutputStream out = new FileOutputStream(ExclePath);
		//写入表格对象
		workbook.write(out);
		//关闭流
		out.close();
		System.out.println("完成");
		
		
	}
}
