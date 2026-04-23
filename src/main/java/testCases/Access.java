package testCases;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static estrutura.Parametros.*;
import estrutura.Init;
import io.qameta.allure.Description;
import page.HomePage;
import page.LoginPage;

public class Access extends Init{
	Registration register = new Registration();
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	
	@BeforeAll
	public void realizarCadastro() throws InterruptedException {
		register.createNewUser();
	}
	
	@Test
	@DisplayName("Logar na aplicação")
	@Description("Como um usuário, eu acesso o portal, informo meu usuário e senha e clico em "
			+ "acessar. Logo após, verifico se estou logado verificando se meu "
			+ "nome aparece com a mensagem de boas vindas")
	public void signIn() throws InterruptedException {
		
		login.userLogin(loginUsuario);
		login.password(password);
		login.btnAcessar();
		assertTrue(home.mensagemBoasVindas(nomeDoUsuario));
		
		
	}

}
