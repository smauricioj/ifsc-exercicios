
// Estado global
let gabaritosData = null;
let currentTags = [];
let exercisesList = [];
let editMode = false;
let editingExercise = null;

// Categorias por disciplina
const categorias = {
    'alg-java': ['aulas', 'listas'],
    'poo': ['listas', 'projetos'],
    'alg-c': ['parte_1', 'parte_2', 'parte_3'],
    'frontend': ['aulas', 'projetos']
};

// Elementos DOM
const fileInput = document.getElementById('fileInput');
const disciplinaSelect = document.getElementById('disciplina');
const categoriaSelect = document.getElementById('categoria');
const tagInput = document.getElementById('tagInput');
const tagsContainer = document.getElementById('tagsContainer');
const exerciseForm = document.getElementById('exerciseForm');
const jsonPreview = document.getElementById('jsonPreview');
const alertContainer = document.getElementById('alertContainer');
const compilarGroup = document.getElementById('compilarGroup');
const exercisesListDiv = document.getElementById('exercisesList');

// Inicialização
init();

function init() {
    loadDefaultStructure();
    setupEventListeners();
    updatePreview();
    updateStats();
}

function loadDefaultStructure() {
    gabaritosData = {
        "info": {
            "titulo": "IFSC - Gabaritos de Exercícios",
            "descricao": "Repositório de gabaritos dos exercícios das disciplinas de Programação do IFSC - Campus São José",
            "autor": "Prof. Sergio",
            "github_repo": "https://github.com/smauricioj/ifsc-exercicios",
            "ultima_atualizacao": new Date().toISOString().split('T')[0]
        },
        "disciplinas": {
            "alg-java": {
                "nome": "Algoritmos (Java)",
                "linguagem": "Java",
                "descricao": "Exercícios de algoritmos e lógica de programação em Java",
                "path_base": "java/app/src/main/java/ifsc/alg",
                "categorias": { "aulas": [], "listas": [] }
            },
            "poo": {
                "nome": "Programação Orientada a Objetos",
                "linguagem": "Java",
                "descricao": "Exercícios de POO em Java",
                "path_base": "java/app/src/main/java/ifsc/poo",
                "categorias": { "listas": [], "projetos": [] }
            },
            "alg-c": {
                "nome": "Algoritmos (C)",
                "linguagem": "C",
                "descricao": "Exercícios de algoritmos e estruturas de dados em C",
                "path_base": "c",
                "categorias": { "parte_1": [], "parte_2": [], "parte_3": [] }
            },
            "frontend": {
                "nome": "Desenvolvimento Frontend",
                "linguagem": "HTML/CSS/JavaScript",
                "descricao": "Exercícios de desenvolvimento web frontend",
                "path_base": "front",
                "categorias": { "aulas": [], "projetos": [] }
            }
        }
    };
}

function setupEventListeners() {
    fileInput.addEventListener('change', handleFileUpload);
    disciplinaSelect.addEventListener('change', updateCategoriaOptions);
    tagInput.addEventListener('keydown', handleTagInput);
    exerciseForm.addEventListener('submit', handleFormSubmit);
    document.getElementById('btnDownload').addEventListener('click', downloadJSON);
    document.getElementById('btnCopy').addEventListener('click', copyJSON);
    document.getElementById('btnClearForm').addEventListener('click', clearForm);
    document.getElementById('btnCancelEdit').addEventListener('click', cancelEdit);
    document.getElementById('btnNewExercise').addEventListener('click', clearForm);
    disciplinaSelect.addEventListener('change', toggleCompilarField);
}

function handleFileUpload(e) {
    const file = e.target.files[0];
    if (!file) return;

    const reader = new FileReader();
    reader.onload = (event) => {
        try {
            gabaritosData = JSON.parse(event.target.result);
            showAlert('Arquivo carregado com sucesso!', 'success');
            updatePreview();
            updateStats();
            updateExercisesList();
        } catch (error) {
            showAlert('Erro ao ler arquivo JSON: ' + error.message, 'error');
        }
    };
    reader.readAsText(file);
}

function updateCategoriaOptions() {
    const disciplina = disciplinaSelect.value;
    categoriaSelect.innerHTML = '<option value="">Selecione...</option>';

    if (disciplina && categorias[disciplina]) {
        categorias[disciplina].forEach(cat => {
            const option = document.createElement('option');
            option.value = cat;
            option.textContent = cat.replace('_', ' ');
            categoriaSelect.appendChild(option);
        });
    }
}

function toggleCompilarField() {
    const disciplina = disciplinaSelect.value;
    compilarGroup.style.display = disciplina === 'alg-c' ? 'block' : 'none';
}

function handleTagInput(e) {
    if (e.key === 'Enter') {
        e.preventDefault();
        const tag = tagInput.value.trim();
        if (tag && !currentTags.includes(tag)) {
            currentTags.push(tag);
            renderTags();
            tagInput.value = '';
        }
    }
}

function renderTags() {
    const existingTags = tagsContainer.querySelectorAll('.tag');
    existingTags.forEach(tag => tag.remove());

    currentTags.forEach(tag => {
        const tagElement = document.createElement('div');
        tagElement.className = 'tag';
        tagElement.innerHTML = `
            ${tag}
            <button type="button" onclick="removeTag('${tag}')">×</button>
        `;
        tagsContainer.insertBefore(tagElement, tagInput);
    });
}

function removeTag(tag) {
    currentTags = currentTags.filter(t => t !== tag);
    renderTags();
}

function handleFormSubmit(e) {
    e.preventDefault();

    const exercicio = {
        id: document.getElementById('id').value.trim(),
        titulo: document.getElementById('titulo').value.trim(),
        descricao: document.getElementById('descricao').value.trim(),
        path: document.getElementById('path').value.trim(),
        github_link: document.getElementById('githubLink').value.trim(),
        tags: currentTags,
        nivel: document.getElementById('nivel').value
    };

    // Campos opcionais
    const demoLink = document.getElementById('demoLink').value.trim();
    if (demoLink) exercicio.demo_link = demoLink;

    const exerciciosInput = document.getElementById('exercicios').value.trim();
    if (exerciciosInput) {
        exercicio.exercicios = exerciciosInput.split(',').map(e => e.trim());
    }

    const arquivosInput = document.getElementById('exercicios').value.trim();
    if (arquivosInput && disciplinaSelect.value === 'frontend') {
        exercicio.arquivos = arquivosInput.split(',').map(e => e.trim());
    }

    const compilar = document.getElementById('compilar').value.trim();
    if (compilar) exercicio.compilar = compilar;

    const disciplina = disciplinaSelect.value;
    const categoria = categoriaSelect.value;

    if (!gabaritosData.disciplinas[disciplina].categorias[categoria]) {
        gabaritosData.disciplinas[disciplina].categorias[categoria] = [];
    }

    if (editMode && editingExercise) {
        // Modo de edição - atualizar exercício existente
        gabaritosData.disciplinas[editingExercise.disciplinaKey]
            .categorias[editingExercise.categoria][editingExercise.index] = exercicio;
        showAlert('Exercício atualizado com sucesso!', 'success');
        exitEditMode();
    } else {
        // Modo de adição - adicionar novo
        gabaritosData.disciplinas[disciplina].categorias[categoria].push(exercicio);
        showAlert('Exercício adicionado com sucesso!', 'success');
    }

    gabaritosData.info.ultima_atualizacao = new Date().toISOString().split('T')[0];

    updatePreview();
    updateStats();
    updateExercisesList();
    clearForm();
}

function clearForm() {
    exerciseForm.reset();
    currentTags = [];
    renderTags();
    disciplinaSelect.value = '';
    updateCategoriaOptions();
}

function updatePreview() {
    jsonPreview.textContent = JSON.stringify(gabaritosData, null, 2);
}

function updateStats() {
    let totalExercicios = 0;
    let totalCategorias = 0;

    Object.values(gabaritosData.disciplinas).forEach(disc => {
        Object.values(disc.categorias).forEach(cat => {
            totalExercicios += cat.length;
            if (cat.length > 0) totalCategorias++;
        });
    });

    document.getElementById('totalExercicios').textContent = totalExercicios;
    document.getElementById('totalDisciplinas').textContent = Object.keys(gabaritosData.disciplinas).length;
    document.getElementById('totalCategorias').textContent = totalCategorias;
}

function updateExercisesList() {
    const list = [];
    Object.entries(gabaritosData.disciplinas).forEach(([discKey, disc]) => {
        Object.entries(disc.categorias).forEach(([catKey, exercicios]) => {
            exercicios.forEach((ex, index) => {
                list.push({
                    disciplina: disc.nome,
                    disciplinaKey: discKey,
                    categoria: catKey,
                    titulo: ex.titulo,
                    id: ex.id,
                    exerciseData: ex,
                    index: index
                });
            });
        });
    });

    if (list.length === 0) {
        exercisesListDiv.innerHTML = 'Nenhum exercício ainda...';
        return;
    }

    exercisesListDiv.innerHTML = list.map((ex, idx) => `
        <div class="exercicio-item">
            <div>
                <strong>${ex.titulo}</strong><br>
                <small>${ex.disciplina} › ${ex.categoria}</small>
            </div>
            <div>
                <button onclick="editExercise(${idx})" style="background: #f0b464; margin-right: 5px;">✏️ Editar</button>
                <button onclick="deleteExercise('${ex.disciplinaKey}', '${ex.categoria}', ${ex.index})">🗑️ Deletar</button>
            </div>
        </div>
    `).join('');
}

function downloadJSON() {
    const dataStr = JSON.stringify(gabaritosData, null, 2);
    const blob = new Blob([dataStr], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'gabaritos.json';
    a.click();
    URL.revokeObjectURL(url);
    showAlert('Download iniciado!', 'success');
}

function copyJSON() {
    const jsonText = JSON.stringify(gabaritosData, null, 2);
    navigator.clipboard.writeText(jsonText).then(() => {
        showAlert('JSON copiado para área de transferência!', 'success');
    }).catch(err => {
        showAlert('Erro ao copiar: ' + err, 'error');
    });
}

function showAlert(message, type) {
    const alert = document.createElement('div');
    alert.className = `alert alert-${type}`;
    alert.textContent = message;
    alertContainer.appendChild(alert);

    setTimeout(() => {
        alert.remove();
    }, 5000);
}

// Expor função removeTag globalmente
window.removeTag = removeTag;

// Funções de edição e exclusão
window.editExercise = function (listIndex) {
    const list = [];
    Object.entries(gabaritosData.disciplinas).forEach(([discKey, disc]) => {
        Object.entries(disc.categorias).forEach(([catKey, exercicios]) => {
            exercicios.forEach((ex, index) => {
                list.push({
                    disciplinaKey: discKey,
                    categoria: catKey,
                    exerciseData: ex,
                    index: index
                });
            });
        });
    });

    const exerciseToEdit = list[listIndex];
    if (!exerciseToEdit) return;

    editMode = true;
    editingExercise = exerciseToEdit;

    // Preencher formulário
    disciplinaSelect.value = exerciseToEdit.disciplinaKey;
    updateCategoriaOptions();
    categoriaSelect.value = exerciseToEdit.categoria;

    const ex = exerciseToEdit.exerciseData;
    document.getElementById('id').value = ex.id || '';
    document.getElementById('titulo').value = ex.titulo || '';
    document.getElementById('descricao').value = ex.descricao || '';
    document.getElementById('path').value = ex.path || '';
    document.getElementById('githubLink').value = ex.github_link || '';
    document.getElementById('demoLink').value = ex.demo_link || '';
    document.getElementById('nivel').value = ex.nivel || 'básico';

    // Tags
    currentTags = ex.tags || [];
    renderTags();

    // Exercícios/Arquivos
    if (ex.exercicios) {
        document.getElementById('exercicios').value = ex.exercicios.join(', ');
    } else if (ex.arquivos) {
        document.getElementById('exercicios').value = ex.arquivos.join(', ');
    }

    // Compilar
    if (ex.compilar) {
        document.getElementById('compilar').value = ex.compilar;
    }

    toggleCompilarField();

    // Atualizar UI
    document.getElementById('editModeIndicator').style.display = 'block';
    document.getElementById('btnCancelEdit').style.display = 'inline-block';
    document.querySelector('.panel h2').textContent = '✏️ Editando Exercício';
    document.querySelector('button[type="submit"]').textContent = '💾 Salvar Alterações';
    document.querySelector('button[type="submit"]').classList.add('btn-secondary');
    document.querySelector('button[type="submit"]').classList.remove('btn-primary');

    // Scroll para o topo
    window.scrollTo({ top: 0, behavior: 'smooth' });

    showAlert('Modo de edição ativado. Altere os campos e clique em "Salvar Alterações".', 'info');
};

window.deleteExercise = function (disciplinaKey, categoria, index) {
    if (!confirm('Tem certeza que deseja deletar este exercício?')) return;

    gabaritosData.disciplinas[disciplinaKey].categorias[categoria].splice(index, 1);
    gabaritosData.info.ultima_atualizacao = new Date().toISOString().split('T')[0];

    showAlert('Exercício deletado com sucesso!', 'success');
    updatePreview();
    updateStats();
    updateExercisesList();
};

function exitEditMode() {
    editMode = false;
    editingExercise = null;

    // Restaurar UI
    document.getElementById('editModeIndicator').style.display = 'none';
    document.getElementById('btnCancelEdit').style.display = 'none';
    document.querySelector('.panel h2').textContent = '📝 Adicionar Novo Exercício';
    document.querySelector('button[type="submit"]').textContent = '✅ Adicionar Exercício';
    document.querySelector('button[type="submit"]').classList.remove('btn-secondary');
    document.querySelector('button[type="submit"]').classList.add('btn-primary');
}

function cancelEdit() {
    if (confirm('Deseja cancelar a edição? Alterações não salvas serão perdidas.')) {
        clearForm();
        showAlert('Edição cancelada.', 'info');
    }
}

function clearForm() {
    exerciseForm.reset();
    currentTags = [];
    renderTags();
    disciplinaSelect.value = '';
    updateCategoriaOptions();
    exitEditMode();
}