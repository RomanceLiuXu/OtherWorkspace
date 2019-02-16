package com.lanou;

import java.util.List;

/**
 * 操作成绩实现类
 * 
 * @author LiuXu
 * @time2018年6月7日下午5:34:02
 **/
public class ImplSS implements IStudentScore {

	List<Student> stuList = ImplStu.stuLists;

	@Override
	public void addSS(int id) {
		// 为指定学生添加成绩
		// 遍历集合，为输入的学生添加成绩
		if (stuList != null) {
			for (Student student : stuList) {
				if (student.getId() == id) {
					student.setChineseName("语文");
					student.setChineseScore(100);
					student.setMathName("数学");
					student.setMathScore(98);
				}
			}
				System.out.println("学号不存在");
			
		}

	}

	@Override
	public void removeSS(int id, String subject) {
		// 删除学生指定学科的成绩
		if (stuList != null) {
			// 遍历得到指定学生
			for (Student student : stuList) {
				if (student.getId() == id) {
					// 得到指定的学科
					if (student.getChineseName() == subject) {
						// 将指定学科成绩设为0
						student.setChineseScore(0);
						return;
					} else if (student.getMathName() == subject) {
						// 将指定学科成绩设为0
						student.setMathScore(0);
						return;
					} else {
						System.out.println("输入学科名称有误");
						return;
					}
				}else {
					System.out.println("输入学号有误");
			}

		} 

		}

	}

	@Override
	public List<Student> stuAndScos() {
		if (stuList == null || stuList.size() == 0) {
			System.out.println("当前无学生");
		}

		return stuList;
	}

	public void showScore(int id) {
		// 打印所有学生带成绩
		if (stuList != null) {
			for (Student student : stuList) {
				if (student.getId() == id) {
					System.out.println("学号\t姓名\t性别\t年龄\t语文\t数学");
					System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getSex() + "\t"
							+ student.getAge() + "\t"+student.getChineseScore() + "\t" + student.getMathScore());
				}
			}
		}

	}

}
