package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	public String getKeyValue(String Key) throws Throwable
	{

	FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
	Properties pro = new Properties();
	pro.load(fis);
	String Value = pro.getProperty(Key);
	return Value;
	
	
}
}