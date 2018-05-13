import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utils {

    public static void oSelect(WebElement element, int number) {
        Select oSelect = new Select(element);
        oSelect.selectByIndex(number);
    }

    public static void waitForElementPresent(WebElement element) {
        new WebDriverWait(BrowserManager.driver, 20).
                until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickWithJs(WebElement element) {
        //WebElement element = BrowserManager.driver.findElement(By.xpath("//select[@name='message.topicName']"));
        JavascriptExecutor executor = (JavascriptExecutor) BrowserManager.driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static Iterator<Object[]> loadDataFromFile() {
        List<Object[]> list = new ArrayList<Object[]>();
        String filePath = new File("src/main/java/Data.csv").getAbsolutePath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                //String[] params = line.split(","); // Если не обходимо записать больше данных через разделить
                //list.add(new Object[]{params[0],params[1]}); // при использованиеи разделителя
                list.add(new Object[]{line});
                line = reader.readLine();
            }
        } catch (Exception e) {
        }
        return list.iterator();
    }

}
