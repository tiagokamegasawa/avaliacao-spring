# Avaliação Spring
### Objetivo
Projeto de avaliação para matéria de Spring da FIAP. 
O projeto consiste em um sistema para cartões de crédito para ser utilizado pelos alunos,
com integração com outras empresas. 

### Tecnologias
- Java
- Gradle
- Spring boot

### Executar na IDE

- A primeira execução da aplicação implicará na criação do banco de dados
e da execução da carga inicial de cadastro de alunos, o arquivo pode ser alterado no application.yml.

- Executar a classe AvaliacaoSpringApplication.

- Após a primeira execução, alterar a propriedade ***ddl-auto*** para ***validate***.   

### Principais Endpoints

- ***POST*** /alunos - Realiza o cadastro de novos alunos.

##### Payload de entrada:
      {
        "nome": "string",
        "rm": "string",
        "turma": "string"
      }

- ***PATCH*** /alunos/{id} - Adiciona um cartão para um aluno.

##### Payload de entrada:
      {
        "ultimosDigitos": "string"
      }

- ***GET*** /alunos/{id}/extrato - Obtém o extrato de todos os cartões de um aluno.

##### Payload de saída:
      {
        "cartoes": [
          {
            "aluno": {
              "id": 0,
              "nome": "string",
              "rm": "string",
              "turma": "string"
            },
            "id": 0,
            "transacoes": [
              {
                "dataHora": "YYYY-MM-DDTHH:mm:ss",
                "descricao": "string",
                "id": 0,
                "idCartaoCredito": 0,
                "valor": 0
              }
            ],
            "ultimosDigitos": "string"
          }
        ]
      }
      
- ***POST*** /transacoes - Realiza o cadastro de uma nova transação.

##### Payload de entrada:
    {
      "dataHora": "yyyy-MM-dd HH:mm:ss",
      "descricao": "string",
      "idCartao": 0,
      "valor": 0
    }