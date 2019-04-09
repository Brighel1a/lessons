package my.summer.addressbook.tests;

import my.summer.addressbook.appmanager.ApplicationManager;
import my.summer.addressbook.models.GroupData;
import my.summer.addressbook.models.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

  public void verifyGroupListInUI() {
    if(Boolean.getBoolean("verifyUi")){
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g)-> new GroupData()
              .withGroupname(g.getGroupname()).withId(g.getId())).collect(Collectors.toSet())));
    }


  }

}
