package estrutura;

import static estrutura.Parametros.caminhoDoProjeto;
import static util.Util.getDateTime;

import java.io.IOException;

public class AllureReport {

	public void generateAllure() throws IOException, InterruptedException {
		String caminhoProjeto = caminhoDoProjeto;

		try {

			ProcessBuilder builder = new ProcessBuilder();
			builder.command("cmd.exe", "/c",
					"cd " + caminhoProjeto + " && allure generate allure-results -o C:\\RelatorioTestesAutomatizados\\"
							+ getDateTime() + "\\" + " --clean");

			builder.inheritIO();

			Process process = builder.start();
			process.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
