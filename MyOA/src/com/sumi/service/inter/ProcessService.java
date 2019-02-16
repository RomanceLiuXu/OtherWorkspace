package com.sumi.service.inter;

import java.util.List;

import com.sumi.bean.Employee;
import com.sumi.bean.myProcess;

/**
 *
 * @author LiuXu
 * @time2018年8月31日下午11:11:09
 **/
public interface ProcessService {
	/**
	 * 新增流程
	 * @param employee
	 */
	public void addProcess(Employee employee,myProcess process);
	
	
	/**
	 * 提交流程
	 * @param process 对应的流程对象
	 */
    public void submitProcess(myProcess process);
    
    
    /**
     * 取消/驳回流程的方法
     * @param process
     */
    public void cancelProcess(myProcess process);
    
    /**
     * 查询个人的总流程数
     * @param employee
     * @return
     */
   public long findEmpPro(Employee employee);
   /**
    * 查询对应权限的总流程数
    * @param employee
    * @return
    */
   public long findEmpsPro(Employee employee);
    

    /**
     * 查询某个员工的所有流程
     * @return
     */
    public List<myProcess> findEmpProcesses(Employee employee,int pageIndex,int pageNum);
    
    
    /**
     * 查询所有的流程
     * @return
     */
    public List<myProcess> findAllProcess(Employee employee,int pageIndex,int pageNum);
}
