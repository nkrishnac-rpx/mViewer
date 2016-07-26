package com.imaginea.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

import com.imaginea.utils.ConfigUtil;


public class LoginPage extends BasePage {
	private WebDriver driver;

    Logger log = Logger.getLogger(LoginPage.class);
    @FindBy(id = "login")
    private WebElement goButton;
    @FindBy(id = "host")
    private WebElement hostTextBox;
    @FindBy(id = "port")
    private WebElement portTextBox;
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "home")
    private WebElement home;

    ConfigUtil configUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        configUtil = ConfigUtil.getInstance();
        driver.get(configUtil.getProperty("TESTURL"));
    }

    private void clickGoButton() {
        goButton.click();
        log.info("Clicking on Go Button");
    }

    /**
     * Login to mViewer
     */
    public void loginmViewer() {
        log.debug("Logging into mviewer");
        hostTextBox.clear();
        hostTextBox.sendKeys(configUtil.getProperty("DBHOST"));
        portTextBox.clear();
        portTextBox.sendKeys(configUtil.getProperty("DBPORT"));
        username.clear();
        username.sendKeys(configUtil.getProperty("DBUSERNAME"));
        password.clear();
        password.sendKeys(configUtil.getProperty("DBPASSWORD"));
        clickGoButton();        
    }

}
