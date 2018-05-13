import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageResultPage {
    @FindBy(xpath = "//table//tr[2]/td[4]")
    WebElement textNewMessage;


    public String isPresentNewMessage() {
        Utils.waitForElementPresent(textNewMessage);
        return textNewMessage.getText();
    }
/*
    public void getElementList(){
        List <WebElement> elementList = BrowserManager.driver.findElements(By.xpath("//table"));
        for (WebElement text:elementList){
            System.out.println(text.getText());
        }
    }
    */


}
