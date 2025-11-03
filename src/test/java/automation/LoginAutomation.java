package automation;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAutomation {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void loginTest() throws InterruptedException {
        page.navigate("https://develop.dd7lwsgf66ani.amplifyapp.com/login");

        page.locator("//input[@id='email']").fill("titero3099@lorkex.com");
        Thread.sleep(1500);
        page.locator("//input[@placeholder='* * * * * *']").fill("Testcopilot@8403");
        page.locator("//button[@type='submit']").click();
        Thread.sleep(3000);

        page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get("screenshot.png")));
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
