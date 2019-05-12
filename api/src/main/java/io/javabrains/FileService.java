package io.javabrains;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileService 
{
	
	@Autowired
	private Servicef servicef;
	
	@RequestMapping("/users")
	/*
	public String getAll(Model model)
	{
		model.addAttribute("Users",servicef.getAll());
		
		return "Users";
	}
	*/
	
	public List<Data> getAll()
	{
		return servicef.getAll();
	}
	
	@RequestMapping("/users/{id}")
	public Data getId(@PathVariable String id)
	{
		return servicef.getId(id);
	}
	
	
}
