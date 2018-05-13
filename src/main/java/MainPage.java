import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    Actions Action = new Actions(BrowserManager.driver);

    @FindBy(css = ".filter-option.pull-left")
    WebElement userName;

    @FindBy(id = "accounts-index")
    WebElement accountLink;

    @FindBy(id = "statement")
    WebElement linkToAccountPage;

    @FindBy(id = "currency-rates")
    WebElement currencyLink;

    @FindBy(xpath = "//a[@id='currency-exchange']")
    WebElement linkToCurrencyPage;

    @FindBy(xpath = "//a[@href='/messages']")
    WebElement linkToMessagePage;

    public String getUserName() {
        return userName.getText();
    }

    public CheckBalancePage checkBalancePage() {
        Action.moveToElement(accountLink).build().perform();
        Action.moveToElement(linkToAccountPage).click().build().perform();
        return PageFactory.initElements(BrowserManager.driver, CheckBalancePage.class);
    }

    public ExchangePage exchangePage() {
        Action.moveToElement(currencyLink).build().perform();
        Action.moveToElement(linkToCurrencyPage).click().build().perform();
        return PageFactory.initElements(BrowserManager.driver, ExchangePage.class);
    }

    public MessagePage messagePage() {
        linkToMessagePage.click();
        return PageFactory.initElements(BrowserManager.driver, MessagePage.class);
    }
}
