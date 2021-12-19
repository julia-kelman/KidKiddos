package Pages;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.logging.Level;

public class CartPage extends BasePage{

    public static final String cartPageHeader="//h1[text()='Your cart']";
    public static final String currancyBRL="//span[text()='BRL'])";
    public static final String canadaFlag="//span[text()=' CAD']";

    public boolean isCartHeaderVisible(){

        return elementExists(cartPageHeader);
    }

    public boolean isBRLbookVisible(){
        return elementExists(currancyBRL);
    }


    public Level logs() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logim = entries.getAll();

        for (LogEntry e : logim) {
            System.out.println("Message" + e.getMessage());
            System.out.println("Level" + e.getLevel());
            e.getLevel();
        }
        return (Level) logim;
    }

}
