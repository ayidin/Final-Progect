import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExchangePage {

    @FindBy(xpath = "//select[@id='acc1']")
    WebElement selectCurrencyForSale;

    @FindBy(id = "from-amount")
    WebElement amount;

    @FindBy(xpath = "//select[@id='acc2']")
    WebElement selectCurrencyForBuy;

    @FindBy(xpath = "//div[@class='controls']/textarea")
    WebElement textArea;

    @FindBy(id = "forward")
    WebElement submitButton;


    public ResultExchangePage checkedOperationOfExchange() {
        Utils.oSelect(selectCurrencyForSale, 3);
        amount.sendKeys("100");
        Utils.oSelect(selectCurrencyForBuy, 0);
        textArea.sendKeys("Exchange 20 dollars for rubles");
        submitButton.click();
        return PageFactory.initElements(BrowserManager.driver, ResultExchangePage.class);
    }
}
