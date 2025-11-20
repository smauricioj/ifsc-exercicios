console.log(funcionarios);

// 1
function nomesOrdenados() {
    const lista = funcionarios.map(f => {
        return `${f.sobrenome}, ${f.nome}`;
    }).sort();
    return lista;
}
console.log(nomesOrdenados());

// 2
function idadesExtremas() {
    const extremos = {
        maisVelho: {
            nome: "",
            idade: -Infinity
        },
        maisNovo: {
            nome: "",
            idade: Infinity
        }
    };

    for (const { nome, sobrenome, idade } of funcionarios) {
        const nomeCompleto = `${nome} ${sobrenome}`;
        if (idade < extremos.maisNovo.idade) {
            extremos.maisNovo = { nome: nomeCompleto, idade: idade };
        }
        if (idade > extremos.maisVelho.idade) {
            extremos.maisVelho = { nome: nomeCompleto, idade: idade };
        }
    }
    return extremos;
}
console.log(idadesExtremas());

// 3
function funcionariosPorCidade() {
    const resultado = {};
    for (const { cidade, nome, sobrenome } of funcionarios) {
        const nomeCompleto = `${nome} ${sobrenome}`;
        if (!(cidade in resultado)) resultado[cidade] = []
        resultado[cidade].push(nomeCompleto);
    }
    return resultado;
}
console.log(funcionariosPorCidade());

// 4
function idadeMediaPorCargo() {
    const grupos = {};
    for (const { cargo, idade } of funcionarios) {
        if (!(cargo in grupos)) {
            grupos[cargo] = []
        }
        grupos[cargo].push(idade);
    }
    const medias = {};
    for (const cargo in grupos) {
        const idades = grupos[cargo];
        const soma = idades.reduce(
            (acumulado, valor) => acumulado + valor, 0
        );
        medias[cargo] = (idades.length > 0) ? soma / idades.length : 0;
    }
    return medias;
}
console.log(idadeMediaPorCargo());

// 5
function generoPorProjeto() {
    const grupos = {};
    for (const { projetos, genero } of funcionarios) {
        if (projetos.length == 0) continue;
        for (const projeto of projetos) {
            if (!(projeto in grupos)) {
                grupos[projeto] = { homens: 0, total: 0 };
            }
            if (genero == 'M') {
                grupos[projeto].homens++;
            }
            grupos[projeto].total++;
        }
    }
    const resultado = {};
    for (const projeto in grupos) {
        if (grupos[projeto].total > 0) {
            resultado[projeto] = grupos[projeto].homens / grupos[projeto].total;
        }
    }
    return resultado;
}
console.log(generoPorProjeto());

// 6
function metricasDependentes() {
    const resultado = {
        total: 0,
        mediaPorFuncionario: 0,
        idadeMedia: 0
    };
    let somaIdades = 0;
    for (const { dependentes } of funcionarios) {
        resultado.total += dependentes.length;
        for (const { idade } of dependentes) {
            somaIdades += idade;
        }
    }
    resultado.mediaPorFuncionario = (funcionarios.length > 0) ?
        resultado.total / funcionarios.length : 0;
    resultado.idadeMedia = (resultado.total > 0) ?
        somaIdades / resultado.total : 0;
    return resultado;
}
console.log(metricasDependentes());


// 7
function calculaCustos() {
    const valores = {
        total: 0,
        proporcaoBruto: 0,
        proporcaoBeneficio: 0
    };
    for (const { salario } of funcionarios) {
        const { bruto, beneficios } = salario;
        valores.total += bruto + beneficios;
        valores.proporcaoBruto += bruto;
        valores.proporcaoBeneficio += beneficios;
    }
    valores.proporcaoBruto /= valores.total;
    valores.proporcaoBeneficio /= valores.total;
    return valores
}
console.log(calculaCustos());

// 8
function equidadeSalarial() {
    const salariosDeCargos = {};
    for (const { salario, genero, cargo } of funcionarios) {
        let total = salario.bruto + salario.beneficios;
        if (!(cargo in salariosDeCargos)) {
            salariosDeCargos[cargo] = {
                M: { soma: 0, count: 0 },
                F: { soma: 0, count: 0 }
            }
        }
        salariosDeCargos[cargo][genero].soma += total;
        salariosDeCargos[cargo][genero].count += 1;
    }
    let somaRazoes = 0;
    let countRazoes = 0;
    for (const cargo in salariosDeCargos) {
        const salarios = salariosDeCargos[cargo];
        if (salarios.M.count > 0 && salarios.F.count) {
            let razaoMulheres = salarios.F.soma / salarios.F.count;
            let razaoHomens = salarios.M.soma / salarios.M.count
            somaRazoes += razaoMulheres / razaoHomens;
            countRazoes += 1
        }
    }
    return (countRazoes > 0) ? somaRazoes / countRazoes : 1;
}
console.log(equidadeSalarial());
