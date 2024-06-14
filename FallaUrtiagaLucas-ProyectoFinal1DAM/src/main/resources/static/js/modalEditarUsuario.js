document.getElementById("formularioReg").addEventListener("submit", function(event) {
   event.preventDefault();

    const modal = new bootstrap.Modal(document.getElementById('modalEditarUsuario'));
    modal.show();

    document.getElementById('confirmarLogout').addEventListener('click', function() {
        modal.hide();
        event.target.submit();
    }, { once: true });

})