import org.testng.annotations.*;
import java.util.Iterator;

import static org.testng.Assert.assertTrue;

public class BankTest {
    @DataProvider(name = "csv")
    public Iterator<Object[]> searchFromCsv() {
        return Utils.loadDataFromFile();
    }

    @BeforeMethod
    public void openBrowser() {
        new BrowserManager().openBrowser();
    }

    @Test(priority = 1)
    public void loginUserTest() {
        String userName = Navigate.pageOfUserAuthorization().loginUser().getUserName();
        assertTrue(userName.contains("Королёва Ольга"));
    }

    @Test(priority = 2)
    public void isBalancePositiveTest() {
        CheckBalancePage checkBalancePage = Navigate.pageOfUserAuthorization().loginUser().checkBalancePage();
        assertTrue(checkBalancePage.isBalancePositive());
    }

    @Test(priority = 3)
    public void operationOfExchangeTest() {
        String resultOfTransactionPage = Navigate.pageOfUserAuthorization().loginUser().
                exchangePage().checkedOperationOfExchange().resultExchangePage();
        assertTrue(resultOfTransactionPage.contains("Исполнен"));
    }

    @Test(priority = 4, dataProvider = "csv")
    public void messageTest(String text) {
        String messageResultPage = Navigate.pageOfUserAuthorization().loginUser().
                messagePage().createNewMessagePage().createNewMessage(text).isPresentNewMessage();
        assertTrue(messageResultPage.contains(text));
    }

    @AfterMethod
    public void closeBrowser() {
        new BrowserManager().closeBrowser();
    }

}
