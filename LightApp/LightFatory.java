 //Object Creation Logic:-

package oar.org.LightApp;

public class LightFatory 
{
	public static Iswitch getLight(String type) 
	{
		if(type.equalsIgnoreCase("tubelight"))
		{
			return new TubeLightImpl();
		}
		else if(type.equalsIgnoreCase("ledlight"))
		{
			return new LedLightImpl();
		}
		else
		{
			System.err.println("No light found!!"); // err prints the red color error message
		}
		return null;
	}
}
