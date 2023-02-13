package testngSample;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
  @Test(dataProvider = "dp1")
  public void addition(Integer n, Integer s) 
  {
	  System.out.println(n+s);
  }
  @Test(dataProvider = "dp1")
  public void subtract(Integer n, Integer s)
  {
	  System.out.println(n-s);
  }
  @Test(dataProvider = "dp2")
  public void multiplication(Integer n, Integer s)
  {
	  System.out.println(n*s);
  }
  @DataProvider(name="dp1")
  public Object[][] dp1() 
  {
    return new Object[][] {
      new Object[] { 10, 5 },
      new Object[] { 5, 3 },
    };
  }
  @DataProvider(name="dp2")
  public Object[][] dp2() 
  {
    return new Object[][] {
      new Object[] { 10, 50 }
      
    };
  }
}
