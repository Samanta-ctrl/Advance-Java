//Tube light implementation logic:-

package oar.org.LightApp;

public class TubeLightImpl implements Iswitch
{
	@Override
	public void sOn() 
	{
		System.out.println("Tubelight is tured on");	
	}

	@Override
	public void sOff()
	{
		System.out.println("Tubelight is tured off");	
	}
}
