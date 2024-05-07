//-- Seguridad de la contraseña -----------------------------------------------------------------------------------------------------------------------

    /*Tiene letras y números: +30%
    Tiene mayúsculas y minúsculas: +30%
    Tiene entre 4 y 5 caracteres: +10%
    Tiene entre 6 y 8 caracteres: +30%
    Tiene más de 8 caracteres: +40%*/

    function tiene_numeros(texto) {
        let numeros = "0123456789";

        for (i = 0; i < texto.length; i++) {
          if (numeros.indexOf(texto.charAt(i), 0) != -1) {
            return 1;
          }
        }
        return 0;
      }

      function tiene_letras(texto) {
        let letras = "abcdefghyjklmnñopqrstuvwxyz";

        texto = texto.toLowerCase();
        for (i = 0; i < texto.length; i++) {
          if (letras.indexOf(texto.charAt(i), 0) != -1) {
            return 1;
          }
        }
        return 0;
      }
  
      function tiene_minusculas(texto) {
        let letras = "abcdefghyjklmnñopqrstuvwxyz";

        for (i = 0; i < texto.length; i++) {
          if (letras.indexOf(texto.charAt(i), 0) != -1) {
            return 1;
          }
        }
        return 0;
      }
  
      function tiene_mayusculas(texto) {
        let letras_mayusculas = "ABCDEFGHYJKLMNÑOPQRSTUVWXYZ";

        for (i = 0; i < texto.length; i++) {
          if (letras_mayusculas.indexOf(texto.charAt(i), 0) != -1) {
            return 1;
          }
        }
        return 0;
      }
  
      function getPasswordSecurity(password) {
        let secValue;
        let lengthSecurityValues = [0, 0, 0, 0, 10, 10, 30, 30, 30];

        if(password.length >= lengthSecurityValues.length) {
          secValue = 40;
        } else {
          secValue = lengthSecurityValues[password.length];
        }
        if (tiene_numeros(password) && tiene_letras(password)) {
          secValue += 30;
        }
        if (tiene_minusculas(password) && tiene_mayusculas(password)) {
          secValue += 30;
        }
        return secValue;
      }

      function mostrarMensajito() {
        let nivelSeguridad = document.querySelector('.segContra');
        let mensajito;

        if(getPasswordSecurity>=1 && getPasswordSecurity<=25){
            nivelSeguridad.classList.remove("contraModerada", "contraFuerte", "contraSegura", "segContra");
			      nivelSeguridad.classList.add("contraDebil");
            mensajito = "Débil";
        }else{
            mensajito = "";
        }
        if(getPasswordSecurity>25 && getPasswordSecurity<=50){
            nivelSeguridad.classList.remove("contraDebil", "contraFuerte", "contraSegura", "segContra");
			      nivelSeguridad.classList.add("contraModerada");
            mensajito = "Moderada";
        }
        if(getPasswordSecurity>50 && getPasswordSecurity<=75){
            nivelSeguridad.classList.remove("contraDebil", "contraModerada", "contraSegura", "segContra");
			      nivelSeguridad.classList.add("contraFuerte");
            mensajito = "Fuerte";
        }
        if(getPasswordSecurity>75){
            nivelSeguridad.classList.remove("contraDebil", "contraModerada", "contraFuerte", "segContra");
			      nivelSeguridad.classList.add("contraSegura");
            mensajito = "Segura";
        }
        return mensajito;
      }
  
      document.getElementById('contrasenha1Reg').addEventListener('keyup', function(e) {
        document.getElementById('segContrasenhaReg').innerText = getPasswordSecurity(e.target.value) + "% " + mostrarMensajito();
      });
