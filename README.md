[![img](https://github.com/EraldoCarlosfh/ApiRest-StarWars/raw/main/img/sw.jpg)](https://github.com/EraldoCarlosfh/ApiRest-StarWars/blob/main/img/sw.jpg)

# 	API REST STAR WARS - ERALDO CARLOS

## Índice

1. [Sobre o projeto](https://github.com/EraldoCarlosfh/ApiRest-StarWars#1-sobre-o-projeto)

2. [Tecnologias utilizadas](https://github.com/EraldoCarlosfh/ApiRest-StarWars#2-tecnologias-utilizadas)

3. [Configurando a API](https://github.com/EraldoCarlosfh/ApiRest-StarWars#3configurando-a-api)

   [NO MAVEN](https://github.com/EraldoCarlosfh/ApiRest-StarWars#no-maven)

   [NO ECLIPSE](https://github.com/EraldoCarlosfh/ApiRest-StarWars#no-eclipse)

4. [Efetuando testes](https://github.com/EraldoCarlosfh/ApiRest-StarWars#4efetuando-testes)

5. [Funcionalidades](https://github.com/EraldoCarlosfh/ApiRest-StarWars#5funcionalidades)

   1. [Inserindo um planeta](https://github.com/EraldoCarlosfh/ApiRest-StarWars#i-inserindo-um-planeta)
   2. [Listando todos os planetas](https://github.com/EraldoCarlosfh/ApiRest-StarWars#ii-listando-todos-os-planetas)
   3. [Fazendo busca por ID](https://github.com/EraldoCarlosfh/ApiRest-StarWars#iii-fazendo-busca-por-id)
   4. [Fazendo busca por NOME](https://github.com/EraldoCarlosfh/ApiRest-StarWars#iv-fazendo-busca-por-nome)
   5. [Deletando um planeta](https://github.com/EraldoCarlosfh/ApiRest-StarWars#v-deletando-um-planeta)

6. [Considerações finais](https://github.com/EraldoCarlosfh/ApiRest-StarWars#6-considerações-finais)

### 1. Sobre o projeto

  O objetivo deste projeto é criar uma API rest que armazenará dados como nome de um planeta, clima e terreno. Retornando também a quantidade de aparições de cada planeta nos filmes de Star Wars registrada na API SWAPI. Esse projeto será consumido por um jogo criado pela B2W que aproveitará das informações da franquia.

### 2.Tecnologias utilizadas

  Para o presente projeto foi utilizado a linguagem Java na sua versão 8, Spring Boot 2.0 e a IDE Eclipse modificada para o framework Spring Boot(Spring Tools Suite). Para a persistência dos dados foi utilizado o banco de dados não relacional MongoDB e para testes da api o Postman junto com o framework JUNIT.

### 3.Configurando a API

  Para utilizar o projeto deverá ser instalado o [Java SDK 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html), o Eclipse, preferencialmente modificado para o Spring Boot([Spring Tools Suite](https://spring.io/tools/sts/all)) e o [MongoDB Community Server](https://www.mongodb.com/download-center?jmp=nav#community) baseado em seu sistema operacional.   Após isso Efetuar o download do projeto e inserir o mesmo no diretorio raiz do seu workspace do Eclipse.

####   NO MAVEN

  Primeiramente instalar o Apache Maven e setar suas variaveis de ambiente corretamente, acessar a pasta raiz do projeto pelo prompt, executar o comando "mvn package", aguardar baixar as dependências, aguardar executar os testes automatizados e ao terminar de buildar o projeto acessar na pasta raiz a pasta "target" lá estará o jar responsavel pela api, basta executa-lo junto com o mongodb que a api estará rodando em segundo plano, utilize o postman para fazer testes mais facilmente.

####   NO ECLIPSE

  Após importar o projeto, executar o mongoDB e dar Run em Spring Boot App no Eclipse.
  Pronto, a API já estará funcionando se o SWAPI estiver online, caso contrário a API retornará um erro 503 indicando que o SWAPI está fora do ar.

  **Obs1:** A propria API gera automaticamente o banco vazio no MongoDB caso não exista.
  **Obs2:** Se ocorrer algum problema da porta default, você poderá entrar em application.properties e mudar server.port para alguma outra porta que desejar.
  **Obs3:** Para finalizar a execução do projeto buildado no maven abra o prompt, digite o comando "netstat -a -n -o" procure o processo que está utilizando a porta que você configurou ex: "8080", pegue sua Pid e digite "taskkill -f -im "NÚMERO DO PID"".

### 4.Efetuando testes

  Com o Eclipse aberto, ir em src/test/Java e rodar o projeto com JUNIT, o sistema efetuará alguns testes de integração e alguns testes unitários, retornando verde se tudo deu certo ou vermelho se algo deu errado.(Normalmente quando você builda o projeto com mvn package ele já efetua os testes sozinho)

### 5.Funcionalidades

  Vejamos algumas funcionalidades da API, os exemplos estão considerando a porta padrão 8080:

#### I. Inserindo um planeta:

  Para inserir um planeta deve ser feita uma requisição post em json para o endpoint "/planetas".

  Ex: http://localhost:8080/planetas

```
{
   "nome": "Yavin IV",
   "clima": "Frio",
   "terreno": "jungle, rainforests"
}
```

  Será criado um novo planeta no banco de dados ao qual a ID será gerada automaticamente, não importando se o usuário setar uma id na hora da inserção. Se for inserido um nome, clima ou terreno com caractere vazio ou null na API, ela retornara o erro 400 de requisição inválida.

  Um planeta que não apareceu nos filmes também pode ser criado, porém seu numero de aparições será automaticamente 0.

#### II. Listando todos os planetas:

  Para listar todos os planetas basta fazer uma solicitação get para o endpoint "/planetas".

  Ex: http://localhost:8080/planetas

  Será retornado a id dos planetas, seu nome, seu clima, terreno e aparições em filmes no formato json. As aparições dos planetas são atualizadas a cada solicitação get, para caso haja alguma alteração no banco de dados do SWAPI ele retorne as aparições atualizadas.

#### III. Fazendo busca por ID:

  Para fazer uma busca por id você deverá fazer uma solicitação get para o endpoint "/planetas/" junto com a id que você quer pesquisar.

  Ex: http://localhost:8080/planetas/5afcf2bf1d5bad0100e51bda

  Caso seja inserida uma id inválida, será retornado o erro 404 não encontrado.

#### IV. Fazendo busca por NOME:

  Para fazer uma busca por nome você deverá fazer uma solicitação get para o endpoint "/planetas/buscanome?nome=" junto com o nome codificado que você quer pesquisar.

  Para codificar o valor que você quer, você pode abrir seu navegador, ir em ferramentas de desenvolvedor, depois console e digitar "encodeURIComponent("Nome do planeta")" o console retornará o nome do planeta codificado como no exemplo abaixo.

[![img](https://github.com/EraldoCarlosfh/ApiRest-StarWars/raw/main/img/Exemplo.png)](https://github.com/EraldoCarlosfh/ApiRest-StarWars/blob/main/img/Exemplo.png)

  Depois basta copiar o código gerado e inserir no final do endpoint informado acima o ""/planetas/buscanome?nome=".

  Ex: [http://localhost:8080/planetas/buscanome?nome=Yavin%20IV](http://localhost:8080/planetas/buscanome?nome=Yavin IV)

#### V. Deletando um planeta:

  Para deletar um planeta basta fazer uma solicitação delete para o endpoint "/planetas/" indicando a ID do planeta no final do endpoint.

  Ex: http://localhost:8080/planetas/1

  Caso esse planeta não exista ele retornará o erro 404 não encontrado.

### 6. Considerações finais

  API criada e documentada por Pedro Teixeira Bisognin, espero que gostem e **que a força esteja com voces!!!**

[![img](https://github.com/EraldoCarlosfh/ApiRest-StarWars/raw/main/img/rodap%C3%A9.jpg)](https://github.com/EraldoCarlosfh/ApiRest-StarWars/blob/main/img/rodapé.jpg)

