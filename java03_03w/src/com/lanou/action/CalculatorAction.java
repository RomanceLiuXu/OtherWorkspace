package com.lanou.action;



/**
 *
 * @author LiuXu
 * @time2018年7月27日下午9:35:44
 **/
public class CalculatorAction {

	private String num1;// 第一个数
	private String num2;// 第二个数
	private String operation;// 运算符
	private double result;
	
	public String counter() {
	 int n1 = Integer.parseInt(num1);
	 int n2 = Integer.parseInt(num2);
		if ("加".equals(operation)) {
			result =  n1 + n2;
		}else if ("减".equals(operation)) {
			result = n1 - n2;
		}else if ("乘".equals(operation)) {
			result = n1 * n2;
		}else if ("除".equals(operation)) {
			if (n2!=0) {
				result =(double)n1 / n2;
			}
		}
		return "true";
	}
	
	

	public double getResult() {
		return result;
	}



	public void setResult(int result) {
		this.result = result;
	}



	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
