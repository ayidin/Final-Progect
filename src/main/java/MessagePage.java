import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessagePage {
    @FindBy(xpath = "//a[@href='/messages/form?type=message']")
    WebElement buttonOfAddNewMessage;

    public CreateNewMessagePage createNewMessagePage() {
        //buttonOfAddNewMessage.click(); клик с помощью Webdriver
        Utils.clickWithJs(buttonOfAddNewMessage); // клик с помощью JS
        return PageFactory.initElements(BrowserManager.driver, CreateNewMessagePage.class);
    }

}
