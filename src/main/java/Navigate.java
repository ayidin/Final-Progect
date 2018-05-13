import org.openqa.selenium.support.PageFactory;

public class Navigate {

    public static LoginUserPage pageOfUserAuthorization (){
        new BrowserManager().driver.get("https://idemo.bspb.ru");
        return PageFactory.initElements(BrowserManager.driver, LoginUserPage.class);
    }
}
