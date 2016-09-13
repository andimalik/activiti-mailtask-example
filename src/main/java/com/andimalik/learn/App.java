package com.andimalik.learn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine processEngine = processEngineConfiguration
				.buildProcessEngine();
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		repositoryService.createDeployment()
				.addClasspathResource("com/andimalik/learn/MyProcess.bpmn")
				.deploy();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		runtimeService.startProcessInstanceByKey("myProcess");
	}
}
