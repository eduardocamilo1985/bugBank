package estrutura;

import static estrutura.DriverFactory.getDriver;
import static estrutura.Parametros.url;
import static util.Util.getDateTime;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;

public class BasicSelenium {

	public void accessUrl() {
		getDriver().get(url);

	}

	// ##################### TEXT
	public void write(String xpath, String text) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		email.clear();
		email.sendKeys(text);

	}

	public void waitText(String text) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
	}

	public boolean confirmTextScreen(String text) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));

			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public String getTextScreen(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		return text.findElement(By.xpath(xpath)).getText();
	}

	// ##################### BUTTON, RADIO, CHECK
	public void click(String xpath) {

		descerTelaAteElemento(xpath);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		getDriver().findElement(By.xpath(xpath)).click();

	}

	public void clickText(String text) {

		getDriver().findElement(By.xpath("//button[contains(., '" + text + "')]")).click();

	}

	// ##################### QUANTITY

	public int qtd(String xpath) {

		return getDriver().findElements(By.xpath(xpath)).size();

	}

	// ##################### OUTROS

	public void descerTelaAteElemento(String xpath) {

		WebElement element = getDriver().findElement(By.xpath(xpath));

		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(element, 0, -50);
		try {
			new Actions(getDriver()).scrollFromOrigin(scrollOrigin, 0, 200).perform();
		} catch (Exception e) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);
		}

	}
	
	protected static WebElement findClickableElement(By by, boolean waitPresence, boolean waitClickable) {
		long inicio = System.currentTimeMillis();

		WebElement webElement = null;
		try {
			webElement = getElement(by, waitPresence, waitClickable, inicio);
		} catch (WebDriverException e) {

			webElement = getElement(by, waitPresence, waitClickable, inicio);
		}

		return webElement;
	}

	private static WebElement getElement(By by, boolean waitPresence, boolean waitClickable, long inicio) {
		WebElement webElement = null;
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		try {
			if (waitPresence) {
				webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			}
			if (waitClickable) {
				webElement = wait.until(ExpectedConditions.elementToBeClickable(by));
			}
			if (!waitPresence && !waitClickable) {
				webElement = getDriver().findElement(by);
			}
		} catch (WebDriverException e) {

			throw e;
		}

		try {

		} catch (Exception e) {

		}
		return webElement;
	}

	// ##################### RELATÓRIO

	public static void logPassoAPasso(String info, Boolean tiraPrint) {
		Allure.step(info);

		if (tiraPrint) {
			Allure.attachment(info + getDateTime(),
					new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
		}

	}

	
}
