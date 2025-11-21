# 📚 IFSC Gabaritos - Documentação

Página estática para navegação dos gabaritos de exercícios de programação do IFSC - Campus São José.

## 🌐 Acesso

Acesse a página em: `https://smauricioj.github.io/ifsc-exercicios/`

## 📁 Estrutura

```
docs/
├── index.html      # Página principal
├── style.css       # Estilos
├── script.js       # Lógica e filtros
└── README.md       # Este arquivo
```

## ✨ Funcionalidades

### 🔍 Busca Inteligente
- Busca por título, descrição ou tags
- Resultados em tempo real
- Atalho: `Ctrl/Cmd + K` para focar na busca

### 🎯 Filtros
- **Disciplina**: Algoritmos (Java/C), POO, Frontend
- **Nível**: Básico, Intermediário, Avançado
- **Tipo**: Aulas, Listas, Projetos

### 📊 Recursos
- Contador de exercícios
- Links diretos para código no GitHub
- Demos ao vivo para exercícios frontend
- Tags para fácil identificação
- Design responsivo (mobile-friendly)

## 🎨 Design

O design foi inspirado no tema do "Untitled Goose Game", com cores suaves e pastéis:
- 🦆 Paleta de cores verde-bege
- 🎨 Animações suaves
- 📱 Totalmente responsivo
- ♿ Acessível

## 🚀 Como Funciona

1. A página carrega o arquivo `gabaritos.json` da raiz do repositório
2. Os exercícios são organizados e exibidos em cards
3. Filtros e busca funcionam em tempo real
4. Links levam diretamente para o código no GitHub

## 🔧 Manutenção

### Adicionar Novos Exercícios

1. Adicione o exercício no local apropriado do repositório
2. Atualize o arquivo `gabaritos.json` na raiz com os metadados
3. A página será automaticamente atualizada

### Estrutura do `gabaritos.json`

```json
{
  "disciplinas": {
    "nome-disciplina": {
      "nome": "Nome Completo",
      "linguagem": "Java/C/HTML/CSS/JS",
      "categorias": {
        "tipo": [
          {
            "id": "identificador-unico",
            "titulo": "Título do Exercício",
            "descricao": "Descrição breve",
            "path": "caminho/para/arquivo",
            "github_link": "URL completa",
            "demo_link": "URL demo (opcional)",
            "tags": ["tag1", "tag2"],
            "nivel": "básico/intermediário/avançado"
          }
        ]
      }
    }
  }
}
```

## 🛠️ Tecnologias

- HTML5
- CSS3 (com CSS Variables)
- JavaScript Vanilla (ES6+)
- JSON para metadados
- GitHub Pages para hospedagem

## 📝 Melhorias Futuras

- [ ] Sistema de favoritos (localStorage)
- [ ] Histórico de visualizações
- [ ] Modo escuro/claro
- [ ] Exportar lista de exercícios
- [ ] Integração com API do GitHub para mostrar stars/forks
- [ ] Comentários/discussões por exercício
- [ ] PWA (Progressive Web App)

## 🤝 Contribuindo

Encontrou um bug ou tem uma sugestão?
1. Abra uma [issue](https://github.com/smauricioj/ifsc-exercicios/issues)
2. Ou envie um Pull Request

## 📄 Licença

Este projeto é mantido pelo Prof. Sergio para fins educacionais no IFSC - Campus São José.

---

🦆 Feito com ❤️ para os alunos do IFSC
