package testngSample;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
  

  @DataProvider(name="SuccessfulLogin")
  public Object[][] dp()
  {
    return new Object[][] {
      new Object[] { "admin","admin"}
     
    };
  }
  @DataProvider(name="UnSuccessfulLogin")
  public Object[][] dp1()
  {
    return new Object[][] {
      new Object[] { "adam2","adam2"},
      new Object[] { "adam2","adam"},
      new Object[] { "adam","adam2"}
      
      
     
    };
  }
}
