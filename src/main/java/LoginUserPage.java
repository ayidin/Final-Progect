import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUserPage {
    @FindBy (id = "login-button")
    WebElement loginButton;

    @FindBy (id = "login-otp-button")
    WebElement confirmSmsButton;

    public MainPage loginUser(){
        loginButton.click();
        confirmSmsButton.click();
        return PageFactory.initElements(BrowserManager.driver, MainPage.class);
    }
}
