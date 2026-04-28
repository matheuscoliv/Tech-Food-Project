# Tech Food Project

> Projeto Integrador — 2º Semestre | ADS — PUC Goiás

Sistema de geração de planos alimentares personalizados com inteligência artificial. A aplicação utiliza a API do Google Gemini para gerar planos nutricionais com base no perfil do usuário, com persistência dos dados em MySQL e protótipo de interface web.

---

## Funcionalidades

- Geração de planos alimentares personalizados via Google Gemini API
- Conversão dos planos gerados para formato JSON via biblioteca Gson
- Cadastro e autenticação de usuários (idoso e responsável)
- Persistência de dados no banco MySQL via JDBC
- Gerenciamento de lembretes
- Protótipo de interface web com HTML, CSS e JavaScript

---

## Tecnologias

### Backend
| Tecnologia | Uso |
|---|---|
| Java | Linguagem principal |
| POO | Modelagem com herança (Usuario, UsuarioIdoso, UsuarioResponsavel) |
| JDBC + MySQL Connector J 9.5 | Conexão direta com banco de dados |
| Google Gemini API (Generative AI) | Geração de planos alimentares com IA |
| Gson | Conversão dos planos gerados para JSON |

### Banco de Dados
| Tecnologia | Uso |
|---|---|
| MySQL | Banco de dados relacional |

### Frontend
| Tecnologia | Uso |
|---|---|
| HTML5 + CSS3 | Estrutura e estilização das páginas |
| JavaScript | Lógica de interface |

---

## Estrutura do Projeto

```
Tech-Food-Project/
├── frontend/
│   ├── indexs/
│   │   ├── index.html         # Página principal
│   │   ├── login.html         # Tela de login
│   │   ├── cadastro.html      # Cadastro de usuário
│   │   ├── indexplano.html    # Visualização do plano alimentar
│   │   └── lembretes.html     # Gerenciamento de lembretes
│   ├── styles/                # Folhas de estilo CSS
│   └── apptechfood.js         # Lógica JavaScript
├── src/main/java/br/com/techfood/
│   ├── Conexao.java           # Gerenciamento da conexão com o banco
│   ├── Main.java              # Ponto de entrada da aplicação
│   ├── usuarios/
│   │   ├── Usuario.java           # Classe abstrata base
│   │   ├── UsuarioIdoso.java      # Usuário do tipo idoso
│   │   └── UsuarioResponsavel.java# Usuário responsável
│   ├── planosAlimentares/
│   │   ├── PlanoAlimentar.java    # Geração do plano via Gemini API
│   │   ├── PlanoConvertido.java   # Conversão do plano para JSON
│   │   └── ClassificarPlano.java  # Interface de classificação
│   └── lembretes/
│       └── Lembretes.java         # Gerenciamento de lembretes
├── BibliotecaBD_MySql/        # Driver MySQL Connector J 9.5.0
└── pom.xml
```

---

## Equipe

| Nome | GitHub |
|---|---|
| Kevin Willian | [@Kevin-willian](https://github.com/Kevin-willian) |
| Matheus Henrique | [@matheuscoliv](https://github.com/matheuscoliv) |
| Kaiky Lobo| [@KaikyLobo](https://github.com/KaikyLobo) |

---

## Licença

Este projeto foi desenvolvido para fins acadêmicos como projeto integrador do 2º semestre do curso de Análise e Desenvolvimento de Sistemas da PUC Goiás.
