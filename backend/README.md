## Backend
Para entrar na pasta de backend do projeto :
- `cd backend`

## Pré-requisitos

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

- `mvn spring-boot:run`<br>