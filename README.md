
<h1 align="center">
    Publi-api
  <p><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/> <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/> <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white"/>
  <img src="https://img.shields.io/github/last-commit/Aguinaldofs/provina-socialnetwork?style=for-the-badge"></p>
</h1>
<h3 align="center">Aplicação baseado na primeira versão do Twitter!  </h3>



✍️ API Requirements
-----
### Must to have
- [x] Comunicar com uma API externa (desenvolvida pelo colaborador ou por terceiros).
- [x] Persistir dados num BD relacional (não relacional é "nice to have").
- [x] Apresentar alguns testes unitários e funcionais.

### Nice to have
- [ ] Organização do código.
- [ ] Logging.
- [ ] Segurança (ex: JWT).
- [x] Cache.

📝 Design Patterns
-----
  ### Model
  Detentor dos dados, recebe as informações do Controller, valida
  ou não e retorna a resposta adequada.

  ### Controller
  Fornece a comunicação entre o detentor dos dados e o cliente.

  ### Repository
  Interface de consulta e manipulação dos dados, utilizado para criar uma barreira de controle e segurança entre a aplicação e os dados.

  ### DTO
  Utilizado para transferir dados entre subsistemas do software.

  ### Form 
  Utilizado para receber dados entre subsistemas do software.


📚 Features
-----

  <table border="0" width="100%"
  >
  <tr>

  <td width="30%" valign="top" border="0">

  ## User
  - [x] CREATE
  - [x] LIST
  - [x] DELETE

  </td>
  <td width="30%" valign="top">

  ## Publication
  - [x] CREATE
  - [x] LIST
  - [x] DELETE

  </td>
  <td width="30%" valign="top">

  ## Comment
  - [x] CREATE
  - [x] LIST
  - [x] DELETE

  </td>
  
  <td width="30%" valign="top">

  ## Like
  - [x] CREATE
  - [x] LIST
  - [x] DELETE

  </td>

</tr>
</table>




💻 Setup
-----
- Clone and open in Eclipse IDE
- Install maven dependencies using IDE auto import or using the command ``mvn install``
- Browse ``http://localhost:8080``
    
