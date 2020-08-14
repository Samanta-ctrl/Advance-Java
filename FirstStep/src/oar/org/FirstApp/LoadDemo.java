package oar.org.FirstApp;

public class LoadDemo
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded and registered");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
