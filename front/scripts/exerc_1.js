// Utilitário
const tiposValidaveis = ["number", "string"];
function validaArr(arr, type) {
    // type deve ser dos tipos validáveis
    if ( !tiposValidaveis.includes(type) ) return false;
    // arr deve ser um array
    if ( !Array.isArray(arr) ) return false;
    // todo elemento de arr deve ser do tipo type
    for(var elemento of arr)
        if (typeof elemento !== type)
            return false;
    // se passou por tudo, é válido
    return true;
}

// Exercícios

// Exercício 1
function soma(arr) {
    if (!validaArr(arr, "number")) return null;
    let sum = 0;
    for(var elemento of arr) {
        sum += elemento;
    }
    return sum;
}

// Exercício 2
function media(arr) {
    if (!validaArr(arr, "number")) return null;
    return soma(arr)/arr.length;
}

// Exercício 3
function menor(arr) {
    if (!validaArr(arr, "number")) return null;
    let min = Infinity;
    for(var elemento of arr) {
        if(elemento < min) {
            min = elemento;
        }
    }
    return min;
}

// Exercício 4
function prata(arr) {
    if (!validaArr(arr, "number")) return null;
    let max = [-Infinity, -Infinity];
    for(var elemento of arr) {
        if(elemento > max[0]) {
            max.unshift(elemento);
            max.pop();
        }
    }
    return max[1];
}

// Exercício 5
function filtro(arr) {
    if (!validaArr(arr, "number")) return null;
    let ret = [];
    for(var elemento of arr) {
        if(elemento % 2 != 0) {
            ret.push(elemento);
        }
    }
    return ret;
}

// Exercício 6
function inverso(arr) {
    let ret = [];
    for(var elemento of arr) {
        ret.unshift(elemento);
    }
    return ret;
}

// Exercício 7

function hist(arr) {
    if (!validaArr(arr, "number")) return null;
    let faixas = [0, 0, 0, 0, 0];
    let n_faixas = faixas.length;
    let min = 0;
    let max = 100;
    let largura = max / n_faixas;
    let msg = "\n";
    for (let i = 0; i < n_faixas; i++) {
        var min_faixa = largura*i;
        var max_faixa = largura*(i+1);
        msg += `[${min_faixa}, ${max_faixa}] : `;
        for (let elemento of arr) {
            if (elemento <= min || elemento > max) continue;
            if (elemento >= min_faixa && elemento < max_faixa) {
                msg += "* ";
            }
        }
        msg += "\n";        
    }
    console.log(msg);
}

// Exercício 8
function verificador(arr) {
    if (!validaArr(arr, "string")) return null;
    let nomeBusca = prompt("Informe o nome");
    for(let nome of arr) {
        if (nome === nomeBusca){
            return true;
        }
    }
    return false;
}

// Exercício 9
function comparador(arr1, arr2) {
    if (!(Array.isArray(arr1) && Array.isArray(arr2))) return null;
    if (arr1.length != arr2.length) return false;
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] !== arr2[i]) {
            return false;
        }
    }
    return true;
}

// Exercício 10
function removedor(arr, idx) {
    if (   !Array.isArray(arr)
        ||  typeof idx !== "number"
        ||  idx < 0
        ||  idx >= arr.length ) return null;
    let ret = [];
    for (let i = 0; i < arr.length; i++) {
        if (i !== idx) {
            ret.push(arr[i]);
        }
    }
    return ret;
}

// Exercício 11
function palin(arr) {
    if (typeof arr === "string") {
        arr = arr.split("");
    }
    if (!validaArr(arr, "string")) return null;
    for (let i = 0; i < arr.length; i++){
        var j = arr.length - 1 - i;
        if (   arr[i].length !== 1
            || arr[i] !== arr[j] ) {
            return false;
        }
    }
    return true;
}

// Exercício 12
function intercalador(arr1, arr2) {
    if (   !Array.isArray(arr1)
        || !Array.isArray(arr2)
        || arr1.length !== arr2.length ) return null;
    let ret = [];
    for (i = 0; i < arr1.length; i++) {
        ret.push(arr1[i], arr2[i]);
    }
    return ret;
}

// Exercício 13
function compactador(arr) {
    if (!Array.isArray(arr)) return null;
    let ret = [];
    let last = null;
    for (let elemento of arr) {
        if (elemento !== last) {
            last = elemento;
            ret.push(elemento);
        }
    }
    return ret;
}