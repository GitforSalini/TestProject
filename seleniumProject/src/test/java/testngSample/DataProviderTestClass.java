package testngSample;

import org.testng.annotations.Test;

public class DataProviderTestClass 
{
  @Test(dataProvider="dp1",dataProviderClass=DataProviderClass.class)
  public void addition(Integer a,Integer b) 
  {
	  System.out.println(a+b);
  }
  @Test(dataProvider="dp1",dataProviderClass=DataProviderClass.class)
  public void subtraction(Integer a,Integer b) 
  {
	  System.out.println(a-b);
  }
  @Test(dataProvider="dp2",dataProviderClass=DataProviderClass.class)
  public void multiplication(Integer a,Integer b) 
  {
	  System.out.println(a*b);
  }
}
