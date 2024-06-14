# Gerenciador de Biblioteca de Filmes

Este é um aplicativo desktop em Java para gerenciamento de uma biblioteca de filmes. O projeto permite adicionar, editar e excluir registros de filmes, além de listar todos os filmes armazenados.

## Funcionalidades

- Listagem de filmes usando JTable
- Adicionar novos filmes
- Editar filmes existentes
- Excluir filmes
- Integração com banco de dados MySQL para armazenamento persistente

## Tecnologias Utilizadas

- Java
- Swing para interface gráfica
- MySQL para banco de dados
- JDBC para conexão com o banco de dados

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL](https://www.mysql.com/downloads/)
- [IDE de sua preferência](https://www.jetbrains.com/idea/download/)

## Configuração do Banco de Dados

1. Crie um banco de dados no MySQL:
    ```sql
    CREATE DATABASE filmesdb;
    ```

2. Crie a tabela necessária:
    ```sql
    USE filmesdb;

    CREATE TABLE filmes (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        datalancamento DATE NOT NULL,
        categoria VARCHAR(100) NOT NULL
    );
    ```

3. Ajuste as configurações de conexão no código conforme necessário (usuário, senha, URL do banco de dados).

## Executando o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seuusuario/gerenciador-biblioteca-filmes.git
    ```

2. Importe o projeto na sua IDE.

3. Execute a classe `Main` para iniciar a aplicação.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

