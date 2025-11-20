// Exercício 1
// (a)
let pessoa = {
    nome: "Sergio P.",
    idade: 30,
    cidade: "Palhoça"
};
console.log(pessoa);

// (b)
console.log(`Olá, meu nome é ${pessoa.nome} e tenho ${pessoa.idade} ano${pessoa.idade > 1 ? 's' : ''}`);

// (c)
pessoa.profissao = {
    cargo: "Professor",
    salario: 1000,
    cargaHoraria: 40
};
delete pessoa.cidade;
console.log(pessoa);

// Exercício 2
// (a)
let livro = {
    titulo: "Dom Casmurro",
    ano: 1899,
    autor: {
        primeiroNome: "Machado de",
        sobrenome: "Assis"
    }
}

// (b)
console.log(`Nome completo: ${livro.autor.primeiroNome} ${livro.autor.sobrenome}`);
console.log(`Nome completo: ${livro["autor"]["primeiroNome"]} ${livro["autor"]["sobrenome"]}`);

// (c)
livro.citacao = function () {
    return `(${this.autor.sobrenome.toUpperCase()}, ${this.ano})`
}

// (d)
console.log(livro.citacao());

// Exercício 3
// (a)
let animal = {
    tipo: "mamífero",
    falar() {
        console.log("O animal faz um som.");
    }
}

// (b)
let cachorro = Object.create(animal);

// (c)
cachorro.nome = "Sherlock";
cachorro.falar = function () {
    console.log(`O cachorro ${this.nome} late!`);
}

// (d)
animal.falar();
cachorro.falar();

// Exercício 4
// (a)
let filme = {
    titulo: "Tudo em Todo o Lugar ao Mesmo Tempo",
    anoLancamento: 2022,
    duracao: {
        horas: 2,
        minutos: 19
    },
    generos: [
        "Aventura",
        "Ficção Científica",
        "Artes Marciais",
        "Comédia",
        "Drama"
    ],
    direcao: [
        {
            nome: "Daniel",
            sobrenome: "Kwan"
        },
        {
            nome: "Daniel",
            sobrenome: "Schrinert"
        }
    ]
}

// (b) + (c)
const imprimir = function (obj) {
    if (typeof obj != "object" || Array.isArray(obj)) return;

    const propertiesByType = {
        "string": [],
        "number": [],
        "array": [],
        "object": []
    }

    for (const prop in obj) {
        const val = obj[prop];
        const type = typeof val;
        if (!(type in propertiesByType)) continue;
        if (type === "object" && Array.isArray(val)) {
            type = "array";
        }
        propertiesByType[type].push(prop);
    }

    msg = "";
    for (const type in propertiesByType) {
        const properties = propertiesByType[type];
        if (properties.length == 0) continue;
        msg += `${type} (n = ${properties.length}) : ${properties}\n`
    }
    console.log(msg);
}

// (d)
imprimir(filme);

// Exercício 5
fetch('../data/data.json')
    .then(res => res.json())
    .then(obj => {
        const resultado = extrairValores(obj);
        if (resultado) console.log(resultado);
    });

function extrairValores(obj) {
    function isArrayLen1(arr) {
        return (Array.isArray(arr) && arr.length >= 1);
    }
    if (!isArrayLen1(obj)) return null;
    const resultados = obj[0].resultados;
    if (!isArrayLen1(resultados)) return null;
    const series = resultados[0].series;
    if (typeof series != "object" || Array.isArray(series)) return null;
    const valores = {};
    for (const { localidade, serie } of series) {
        const key = localidade.nome;
        const val = parseFloat(serie["2022"]);
        if (typeof key != "string" || val == NaN) continue;
        valores[localidade.nome] = val;
    }
    return valores;
}