package br.com.dev;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import br.com.dev.exception.MathOperationException;
import br.com.dev.exception.UnsuportedMathOperationException;
import br.com.dev.model.Person;
import br.com.dev.services.PersonServices;
import math.SimpleMath;
import request.NumberConverter;

@RestController 
@RequestMapping("/person")
public class PersonController {
	
	
 @Autowired	
 private PersonServices services;
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.GET,
			produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id )  {
		return services.findById(id);	
	}	
	
	
	@RequestMapping(method=RequestMethod.GET,
			produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return services.findAll();	
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes= org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person )  {
		return services.create(person);	

	}
	

	@RequestMapping(method=RequestMethod.PUT,
			consumes= org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person )  {
		return services.update(person);	

	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id )  {
		 services.delete(id);	
	}	
}
