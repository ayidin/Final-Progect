import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateNewMessagePage {

    @FindBy (xpath = "//select[@name='message.topicName']")
    WebElement subjectOfQuestion;

    @FindBy (xpath = "//div[@class='controls']/textarea[@name='message.text']")
    WebElement textArea;

    @FindBy (xpath = "//div[@class='form-actions']//button[@id='send-button']")
    WebElement sendButton;

    public MessageResultPage createNewMessage(String text){
        Utils.oSelect(subjectOfQuestion, 1);
        Utils.waitForElementPresent(textArea);
        textArea.sendKeys(text);
        sendButton.click();
        return PageFactory.initElements(BrowserManager.driver, MessageResultPage.class);

    }


}
