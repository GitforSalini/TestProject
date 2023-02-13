package testngSample;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderAssignment
{
  

  @DataProvider(name="SuccessfulLogin")
  public Object[][] dp() 
  {
    return new Object[][] {
      new Object[] { "carol","1q2w3e4r"}
      
    };
  }
  @DataProvider(name="UnSuccessfulLogin")
  public Object[][] dp1() 
  {
    return new Object[][] {
      new Object[] { "caramal","1q2w3"},
      new Object[] { "carol","2w3e4r" },
      new Object[] { "caraval","1q2w3e4r" }
      
    };
  }
}
