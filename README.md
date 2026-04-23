# Projeto de teste automático :robot:. BugBank

<!--ts-->
* [Objetivo](#objetivo)
* [Tecnologias utilizadas](#tecnologia)
* [Utilização/estrutura](#utilizacao)

<!--te-->

# <a name="objetivo"></a>Objetivo

Este projeto tem como objetivo demonstrar os meus conhecimentos sobre testes automatizados 
utilizando Java + Selenium WebDriver + Junit + Allure Report. 

A aplicação utilizada no teste se chama 'BugBank' e pode ser acessada através da url https://bugbank.netlify.app/

## <a name="tecnologia"></a>Tecnologias utilizadas
![Eclipse](icon/eclipse.png)
![java](icon/java.png)
![Junit](icon/JUnit5.png)
![Maven](icon/Maven.png)
![Selenium](icon/Selenium.png)
![Allure Report](icon/Allure.png)


**Linguagem:** Java

**Frameworks:** JUnit5, Selenium WebDriver 4.43.0

**Integrador/Compilador:** Maven

**Geração de relatório:** Allure Report 2.34.0

**IDE:** Eclipse

## <a name="utilizacao"></a>Utilização/estrutura

Realizar o download do projeto (via git clone ou arquivo zip).

Importar o projeto na sua IDE de desenvolvimento favorita

**Estrutura do projeto**

A estrutura principal do projeto está localizada no diretório src/main/java. Principais packages:
* testCases — Contém os casos de testes.
* estrutura — Contém as classes estruturais do projeto (base para outras classes).
* page — Contém o mapeamento dos elementos das páginas.

O projeto utiliza os conceitos de DSL e Page Object

**Explicando algumas classes**

  A classe **BasicSelenium** contém toda a parte Selenium utilizada.   

  A classe **AllureRepor** é responsável por gerar o arquivo final do relatório dos testes realizados. 

A classe **Util** contém métodos que facilitam a vida das classes de teste, é 
lá por exemplo, que são feitas as chamadas para 
o JavaFaker (é uma biblioteca que pode ser usada para gerar uma grande variedade 
de dados reais como nome, e-mails endereço, etc. Muito bom para gerar massa de dados). 
 
  A **package Page** contém todo o mapeamento de elementos do site. Para cada página do site, 
existe uma classe chamada NomePaginaPage que extende a classe BasicSelenium. Exemplo página de cadastro = CadastroPage. 

**Explicações extras**

Como a aplicação não tem um banco de dados para persistências das informações, 
eu faço a criação de um usuário, armazeno tudo em variável locais. 
A demonstração faz a criação de um novo usuário, coleta os dados, valida a mensagem de sucesso 
da criação. Logo depois realiza login na aplicação e faz a validação da mensagem de boas 
vindas verificando se o nome informado inicialmente aparece na mensagem. 

Ao termino do teste, é gerado um relatório contendo o passo a passo do que foi feito 
e os prints de tela apropriados. 

**Vídeo demonstrativo**
<video src="icon/DemonstracaoBugBank.mp4" controls="controls" width="100%" height="auto"></video>





  

