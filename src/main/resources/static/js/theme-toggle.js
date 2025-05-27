document.addEventListener('DOMContentLoaded', function () {
    const toggleButton = document.getElementById('toggle-theme');
    const iconLink = document.getElementById('app-icon');
    const body = document.body;

    const currentTheme = localStorage.getItem('theme');

    // Aplica tema salvo
    if (currentTheme === 'dark') {
        body.classList.add('dark-mode');
        toggleButton.innerHTML = '<i class="bi bi-sun me-1"></i>';
        if (iconLink) iconLink.href = './img/icon-dark.png';
    }

    toggleButton?.addEventListener('click', () => {
        body.classList.toggle('dark-mode');
        const isDark = body.classList.contains('dark-mode');

        toggleButton.innerHTML = isDark
            ? '<i class="bi bi-sun me-1"></i>'
            : '<i class="bi bi-moon me-1"></i>';

        localStorage.setItem('theme', isDark ? 'dark' : 'light');
        if (iconLink) iconLink.href = isDark ? './img/icon-dark.png' : './img/icon-light.png';
    });
});
