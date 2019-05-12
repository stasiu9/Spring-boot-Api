package io.javabrains;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Servicef {

	List<Data> list=(File.getDataList("http://jsonplaceholder.typicode.com/users"));
	
	public Servicef() throws Exception
	{
		
	}
	
	
	public List<Data> getAll()
	{
		return list;
	}
	public Data getId(String id)
	{
		return list.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
}
