const CANVAS = document.getElementById('canvas');
const TAM = 30;
document.body.style.setProperty('--largura', TAM);
document.body.style.setProperty('--altura', TAM);
const SNAKE = new Snake(TAM, TAM);
const FPS = 15;
let FOODS = [];
let looping = true;

function setup() {
    // Células do fundo do jogo
    for (let lin = 0; lin < TAM; lin++) {
        for (let col = 0; col < TAM; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            cell.dataset.lin = lin;
            cell.dataset.col = col;
            CANVAS.appendChild(cell);
        }
    }

    // Controles do jogo
    setas = ['ArrowUp', 'ArrowRight', 'ArrowDown', 'ArrowLeft']
    document.addEventListener('keydown', e => {
        if (setas.includes(e.key)) {
            e.preventDefault();
            SNAKE.setDirection(setas.indexOf(e.key));
        }
    });

    // Primeiras comidas
    for (let i = 0; i < 2; i++) addRandomFood();
}

function addRandomFood(){
    let f, x, y;
    do {
        x = getRndInteger(0, TAM);
        y = getRndInteger(0, TAM);
        f = new Food(x, y, 0);
    } while (contemPosicao(FOODS, x, y)
        ||   contemPosicao(SNAKE.body, x, y))
    FOODS.unshift(f);
}

function updateHTML(data, class_tag) {
    if (!Array.isArray(data)) return;
    if (!(typeof class_tag === 'string')) return;

    document
        .querySelectorAll(`.${class_tag}`)
        .forEach(o => o.classList.remove(class_tag));

    data.forEach(n => {
        const cell = document.querySelector(
            `.cell[data-lin="${n.y}"][data-col="${n.x}"]`
        )
        if (cell) {
            cell.classList.add(class_tag);
        }
    });
}

function loop() {
    // Dados
    SNAKE.update();
    for (let i = 0; i < FOODS.length; i++){
        let f = FOODS[i];
        if (f.x == SNAKE.x && f.y == SNAKE.y) {
            FOODS.splice(i, 1);
            SNAKE.size += 5;
            addRandomFood();
        }
    }
    for (let i = 1; i < SNAKE.body.length; i++){
        let p = SNAKE.body[i];
        if (p.x == SNAKE.x && p.y == SNAKE.y) {
            looping = false;
        }
    }

    // HTML
    updateHTML(FOODS, 'food');
    updateHTML(SNAKE.body, 'snake');
}

setup();
const intervalo = setInterval(
    () => {
        if (!looping) {
            clearInterval(intervalo);
            return;
        }
        loop();
    }, 1000 * (1 / FPS)
);