package page;

import estrutura.BasicSelenium;
import static estrutura.Parametros.loginUsuario;
import static estrutura.Parametros.password;


public class LoginPage extends BasicSelenium{

	public void userLogin(String user) {
		logPassoAPasso("Inserir Login'",false);
		write("//input[@name='email']", loginUsuario);
	}
	
	public void password(String pass) {
		logPassoAPasso("Inserir Senha'",false);
		write("//input[@name='password']", password);
		
	}
	
	public void btnAcessar() {
		logPassoAPasso("Clicar em 'Acessar'",true);
		clickText("Acessar");
	}
	
	public void btnRegistrar() {
		logPassoAPasso("Clicar em 'Registrar'",true);
		clickText("Registrar");
	}
	
}
