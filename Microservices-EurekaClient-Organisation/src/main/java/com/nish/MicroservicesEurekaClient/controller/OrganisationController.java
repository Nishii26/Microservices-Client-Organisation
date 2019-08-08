package com.nish.MicroservicesEurekaClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrganisationController {

	  @Autowired
	  RestTemplate restTemplate;
	  
	  @RequestMapping(value = "/getOrgDetails/{orgname}", method = RequestMethod.GET)
	  public String getEmployees(@PathVariable String orgname)
	    {
	        System.out.println("Getting Organisation details for " + orgname);
	 
	        String response = restTemplate.exchange("http://Employees/getEmployees/{org}",
	                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, orgname).getBody();
	 
	        System.out.println("Response Received as " + response);
	 
	        return "Organisation Name -  " + orgname + " \n Employees Details " + response;
	    }
}

