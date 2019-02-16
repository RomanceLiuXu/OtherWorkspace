package com.lanou;

import java.util.*;

/**
 * 学生接口实现类
 * 
 * @author LiuXu
 * @time2018年6月7日下午4:11:00
 **/
public class ImplStu implements IScore {

	// 创建集合存放所有学生
	static List<Student> stuLists = new ArrayList<>();
	// 创建班级集合存放学生
	static Map<Integer, List<Student>> maps = new HashMap<>();

	// 向班级中添加学生
	public void addStoClass(int n) {
		if (stuLists == null || stuLists.size() == 0) {
			System.out.println("当前无学生");
			return;
		}
		// 新建集合存放某一班级的学生
		List<Student> classStu = new ArrayList<>();
		// 选班级
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要添加的学号(任意字符结束添加):");
		while (scan.hasNextInt()) {
			// 通过学号添加
			int sid = scan.nextInt();
			if (stuExist(sid)) {
				for (Student student : stuLists) {
					if (student.getId() == sid) {
						boolean is = classStu.add(student);
						if (is) {
							System.out.println("向班级中添加学生成功");
						} else {
							System.out.println("向班级中添加学生失败");
						}

					}
				}
			} else {
				System.out.println("无此学号，添加失败，请重新输入(任意字符结束添加):");
			}

		}
		// 向班级集合中添加学生
		maps.put(n, classStu);

	}

	// 遍历班级集合
	public void showClass(int n) {
		if (maps == null || maps.size() == 0) {
			System.out.println("班级不存在");
		} else {
			// 遍历班级集合
			System.out.println("学号\t姓名\t性别\t年龄");
			for (Student student : maps.get(n)) {
				System.out.println(student);
			}
		}

	}

	// 查询所有学生
	public List<Student> getstuLists() {

		return stuLists;
	}

	// 根据学号判断学生是否存在
	public boolean stuExist(int id) {
		if (stuLists == null || stuLists.size() == 0) {
			System.out.println("当前无学生");
		} else {
			for (Student student : stuLists) {
				if (student.getId() == id) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void addStudent(Student student) {
		// 添加学生
		stuLists.add(student);

	}

	@Override
	public void searchStudent(Student student) {

	}

	public void searchStudent(int id) {
		// 查询学生，由于学号的唯一性，可以按学号查询
		// 遍历集合，查询所有学生
		for (Student student : stuLists) {
			// 学号相等，输出该学生的信息
			if (student.getId() == id) {
				System.out.println("查找成功");
				showStu(student);
				return;
			}
		}

	}

	@Override
	public void deleteStudent(Student student) {
		// 删除学生
		stuLists.remove(student);

	}

	public void deleteStudent(int id) {
		// 删除学生
		// 由于学号的唯一性，可以按学号删除
		// 遍历集合
		if (stuLists == null || stuLists.size() == 0) {
			System.out.println("当前无学生");
		} else {
			// 使用迭代器删除
			Iterator<Student> it = stuLists.iterator();
			while (it.hasNext()) {
				Student student = it.next();
				if (student.getId() == id) {
					boolean is = stuLists.remove(student);
					if (is) {
						System.out.println("删除成功");
					} else {
						System.out.println("删除失败");
					}
				}

			}

		}
	}

	// 打印所有学生集合的方法
	public void showList() {
		// 遍历
		if (stuLists == null || stuLists.size() == 0) {
			System.out.println("当前暂无学生");
		} else {
			System.out.println("学号\t姓名\t性别\t年龄");
			for (Student student : stuLists) {
				System.out.println(student);
			}
		}

	}

	// 打印单个学生的方法
	public void showStu(Student student) {
		System.out.println("学号\t姓名\t性别\t年龄");
		System.out.println(student);
	}

}
