package DesingMode;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午7:43:30
 **/
public class Main {

	public static void main(String[] args) {

		// 实例化工厂
		ShapeFactory factory = new ShapeFactory();
		// 使用工厂对象调用对应的方法获取要生产的对象
		Shape rectangle = factory.getRectangle();
		// 调用对应生产的方法
		rectangle.draw();

		Shape triangle = factory.getTriangle();
		
		triangle.draw();
	}
}
