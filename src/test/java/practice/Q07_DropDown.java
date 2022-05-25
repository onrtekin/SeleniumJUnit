package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Q07_DropDown extends TestBase {

    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
  @Test
    public void test(){

      driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
      driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();

      Actions actions=new Actions(driver);
    for (int i = 0; i < 15; i++) {
      actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }
    driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();

    for (int i = 0; i < 15; i++) {
      actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }
    driver.findElement(By.xpath("//input[@id='justAnotherInputBox']")).click();
    for (int i = 0; i < 9; i++) {
      actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }



  }

}
