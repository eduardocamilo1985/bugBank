package estrutura;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static estrutura.Parametros.*;
import static estrutura.DriverFactory.killDriver;

import java.io.IOException;

@TestInstance(Lifecycle.PER_CLASS)
public class Init extends BasicSelenium{
	
	
	@BeforeAll
	public void init() {
		accessUrl();
		

	}
	
	@AfterAll
	public void quit() throws IOException, InterruptedException {
		
		killDriver();
		
		if (navegador.equalsIgnoreCase("C")) {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} else if (navegador.equalsIgnoreCase("F")) {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		} else if (navegador.equalsIgnoreCase("E")) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe");
		}
	}

}
