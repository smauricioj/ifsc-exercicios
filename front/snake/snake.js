class Snake {
    constructor(lar, alt) {
        this.canvas_lar = lar;
        this.canvas_alt = alt;
        this.x = getRndInteger(0, lar);
        this.y = getRndInteger(0, alt);
        this.body = [];
        this.incrementBody();
        this.size = 5;
        this.direction = null;
        this.vetores = [
            { x: 0, y: -1 },
            { x: 1, y: 0 },
            { x: 0, y: 1 },
            { x: -1, y: 0 },
        ]
    }

    incrementBody() {
        this.body.unshift({x: this.x, y: this.y});
        if (this.body.length > this.size) this.body.pop();
    }

    update() {
        if (this.direction == null) return;
        this.x += this.vetores[this.direction].x;
        this.y += this.vetores[this.direction].y;
        if (this.x >= this.canvas_lar) this.x = 0;
        if (this.y >= this.canvas_alt) this.y = 0;
        if (this.x < 0) this.x = this.canvas_lar - 1;
        if (this.y < 0) this.y = this.canvas_alt - 1;
        this.incrementBody();
    }

    setDirection(direction) {
        if (direction === opp_direction(this.direction)) return;
        this.direction = direction;
    }
}