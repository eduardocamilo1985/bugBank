package estrutura;

import static estrutura.Parametros.execucao;
import static estrutura.Parametros.navegador;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver driver;


	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	public static WebDriver initDriver() {
		WebDriver driver = null;
		if (execucao == "local") {
			switch (navegador) {
			case "C":
				driver = new ChromeDriver();
				break;
			case "E":
				driver = new EdgeDriver();
				break;
			case "F":
				driver = new FirefoxDriver();
				break;

			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	public static void killDriver() throws IOException, InterruptedException {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
		
		AllureReport allure = new AllureReport();
		allure.generateAllure();
		
	}

}
