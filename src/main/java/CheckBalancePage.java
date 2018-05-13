import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBalancePage {

    @FindBy(xpath = "//tr[@id='closing-balance-row']/th[2]")
    WebElement amountResult;

    public boolean isBalancePositive(){
        String []ArrResult = amountResult.getText().replaceAll(" ", "").split("\\.");
        String result  = ArrResult[0];
        int resultOfBalance = Integer.parseInt(result);
        return  (resultOfBalance > 0);
    }
    }

