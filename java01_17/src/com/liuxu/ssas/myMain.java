package com.liuxu.ssas;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LiuXu
 * @time2018年6月10日下午2:09:33
 **/
public class myMain {

	public static void main(String[] args) {
		System.out.println("***********欢迎进入学生管理系统***********");
		boolean is = false;
		StudentE se = new StudentE();
		ScoreE ae = new ScoreE();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("业务编号为:1--添加 2--删除 3--添加学生成绩 4--删除学生成绩 5--查询学生 6--查询所有成绩 7--班级划分 8--查询班级 0--退出");
			System.out.println("请选择你需要办的业务:");
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
				boolean a = se.addStudent(new Student(id, name, sex, age));
				if (a) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}
				break;
			case 2:
				// 添加学生
				System.out.println("请输入要删除的学号:");
				int rId = sc.nextInt();
				boolean b = se.removeStudent(rId);
				if (b) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败");
				}

				break;
			case 3:
				// 添加学生成绩
				System.out.println("请输入id:");
				int sID = sc.nextInt();
				System.out.println("请输入学科名称:");
				String subjectName = sc.next();
				System.out.println("请输入成绩:");
				double subjectScore = sc.nextDouble();
				boolean c = ae.addScore(new AScoreE(subjectName, subjectScore, sID));
				if (c) {
					System.out.println("添加成绩成功");
				} else {
					System.out.println("添加失败");
				}
				break;
			case 4:
				System.out.println("请输入id:");
				int sID1 = sc.nextInt();
				System.out.println("请输入学科名称:");
				String subjectName1 = sc.next();
				boolean r = ae.removeScore(sID1, subjectName1);
				if (r) {
					System.out.println("删除成绩成功");
				} else {
					System.out.println("删除失败");
				}
				break;
			case 5:
				// 查询学生
				for (Student stu : se.selectStudents()) {
					// 打印学生信息
					System.out.println(stu);
				}
				break;
			case 6:
				// 查询所有学生的所有学科成绩
				for (Student stu : se.selectStudents()) {
					System.out.println("学生信息为:");
					System.out.println(stu);
					List<AScoreE> aScoreEs = ae.selectSub(stu.getId());
					for (AScoreE aScoreE : aScoreEs) {
						System.out.println("科目:" + aScoreE.getSubjectName() + " " + "成绩:" + aScoreE.getSubjectScore());
					}
					System.out.println();

				}

				break;
			case 0:
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
				System.out.println("你输入的有误");
				break;
			}
		} while (!is);

	}

}
