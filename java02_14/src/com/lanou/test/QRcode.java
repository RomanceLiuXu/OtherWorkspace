package com.lanou.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 生成二维码
 * 
 * @author LiuXu
 * @time2018年8月13日下午2:11:59
 **/
public class QRcode {

	public static void main(String[] args) {
		// 二维码大小
		int width = 300;
		int heigh = 300;
		// 二维码图片格式
		String format = "png";
		// 二维码的内容
		String content = "你好";
		// 设定二维码参数
		HashMap<EncodeHintType, Object> map = new HashMap<>();
		// 设定字符集格式
		map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 设置容错等级
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 设置边距
		map.put(EncodeHintType.MARGIN, 2);
		// 生成MultiFormatWriter对象
		MultiFormatWriter writer = new MultiFormatWriter();
		try {
			BitMatrix encode = writer.encode(content, BarcodeFormat.QR_CODE, width, heigh, map);
			// 保存路径
			File file = new File("/Users/xalo/Desktop/marry/aa.png");
			Path path = file.toPath();
			MatrixToImageWriter.writeToPath(encode, format, path);
		} catch (WriterException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
