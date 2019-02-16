package com.lanou;

import java.util.Scanner;

/**
 *
 * @author LiuXu
 * @time2018年6月7日下午2:41:43
 **/
public class myMain {

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		System.out.println("***********欢迎进入学生管理系统***********");
		boolean is = false;
		do {
			System.out.println("请选择你需要办的业务:1--添加 2--删除 3--查询 4--添加成绩 5--删除学生成绩 6--班级划分 7--查询班级 8--退出");
			Scanner sc = new Scanner(System.in);
			// 实例化学生接口实现类
			ImplStu implStu = new ImplStu();
			// 实例化成绩接口实现类
			ImplSS implSS = new ImplSS();
			// 获取用户输入的内容
			int n = sc.nextInt();
			switch (n) {
			case 1:
				// 添加学生
				System.out.println("请输入学号:");
				int id = sc.nextInt();
				System.out.println("请输入姓名:");
				String name = sc.next();
				System.out.println("请输入性别:");
				String sex = sc.next();
				System.out.println("请输入年龄:");
				int age = sc.nextInt();
				implStu.addStudent(new Student(id, name, sex, age));
				implStu.showList();
				break;
			case 2:
				// 删除学生
				System.out.println("请输入学号:");
				int id1 = sc.nextInt();
				implStu.deleteStudent(id1);
				implStu.showList();
				break;
			case 3:
				// 查找某位学生
				System.out.println("请输入学号:");
				int id2 = sc.nextInt();
				implStu.searchStudent(id2);
				break;
			case 4:
				// 为指定学生初始化成绩
				System.out.println("请输入学号:");
				int id4 = sc.nextInt();
				implSS.addSS(id4);
				implSS.showScore(id4);
				break;
			case 5:
				// 删除学生指定学科成绩
				System.out.println("请输入学号:");
				int id3 = sc.nextInt();
				System.out.println("请输入要删除的科目:");
				String subject1 = sc.next();
				implSS.removeSS(id3, subject1);
				implSS.showScore(id3);
				break;
			case 6:
				// 划分班级
				System.out.println("请输入你需要添加的班级号:");
				int c = sc.nextInt();
				implStu.addStoClass(c);
				break;
			case 7:
				System.out.println("请输入你需要查询的班级号:");
				int s = sc.nextInt();
				// 获取某一班级的学生
				implStu.showClass(s);
				break;
			case 8:
				int i = 3;
				while (i > 0) {
					try {
						System.out.println(i + "秒后退出...");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					i--;
				}
				is = true;
				break;
			default:
				System.out.println("输入有误，重新输入");
				break;
			}
		} while (!is);
	}

}
