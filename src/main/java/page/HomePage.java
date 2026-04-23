package page;

import estrutura.BasicSelenium;

public class HomePage extends BasicSelenium {
	
	public boolean mensagemBoasVindas(String nome) {
		boolean mensagemNome = false;
		boolean mensagem=false;
		
		if(confirmTextScreen("Olá "+nome)) {
			mensagemNome=true;
		}	
		
		if(confirmTextScreen("bem vindo ao BugBank :)")) {
			mensagem=true;
		}
		logPassoAPasso("Validar mensagem de boas vindas", true);
	
		
		if(mensagemNome & mensagem) {
			return true;
		}else {
			logPassoAPasso("O texto exibido não é o esperado. O nome do usuário é "+nome
					+ ". Foi exibido o nome "+getTextScreen("//*[@id='textName']"), true);
			return false;
		}
			
	}

	public void btnTransferencia() {

		click("//a[@id='btn-TRANSFERÊNCIA']");
	}

	public void btnPagamentos() {

		click("//a[@id='btn-PAGAMENTOS']");
	}

	public void btnExtratos() {

		click("//a[@id='btn-EXTRATO']");
	}

	public void btnSaque() {

		click("//a[@id='btn-SAQUE']");
	}
}
