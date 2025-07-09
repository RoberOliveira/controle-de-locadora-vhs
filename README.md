Controle de Locadora de Fitas VHS

Sobre o Projeto

Este é um projeto acadêmico desenvolvido para a disciplina de Desenvolvimento Web III. O objetivo é criar uma aplicação web para a gestão de uma coleção de fitas VHS, utilizando uma arquitetura em camadas e persistindo os dados em um banco relacional. A aplicação permite o gerenciamento completo de fitas e suas respectivas categorias, além de possuir um sistema de controle de acesso para usuários.

Funcionalidades

    Gerenciamento de Fitas (CRUD):

        Inserção, listagem, atualização e exclusão de fitas VHS.

Capacidade de alterar o status de uma fita (Disponível, Emprestada, Indisponível).

Gerenciamento de Categorias (CRUD):

    Inserção, listagem, atualização e exclusão de categorias para as fitas (ex: Ação, Comédia, Drama).

Controle de Acesso:

    Sistema de autenticação que requer login para acessar as funcionalidades do sistema.

Validação de Formulários:

    Validação básica nos campos do formulário de cadastro de fitas para garantir a integridade dos dados.

Tecnologias Utilizadas

    Backend:

        Java 17

        Spring Boot: Framework principal para a construção da aplicação.

        Spring Web: Para a criação de controladores e endpoints web.

Spring Data JPA: Para a persistência de dados e abstração do banco de dados (ORM).

    Spring Security: Para a implementação do controle de acesso e autenticação.

    Hibernate: Implementação do JPA utilizada pelo Spring Data.

Frontend:

    Thymeleaf: Motor de templates para renderizar as páginas HTML do lado do servidor.

    HTML5 / CSS3

    Bootstrap 5: Framework CSS para estilização rápida dos componentes.

Banco de Dados:

    MySQL: Sistema de gerenciamento de banco de dados relacional.

    Build & Dependências:

        Maven: Ferramenta para gerenciamento de dependências e build do projeto.

Como Executar o Projeto

Siga os passos abaixo para executar o projeto localmente.

Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

    Java Development Kit (JDK) - Versão 17 ou superior.

    Apache Maven - Gerenciador de dependências.

    Banco de dados.

1. Clonar o Repositório

Bash

git clone https://github.com/RoberOliveira/controle-de-locadora-vhs.git
cd controle-de-locadora-vhs

2. Configurar o Banco de Dados

    Acesse o seu cliente MySQL e crie um novo banco de dados.
    SQL

CREATE DATABASE locadora_vhs_db;

Abra o arquivo de configuração da aplicação em:
src/main/resources/application.properties

Altere as seguintes propriedades com as suas credenciais do MySQL:
Properties

    spring.datasource.url=jdbc:mysql://localhost:3306/locadora_vhs_db?createDatabaseIfNotExist=true
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql

3. Executar a Aplicação

    Navegue até a raiz do projeto pelo terminal.

    Execute o seguinte comando para iniciar a aplicação:
    Bash

    ./mvnw spring-boot:run

    A aplicação estará disponível em http://localhost:8080.

🔑 Credenciais de Acesso

Para acessar o sistema, utilize as credenciais padrão criadas em memória:

    Usuário: user

    Senha: password