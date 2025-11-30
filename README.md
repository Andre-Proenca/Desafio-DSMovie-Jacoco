<div align="center">

# 🎥 DSMovie • Desafio de Testes Unitários com Jacoco  
### 🧪 JUnit • Mockito • Spring Boot • Jacoco

</div>

---

## 📘 Sobre o Desafio

Este repositório representa minha solução para o **Desafio DSMovie Jacoco**, parte de um curso que estou realizando.  
O objetivo é implementar **testes unitários para toda a camada de service** do projeto, utilizando **JUnit**, **Mockito** e medindo cobertura com **Jacoco**.

A exigência mínima para aprovação é implementar **12 dos 15 testes**, mas o ideal é alcançar **100% de cobertura**.

---

## 🎬 Sobre o projeto DSMovie

O **DSMovie** é uma aplicação de catálogo e avaliação de filmes, com funcionalidades como:

- 🔓 **Acesso público** aos dados dos filmes  
- 🔐 Operações de CRUD de filmes restritas a usuários **ADMIN**  
- ⭐ Avaliação de filmes liberada para usuários logados (**CLIENT** ou **ADMIN**)  
- 📊 Recalculo automático da **média das notas** e da **quantidade de avaliações** sempre que uma nova avaliação é registrada  

A entidade **Score** representa a nota (0 a 5) que cada usuário dá a um filme, e a entidade **Movie** armazena o score médio e o total de votos.

---

## 🧪 Testes a serem implementados

### 🎞️ **MovieServiceTests**

| Teste | Descrição |
|-------|-----------|
| `findAllShouldReturnPagedMovieDTO` | Deve retornar página de MovieDTO |
| `findByIdShouldReturnMovieDTOWhenIdExists` | Deve retornar MovieDTO se ID existir |
| `findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist` | Deve lançar exceção se ID não existir |
| `insertShouldReturnMovieDTO` | Inserção deve retornar MovieDTO |
| `updateShouldReturnMovieDTOWhenIdExists` | Atualização válida deve retornar MovieDTO |
| `updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist` | Deve lançar exceção ao atualizar ID inexistente |
| `deleteShouldDoNothingWhenIdExists` | Delete válido não deve lançar exceções |
| `deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist` | Deve lançar exceção ao deletar ID inexistente |
| `deleteShouldThrowDatabaseExceptionWhenDependentId` | Deve lançar exceção ao deletar ID dependente |

---

### ⭐ **ScoreServiceTests**

- `saveScoreShouldReturnMovieDTO`  
- `saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId`

---

### 👤 **UserServiceTests**

- `authenticatedShouldReturnUserEntityWhenUserExists`  
- `authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists`  
- `loadUserByUsernameShouldReturnUserDetailsWhenUserExists`  
- `loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists`

---

## 🎯 Competências Desenvolvidas

- ✔️ Testes unitários em **Spring Boot**  
- ✔️ Uso de **JUnit** e **Mockito** para simulação e validação de comportamento  
- ✔️ Medição de cobertura com **Jacoco**  
- ✔️ Boas práticas de testes automatizados  

---

## 📌 Nota pessoal

Este repositório tem fins educacionais e faz parte do meu desenvolvimento como programador backend — aprofundando conhecimentos em testes unitários e qualidade de código.
