package com.lanou.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

/**
 *
 * @author LiuXu
 * @time2018年9月19日下午2:13:08
 **/
public class MyTest {

	ProcessEngine p = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void test1() {
		// 获得一个流程引擎配置对象
		ProcessEngineConfiguration conf = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti-context.xml", "processEngineConfiguration");
		// 使用配置对象创建一个流程引擎对象，并且自动在创建过程中可以自动建表
		ProcessEngine buildProcessEngine = conf.buildProcessEngine();
	}

	@Test
	public void test2() {
		// 创建一个部署构建器对象，用于加载流程定义文件（bpmn文件和png文件）
		DeploymentBuilder dep = p.getRepositoryService().createDeployment();
		dep.addClasspathResource("aa.bpmn");
		dep.addClasspathResource("aa.png");
		Deployment deploy = dep.deploy();
		System.out.println(deploy.getId());
	}

	/**
	 * 查询流程定义
	 */
	@Test
	public void test3() {

		ProcessDefinitionQuery query = p.getRepositoryService().createProcessDefinitionQuery();
		//
		List<ProcessDefinition> list = query.list();
		for (ProcessDefinition pr : list) {
			System.out.println(pr.getId() + ":" + pr.getName() + ":" + pr.getVersion());
		}
	}

	/**
	 * 启动流程定义
	 */
	@Test
	public void test4() {
		// 定义一个流程id
		String processId = "myProcess:1:4";
		ProcessInstance startProcessInstance = p.getRuntimeService().startProcessInstanceById(processId);
		System.out.println(startProcessInstance);
	}

	/**
	 * 查询任务
	 */
	@Test
   public void test5(){
	   TaskQuery createTaskQuery = p.getTaskService().createTaskQuery();
	   createTaskQuery.taskAssignee("张三");
	   List<Task> list = createTaskQuery.list();
	  for (Task task : list) {
		System.out.println(task.getId()+"--"+task.getName()+"--"+task.getAssignee());
	}
   }

	/**
	 * 办理任务
	 */
	@Test
	public void test6(){
		String taskId ="2504";
		p.getTaskService().complete(taskId);
	}
	
	
	
}
