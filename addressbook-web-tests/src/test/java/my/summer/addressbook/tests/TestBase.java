package my.summer.addressbook.tests;

import my.summer.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBase {

  org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logbackStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + Arrays.asList(p));

  }
  @AfterMethod(alwaysRun = true)
  public void logbackEnd(Method m) {
    logger.info("Stop test " + m.getName());
  }

}
