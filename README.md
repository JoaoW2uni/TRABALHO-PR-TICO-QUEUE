# Sistema de Gestão de Filas da Clínica

Projeto em Java para simular o controle de filas de atendimento em uma clínica.

## Objetivo

O sistema permite:
- retirar senha de pacientes;
- encaminhar pacientes da fila de atendimento para a fila de consultas;
- chamar pacientes para consulta;
- listar as filas;
- verificar o próximo paciente em cada fila;
- gerar relatório de atendimentos.

## Estrutura do projeto

```text
QUEUE/
├── src/
│   ├── Main.java
│   ├── Paciente.java
│   ├── ServicoClinica.java
│   └── TesteClinica.java
├── README.md
├── TESTES_REALIZADOS.md
└── .gitignore
```

## Requisitos

- Java JDK 17 ou superior
- Ambiente com terminal/PowerShell

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
4 - Listar fila de atendimento
5 - Listar fila de consultas
6 - Ver próximo de cada fila (peek)
7 - Relatório
0 - Sair
```

## Como executar os testes

```powershell
javac .\src\*.java
java -cp .\src TesteClinica
```

## Observações

- A fila de atendimento representa a recepção.
- A fila de consultas representa a espera para a consulta médica.
- Pacientes prioritários têm preferência no atendimento.
- O sistema também possui tratamento para exceções de fila vazia.

## Autor

Projeto desenvolvido para estudo de filas em Java.
