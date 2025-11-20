function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

function opp_direction(dir) {
    if (dir == null) return null;
    return (dir + 2) % 4;
}

function contemPosicao(arr, x, y) {
    return arr.some(p => p.x === x && p.y === y);
}