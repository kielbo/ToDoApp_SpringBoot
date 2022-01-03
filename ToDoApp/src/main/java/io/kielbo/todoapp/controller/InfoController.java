package io.kielbo.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kielbo.todoapp.TaskConfigurationProperties;

@RestController
public class InfoController {
	@Value("${my.prop}")
	private String mySource;
	
	@Autowired
	private DataSourceProperties url;
	
	private TaskConfigurationProperties propTest;
	
	public InfoController(DataSourceProperties url,
			TaskConfigurationProperties propTest) {
		super();
		this.url = url;
		this.propTest = propTest;
	}
	
	@GetMapping("/test/url")
	String getUrl() {
		return url.getUrl();
	}
	@GetMapping("/test/myProp")
	String getMyProp() {
		return mySource;
	}
	
	@GetMapping("/test/myProp2")
	boolean getMyPropFromClass() {
		return propTest.getTemplate().isAllowMultipleTasks();
	}



}
