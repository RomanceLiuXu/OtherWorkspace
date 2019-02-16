package DesingMode;

/**
 * 画图形的工厂
 * @author LiuXu
 * @time2018年8月7日下午7:40:50
 **/
public class ShapeFactory {

	public Triangle getTriangle() {
		
		return new Triangle();
	}
	
	public Rectangle getRectangle(){
		
		return new Rectangle();
	}
	
}
