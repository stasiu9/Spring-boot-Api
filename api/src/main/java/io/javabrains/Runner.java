package io.javabrains;

import java.util.List;






public class Runner {
	
	
	public static void main(String[] args) throws Exception
	{
	
		try {
			
			System.out.println("********");
			List<Data> dataList=File.getDataList("http://jsonplaceholder.typicode.com/users");
			System.out.println("Size of list:\n"+dataList.size());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
}
