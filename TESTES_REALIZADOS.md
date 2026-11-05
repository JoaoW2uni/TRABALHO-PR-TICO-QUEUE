# Testes realizados - Sistema de filas da clínica

## Comando executado

```powershell
cd /d "c:\Users\52420726\Downloads\QUEUE"
javac .\src\*.java
java -cp .\src TesteClinica
```

## Casos de teste executados

### 1. Fila vazia
Objetivo: verificar que o sistema não chama paciente quando não há ninguém nas filas.
Resultado: OK

### 2. Fila de consultas cheia
Objetivo: verificar que a recepção não encaminha um paciente quando a fila 2 estiver lotada.
Resultado: OK

### 3. Fluxo completo de um paciente
Objetivo: validar que um paciente consegue entrar na fila, ser atendido na recepção e depois ser chamado para a consulta.
Resultado: OK

### 4. Remove() em fila vazia tratando exceção
Objetivo: confirmar que a exceção é tratada corretamente quando a fila estiver vazia.
Resultado: OK

### 5. Ordem FIFO preservada
Objetivo: verificar que a ordem de chegada é mantida na fila.
Resultado: OK

## Saída do teste

```text
Fila de atendimento vazia.
Nao ha paciente na fila da consulta.
Teste 1: fila vazia -> OK
Senha emitida: Senha #001 | Nome: Pedro           | CPF: 111 | Chegada: 20:07:11
Senha emitida: Senha #002 | Nome: Paula           | CPF: 222 | Chegada: 20:07:11
Paciente Pedro foi atendido na recepcao.
Fila de consultas lotada. O paciente precisa esperar.
Teste 2: fila 2 cheia -> OK
Senha emitida: Senha #003 | Nome: Lucas           | CPF: 333 | Chegada: 20:07:11
Paciente Lucas foi atendido na recepcao.
Paciente Lucas foi chamado para a consulta.
Teste 3: fluxo completo de um paciente -> OK

--- TESTE DE EXCECOES ---
Tentando usar element()...
Nao tem paciente na fila de atendimento.
Tentando usar remove()...
Nao tem paciente na fila de consultas.
Teste 4: remove() em fila vazia tratando excecao -> OK
Senha emitida: Senha #004 | Nome: Ana             | CPF: 100 | Chegada: 20:07:11
Senha emitida: Senha #005 | Nome: Bia             | CPF: 200 | Chegada: 20:07:11
Senha emitida: Senha #006 | Nome: Carlos          | CPF: 300 | Chegada: 20:07:11
Paciente Ana foi atendido na recepcao.
Paciente Ana foi chamado para a consulta.
Paciente Bia foi atendido na recepcao.
Teste 5: ordem FIFO preservada -> OK
Todos os testes passaram.
```

## Resultado final

Todos os testes foram executados com sucesso.

Status: APROVADO
