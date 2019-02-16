package sendEmailUtil;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 邮箱验证
 * 
 * @author LiuXu
 * @time2018年8月13日下午3:01:09
 **/
public class EmailUtil {

	public static void main(String[] args) {
		boolean sendEmail = sendEmail("liuxu043@qq.com", "12345");
		if (sendEmail) {
			System.out.println("发送成功");
		} else {
			System.out.println("发送失败");
		}
	}

	/**
	 * 
	 * @param to
	 *            接收邮件的账号
	 * @param code
	 *            需要发送的验证码
	 */
	public static boolean sendEmail(String to, String code) {
		// 创建一个邮件对象
		HtmlEmail email = new HtmlEmail();
		// 指定邮箱服务器地址
		email.setHostName("smtp.163.com");
		// 指定邮箱服务器账号和客户端授权码
		email.setAuthentication("liuxu043@163.com", "liuxu12345");
		// 统一设置邮件内容编码
		email.setCharset("UTF-8");
		// 设置发件人地址和名称
		try {
			email.setFrom("liuxu043@163.com", "小米科技");
			// 设置收件人地址
			email.addTo(to);
			// 设置标题
			email.setSubject("来自神秘东方的邮件");
			// 设置邮件内容
			email.setMsg("<h1 style='color:red'>恭喜您被选为神秘东方的接班人，验证码：" + code + "</h1>");
			// 发送邮件
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}

	}
}
