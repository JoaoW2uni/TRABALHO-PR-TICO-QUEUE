# Sistema de Gestão de Filas da Clínica

Projeto em Java para simular o controle de filas de atendimento em uma clínica.

## Objetivo

O sistema permite:
- retirar senha de pacientes;
- encaminhar pacientes da fila de atendimento para a fila de consultas;
- chamar pacientes para consulta;
- listar as filas;
- verificar o próximo paciente em cada fila;
- gerar relatório de atendimentos;
- demonstrar o uso de métodos de fila que lançam exceção.

## Estrutura do projeto

```text
QUEUE/
├── src/
│   ├── Main.java
│   ├── Paciente.java
│   └── ServicoClinica.java
├── README.md
├── TESTES_REALIZADOS.md
└── .gitignore
```

## Requisitos

- Java JDK 17 ou superior
- Ambiente com terminal ou PowerShell

## Como executar

1. Abra o terminal na pasta do projeto.
2. Compile os arquivos Java:

```powershell
javac .\src\*.java
```

3. Execute o programa principal:

```powershell
java -cp .\src Main
```

## Menu do sistema

```text
1 - Retirar senha
2 - Chamar próximo na recepção (Fila 1 -> Fila 2)
3 - Chamar próximo para consulta
4 - Ver fila de atendimento
5 - Ver fila de consultas
6 - Ver próximo de cada fila (peek)
7 - Ver relatório
8 - Testar exceções
0 - Sair
```

## Funcionalidades principais

- Cadastro de pacientes com nome, CPF e prioridade.
- Emissão de senha para a fila de atendimento.
- Encaminhamento da fila de recepção para a fila de consultas.
- Atendimento médico e registro dos tempos de espera.
- Relatório com quantidade de pacientes em fila e tempo médio de espera.
- Tratamento de exceções em filas vazias.

## Testes

O registro dos testes executados está disponível em:

```text
TESTES_REALIZADOS.md
```

## Observações

- A fila de atendimento representa a recepção.
- A fila de consultas representa a espera para o atendimento médico.
- Pacientes prioritários têm preferência no atendimento.
- A estrutura foi desenvolvida com foco em listas e filas em Java.

## Autor

Projeto desenvolvido para estudo de filas e estrutura de dados em Java.
