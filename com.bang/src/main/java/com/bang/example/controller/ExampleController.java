package com.bang.example.controller;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bang.example.service.ExampleService;
import com.sap.conn.jco.JCoException;

@Controller
public class ExampleController {
	private static final Log logger = LogFactory.getLog( ExampleController.class );
	 
	@Autowired
	ExampleService exampleService;
	
	/**
	 * Logging or OpenUI5 Example
	 */
	@RequestMapping( value="/openui5", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		
		logger.debug( "#ex1 - debug log" );
		logger.info( "#ex1 - info log" );
		logger.warn( "#ex1 - warn log" );
		logger.error( "#ex1 - error log" );
		
		//mav.addObject("result", null);	
		mav.setViewName("/example/openui5");

		return mav;
	}
	
	
	/**
	 * Json Response Example
	 */
	@RequestMapping( value="/getJson", method = RequestMethod.GET)
	public String getJson(Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "howtodoinjava@gmail.com");
		map.put("2", "asinghal@yahoo.com");
		map.put("3", "kmishra@gmail.com");
		
		model.addAttribute("resultMap", map);
		
		return "jsonView";
	}
	
	/**
	 * JCO Example
	 */
//	@RequestMapping( value="/jco", method = RequestMethod.GET)
//	public void jco(Model model) {
//		try {
//			exampleService.jco();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@RequestMapping( value="/jco1", method = RequestMethod.GET)
//	public void jco1(Model model) {
//		try {
//			exampleService.jco1();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
