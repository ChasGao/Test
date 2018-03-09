package webservice;

import javax.xml.ws.Endpoint;

public class WebServicePublish {

	//发布Web Service
	public static void main(String[] args) {
		String address = "http://localhost:8080/WS_Server/Webservice";
		
		 Endpoint.publish(address , new WebServiceImpl());
		 System.out.println("发布webservice成功!");

	}

}
