package DriverAndBasicFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class Property {
	static Properties prop=null;
	public static String sourceCity="";
	public static String destinationCity="";
	public static String journeyDate="";
	public static String pickupTime="";
	public static String carType="";
	public static String moreAmount="";
	public static String lessAmount="";
	public static String amount="";
	public static String name="";
	public static String invalidEmail="";
	public static void loadProperty()
	{
		if(prop==null)
		{
			prop=new Properties();
			FileInputStream readFile=null;
			try {
				readFile=new FileInputStream(System.getProperty("user.dir")+"\\object-repository\\input.properties");
				prop.load(readFile);
				//Getting value using key
				sourceCity=prop.getProperty("Source");
				destinationCity=prop.getProperty("Destination");
				journeyDate=prop.getProperty("Date");
				pickupTime=prop.getProperty("Time");
				carType=prop.getProperty("Car");
				//moreAmount=prop.getProperty("Amount2");
				//lessAmount=prop.getProperty("Amount1");
				//amount=prop.getProperty("Amount3");
				//name=prop.getProperty("RName");
				//invalidEmail=prop.getProperty("REmail");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				if(readFile!=null)
				{
					try
					{
						readFile.close();
					}
					catch(IOException io)
					{
						io.printStackTrace();
					}
				}
			}
		}
		System.out.println("Input taken from Property file");
	}
}
