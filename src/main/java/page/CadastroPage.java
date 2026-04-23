package page;

import estrutura.BasicSelenium;

public class CadastroPage extends BasicSelenium {

	public void email(String user) throws InterruptedException {
		waitText("Voltar ao login");
		write("/html/body/div/div/div[2]/div/div[2]/form/div[2]/input", user);
	}

	public void name(String name) {
		logPassoAPasso("Inserir nome", false);
		write("//input[@name='name']", name);
	}

	public void password(String password) {
		logPassoAPasso("Definir senha", false);
		write("//input[@wfd-id='id4']", password);
	}

	public void passwordConfirmation(String passwordConfir) {
		logPassoAPasso("Inserir confirmação de senha", false);
		write("//input[@name='passwordConfirmation']", passwordConfir);
	}

	public void saldoEmConta() {
		click("//label[@id='toggleAddBalance']");
	}

	public void btnCadastrar() {
		logPassoAPasso("Clicar em 'Cadastrar'", true);
		click("//form/button");
	}

	public boolean mensagemSucesso(String text) {
		logPassoAPasso("Validar mensagem de sucesso", true);
		return confirmTextScreen(text);
	}

	public void btnFecharModal() {

		click("//*[@id='btnCloseModal']");
	}

}
