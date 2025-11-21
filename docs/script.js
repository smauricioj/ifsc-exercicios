// Global state
let allExercises = [];
let filteredExercises = [];

// DOM Elements
const exerciseContainer = document.getElementById('exerciseContainer');
const loading = document.getElementById('loading');
const noResults = document.getElementById('noResults');
const searchInput = document.getElementById('searchInput');
const disciplinaFilter = document.getElementById('disciplinaFilter');
const nivelFilter = document.getElementById('nivelFilter');
const tipoFilter = document.getElementById('tipoFilter');
const resetFilters = document.getElementById('resetFilters');
const exerciseCount = document.getElementById('exerciseCount');

// Load data
async function loadExercises() {
    try {
        const response = await fetch('./gabaritos.json');
        const data = await response.json();

        // Flatten all exercises into a single array
        allExercises = flattenExercises(data.disciplinas);
        filteredExercises = [...allExercises];

        renderExercises();
        updateStats();
        loading.style.display = 'none';
    } catch (error) {
        console.error('Erro ao carregar exercícios:', error);
        loading.innerHTML = '<p style="color: var(--color-avancado);">❌ Erro ao carregar exercícios. Tente recarregar a página.</p>';
    }
}

// Flatten nested exercise structure
function flattenExercises(disciplinas) {
    const exercises = [];

    for (const [disciplinaKey, disciplina] of Object.entries(disciplinas)) {
        if (disciplina.categorias) {
            for (const [categoriaKey, items] of Object.entries(disciplina.categorias)) {
                items.forEach(item => {
                    exercises.push({
                        ...item,
                        disciplina: disciplinaKey,
                        disciplinaNome: disciplina.nome,
                        linguagem: disciplina.linguagem,
                        categoria: categoriaKey
                    });
                });
            }
        }
    }

    return exercises;
}

// Render exercises
function renderExercises() {
    exerciseContainer.innerHTML = '';

    if (filteredExercises.length === 0) {
        noResults.style.display = 'block';
        return;
    }

    noResults.style.display = 'none';

    filteredExercises.forEach((exercise, index) => {
        const card = createExerciseCard(exercise);
        card.style.animationDelay = `${index * 0.05}s`;
        exerciseContainer.appendChild(card);
    });
}

// Create exercise card
function createExerciseCard(exercise) {
    const card = document.createElement('div');
    card.className = 'exercise-card';

    // Determine nivel class
    const nivelClass = exercise.nivel?.toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '') || 'basico';

    // Determine disciplina class
    let disciplinaClass = 'java';
    if (exercise.disciplina.includes('c')) disciplinaClass = 'c';
    if (exercise.disciplina.includes('frontend')) disciplinaClass = 'frontend';

    // Tags HTML
    const tagsHTML = exercise.tags && exercise.tags.length > 0
        ? `<div class="card-tags">
            ${exercise.tags.map(tag => `<span class="tag">#${tag}</span>`).join('')}
           </div>`
        : '';

    // Exercícios/Arquivos info
    let exerciciosInfo = '';
    if (exercise.exercicios && exercise.exercicios.length > 0) {
        exerciciosInfo = `<div class="card-info">
            📝 ${exercise.exercicios.length} arquivo(s): ${exercise.exercicios.slice(0, 3).join(', ')}${exercise.exercicios.length > 3 ? '...' : ''}
        </div>`;
    } else if (exercise.arquivos && exercise.arquivos.length > 0) {
        exerciciosInfo = `<div class="card-info">
            📄 ${exercise.arquivos.length} arquivo(s): ${exercise.arquivos.slice(0, 3).join(', ')}${exercise.arquivos.length > 3 ? '...' : ''}
        </div>`;
    } else if (exercise.compilar) {
        exerciciosInfo = `<div class="card-info">
            ⚙️ Compilar: <code>${exercise.compilar}</code>
        </div>`;
    }

    // Demo link (only for frontend)
    const demoButton = exercise.demo_link
        ? `<a href="${exercise.demo_link}" target="_blank" class="btn btn-demo">
            ▶️ Ver Demo
           </a>`
        : '';

    card.innerHTML = `
        <div class="card-header">
            <div class="card-badges">
                <span class="badge badge-nivel ${nivelClass}">${exercise.nivel || 'Básico'}</span>
                <span class="badge badge-disciplina ${disciplinaClass}">${exercise.linguagem}</span>
            </div>
        </div>
        
        <h3 class="card-title">${exercise.titulo}</h3>
        
        <p class="card-description">${exercise.descricao}</p>
        
        ${tagsHTML}
        
        <div class="card-actions">
            <a href="${exercise.github_link}" target="_blank" class="btn btn-primary">
                📂 Ver Código
            </a>
            ${demoButton}
        </div>
        
        ${exerciciosInfo}
    `;

    return card;
}

// Filter exercises
function filterExercises() {
    const searchTerm = searchInput.value.toLowerCase().trim();
    const disciplinaSelecionada = disciplinaFilter.value;
    const nivelSelecionado = nivelFilter.value;
    const tipoSelecionado = tipoFilter.value;

    filteredExercises = allExercises.filter(exercise => {
        // Search filter
        const matchesSearch = searchTerm === '' ||
            exercise.titulo.toLowerCase().includes(searchTerm) ||
            exercise.descricao.toLowerCase().includes(searchTerm) ||
            (exercise.tags && exercise.tags.some(tag => tag.toLowerCase().includes(searchTerm)));

        // Disciplina filter
        const matchesDisciplina = disciplinaSelecionada === 'todas' ||
            exercise.disciplina === disciplinaSelecionada;

        // Nivel filter
        const matchesNivel = nivelSelecionado === 'todos' ||
            (exercise.nivel && exercise.nivel.toLowerCase() === nivelSelecionado.toLowerCase());

        // Tipo filter
        const matchesTipo = tipoSelecionado === 'todos' ||
            exercise.categoria === tipoSelecionado;

        return matchesSearch && matchesDisciplina && matchesNivel && matchesTipo;
    });

    renderExercises();
    updateStats();
}

// Update stats
function updateStats() {
    const total = filteredExercises.length;
    const totalGeral = allExercises.length;

    if (total === totalGeral) {
        exerciseCount.textContent = `📚 ${total} exercícios disponíveis`;
    } else {
        exerciseCount.textContent = `🔍 ${total} de ${totalGeral} exercícios`;
    }
}

// Reset filters
function resetAllFilters() {
    searchInput.value = '';
    disciplinaFilter.value = 'todas';
    nivelFilter.value = 'todos';
    tipoFilter.value = 'todos';
    filterExercises();
}

// Event listeners
searchInput.addEventListener('input', filterExercises);
disciplinaFilter.addEventListener('change', filterExercises);
nivelFilter.addEventListener('change', filterExercises);
tipoFilter.addEventListener('change', filterExercises);
resetFilters.addEventListener('click', resetAllFilters);

// Keyboard shortcuts
document.addEventListener('keydown', (e) => {
    // Ctrl/Cmd + K to focus search
    if ((e.ctrlKey || e.metaKey) && e.key === 'k') {
        e.preventDefault();
        searchInput.focus();
    }

    // Escape to clear search
    if (e.key === 'Escape' && document.activeElement === searchInput) {
        searchInput.value = '';
        filterExercises();
    }
});

// Load exercises on page load
document.addEventListener('DOMContentLoaded', () => {
    loadExercises();

    // Add smooth scroll behavior
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });
});

// Utility: debounce function for better performance
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// Apply debounce to search
const debouncedFilter = debounce(filterExercises, 300);
searchInput.removeEventListener('input', filterExercises);
searchInput.addEventListener('input', debouncedFilter);
