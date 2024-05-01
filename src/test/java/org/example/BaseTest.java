package org.example;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    BrowserManager browserManager = new BrowserManager();


    @BeforeMethod
    public void setup()
    {
        browserManager.openBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if (!result.isSuccess()) {
            takeScreenShot(result.getName());
        }
        browserManager.closeBrowser();
    }

}