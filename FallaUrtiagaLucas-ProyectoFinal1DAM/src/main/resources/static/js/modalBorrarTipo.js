document.addEventListener("DOMContentLoaded", function() {
    
    let boton = document.querySelectorAll('button[data-bs-toggle="modal"]');
    
    boton.forEach(function(button) {
        
        button.addEventListener("click", function() {
            
            let id = button.getAttribute("data-id");
            
            document.getElementById('confirmarBorrado').href = '/admin/borrarTipo/' + id;
        });
    });
});