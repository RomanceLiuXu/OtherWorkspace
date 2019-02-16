package com.lanou.myTest;

/**
*
* @author mzy
* @time 2018年8月15日下午8:19:15
**/
public abstract   class AbstractCommand {
	/**
	 * 声明命令执行方法
	 * @param value
	 * @return
	 */
  public abstract int  execute(int value) ;
	/**
	 * 声明命令撤销方法
	 * @return
	 */
   public abstract int undo() ;
	

}
