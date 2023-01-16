# FULLSTACK-CHALLENGE-JAVA
Resolução do desafio técnico - JAVA FullStack Developer

### Para correta instalação e execução desse projeto, é recomendada ter globalmente instalado Tomcat 8.5, IntelliJ, MySQL e Maven.

## Execução
De imediato, utilize o IntelliJ como IDE para abrir o projeto, configure o Tomcat 8.5 para rodar o projeto web. Altere o arquivo 'persistence.xml' e coloque a conexão com o seu database.
Atente-se ao maven realizar o download das dependecias nele informadas.
![image](https://user-images.githubusercontent.com/100442318/212775098-7b1e29d8-3b1e-4f22-b288-fe4b5ac729ba.png)
# Documentação
**Busca por CEP**
----
  Busca a Unidade de Saude mais próxima

* **URL**

  http://localhost:8080/ProjectRang_war_exploded/

* **Método:**

  Pesquisando pelo CEP, ele retornará no DataTable a unidade que atende a faixa de CEP informado
  ![image](https://user-images.githubusercontent.com/100442318/212775759-6f102bd8-e81d-42ec-adfa-00a5e561ef55.png)
  **Caso não preencha nada, realizando a pesquisa retornará todos as Unidades de Saude.**
  
----
  **Nova Unidade**
----
  *  **Inserção de Unidade de Saude**
*  **URL**

  http://localhost:8080/ProjectRang_war_exploded/CadastroUnidade.xhtml

* **Método Nova Unidade**

  Realiza a inserção de uma nova Unidade de Saude, porém, caso informado uma CNES já existente retornará erro. Além disso, não permitirá cadastrar uma Unidade caso já exista alguma que cubra a faixa de CEP informada no cadastro:
  
  ![image](https://user-images.githubusercontent.com/100442318/212776225-72089dbb-b087-4187-98d7-f24e46f008e4.png)
  ![image](https://user-images.githubusercontent.com/100442318/212776237-69bb0c98-1500-46dd-a4eb-97057e0f55ba.png)
  ![image](https://user-images.githubusercontent.com/100442318/212776251-8ace3ce3-0c81-411d-8cef-eb2624dca57b.png)
  ![image](https://user-images.githubusercontent.com/100442318/212776254-2a6143bb-9160-47a1-8661-026b1f4864df.png)

----
  **Editar Unidade**
----
  
  * Selecionando uma linha da DataTable, pode-se clicar no botão editar, preencherá automaticamente os inputs e poed se realizar a alteração da Unidade<br />
    ![image](https://user-images.githubusercontent.com/100442318/212776897-ebdc5500-00d8-4857-847e-d347afd2bd37.png) ![image](https://user-images.githubusercontent.com/100442318/212776907-db97bd3c-eda5-4d4e-b1a7-ed2892588aa8.png)
    ![image](https://user-images.githubusercontent.com/100442318/212776919-b6ab6041-b94b-40cd-acaa-afea6555182a.png)

----
  **Excluir Unidade**
----
  * Selecionando uma linha da DataTable, pode-se clicar no botão excluir, aparece uma caixa de dialog confirmando tal ação, caso clicado em sim realizará a exclusão da Unidade<br />

  ![image](https://user-images.githubusercontent.com/100442318/212777174-90a63a4d-2054-4d9f-a0b1-d7e33f48e97c.png)
![image](https://user-images.githubusercontent.com/100442318/212777183-324c6806-a0c5-4ee6-9e42-1fc76210f2cb.png)



