const frente = document.getElementById('frente');
const meio = document.getElementById('meio');
const fundo = document.getElementById('fundo');

fundo.addEventListener(
    'click',
    event => {
        console.log('fundo');
    },
    {capture : true}
);

meio.addEventListener(
    'click',
    event => {
        console.log('meio');
    },
    {capture : false}
);

frente.addEventListener(
    'click',
    event => {
        event.stopPropagation();
        console.log('frente');
    },
    {capture : true}
);

// Formulário

const form = document.getElementById('formulario');

const cadastros = [];

form.addEventListener(
    'submit',
    event => {
        event.preventDefault();
        const in_email = document.getElementById('in_email').value;
        if (in_email === "") return;
        cadastros.push(in_email);
        console.log(cadastros);
    }
)

form.addEventListener(
    'submit',
    event => {
        event.preventDefault();
        const in_cor = document.getElementById('in_cor').value;
        frente.style.background = in_cor;
    }
)

// Setas

let keys = ["ArrowRight","ArrowDown","ArrowLeft","ArrowUp"];
//    3
//  2   0
//    1
let direcao = 0;

document.addEventListener(
    'keydown',
    event => {
        if (!(keys.includes(event.key))) return;
        event.preventDefault();
        const seta = document.getElementById('seta');
        let novaDirecao = keys.findIndex(val => val == event.key);
        if (direcao == 3 && novaDirecao == 0) {
            novaDirecao = 4;
        } else if (direcao == 0 && novaDirecao == 3) {
            novaDirecao = -1;
        }
        direcao = novaDirecao;
        seta.style.transform = `rotate(${direcao*90}deg)`;
    }
)



