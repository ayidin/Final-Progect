import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultExchangePage {

    @FindBy(id = "confirmation-frame")
    WebElement switchToFrame;

    @FindBy(xpath = "//form[@id='confirmation-form']/button[@id='confirm']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='form-items readonly']/div[@id='payment-status-row']//span[@class='print-hidden']")
    WebElement transactionStatus;

    public String resultExchangePage() {
        BrowserManager.driver.switchTo().frame(switchToFrame);
        submitButton.click();
        String[] status = transactionStatus.getText().split(" ");
        String statusOfTransaction = status[0];
        return statusOfTransaction;
    }
}
