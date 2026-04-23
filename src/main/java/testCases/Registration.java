package testCases;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import estrutura.Init;
import io.qameta.allure.Description;

import static estrutura.Parametros.*;

import page.CadastroPage;
import page.LoginPage;
import util.Util;

public class Registration extends Init{
	
	LoginPage login = new LoginPage();
	CadastroPage cadastro = new CadastroPage();
	Util util = new Util();
	
	
	@Test
	@DisplayName("Realiza a criação de um novo usuário")
	@Description("Como um usuário, eu acesso o portal e clico no botão 'Registrar'. Preencho meus "
			+ "dados pessoais e logo depois clico em 'Cadastrar'. Verifico se a mensagem de "
			+ "sucesso foi exibida e clico em fechar")
	public void createNewUser() throws InterruptedException {
		loginUsuario=util.generateEmail();
		nomeDoUsuario=util.generateName();
		
		login.btnRegistrar();
		cadastro.email(loginUsuario);
		cadastro.name(nomeDoUsuario);
		cadastro.password(password);
		cadastro.passwordConfirmation(password);
		cadastro.btnCadastrar();
		assertTrue(cadastro.mensagemSucesso("criada com sucesso"));
		cadastro.btnFecharModal();
		
	}

}
