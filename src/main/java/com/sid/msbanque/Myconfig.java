package com.sid.msbanque;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import com.sid.msbanque.web.CompteRestJaxRSAPI;

@Configuration
public class Myconfig {
	//retourner Resourceoconfig qui va deployer 
	//avec jaxrs
	//desctiver jersy cas 1
	 // 
	    public ResourceConfig ressourceConfig() {
	    
	    	ResourceConfig jeseyServlet=new ResourceConfig();
	    	//web service
	    	jeseyServlet.register(CompteRestJaxRSAPI.class);
	    	return jeseyServlet;
	  
	    }
	    @Bean
	    SimpleJaxWsServiceExporter serviceExporter(){
	    	
	    	SimpleJaxWsServiceExporter serviceExporter =new SimpleJaxWsServiceExporter();
	    	serviceExporter.setBaseAddress("http://0.0.0.0:8888/");
	    	return serviceExporter;
	    	
	    	
	    }

}
