# Escopo e objetivo

_Projeto criado para a disciplina de Processos de Software do Curso de Engenharia de Software na Universidade Católica do Salvador_.

Este projeto consiste em um site de notícias direcionado a Universidade. Haverão dois tipos de usuários, o moderador e o leitor, onde o moderador pode criar publicações enquanto os usuários poderão  interagir com com a mesma através de comentários.

## Iniciando...

- `git clone https://github.com/eduardowanderleydev/ucsalNews.git`
- `cd ucsalNews`

## Backend
Para entrar na pasta de backend do projeto : 
- `cd backend`

## Frontend
Para entrar na pasta de frontend do projeto :
- `cd frontend`
- `cd ucsal_news`


Agora você poderá executar os vários comandos abaixo.

## Pré-requisitos

### Frontend
- `nodejs`<br>
    Para rodar o projeto você precisa ter o nodejs instalado na sua máquina.

- `npm install`<br>
    Para instalar as dependências que estão sendo utilizadas no projeto.

### Backend
- `maven 3+ `<br>
- `java 11`<br>
  

## Limpar, compilar, executar testes de unidade e cobertura

- `mvn clean`<br>
  remove diretório _target_

- `mvn compile`<br>
  compila o projeto, deposita resultados no diretório _target_

- `mvn test`<br>
  executa todos os testes do projeto. Para executar apenas parte dos testes, por exemplo,
  aqueles contidos em uma dada classe execute `mvn -Dtest=NomeDaClasseTest test`. Observe
  que o sufixo do nome da classe de teste é `Test`. Para executar um
  único teste `mvn -Dtest=NomeDaClasseTest#nomeDoMetodo test`.

- `mvn verify -P cobertura`<br>
  executa testes de unidade e produz relatório de
  cobertura em _target/site/jacoco/index.html_ além de verificar se limite mínimo
  de cobertura, conforme configurado, é satisfeito.

## Executando a aplicação

### Backend
- `mvn spring-boot:run`<br>

### Frontend
- `npm start`<br>

## Documentação

- Aqui vai ficar o link do swagger

## Relatório do projeto

- `código para gerar relatório no sonarQube` <br>
