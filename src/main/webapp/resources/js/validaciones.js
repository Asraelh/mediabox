function checkForm(form){

  if(form.idusuario.value == "") {
    alertify.error("Error: El usuario no puede estar vacío.");
    form.username.focus();
    return false;
  }

  re = /^\w+$/;

  if(!re.test(form.idusuario.value)) {
    alertify.error("Error: El usuario solo puede contener letras y números.");
    form.username.focus();
    return false;
  }

  if(form.pwd0.value == ""){
    alertify.error("Error: Debe introducir su contraseña para poder realizar cambios.");
    form.pwd0.focus();
    return false;
  }

  if (form.pwd1.value != ""){

    if(form.pwd0.value == form.pwd1.value){
      alertify.error("Error: Debe introducir una contraseña distinta a la antigua.");
      form.pwd1.focus();
      return false;
    }

    if( form.pwd1.value == form.pwd2.value) {

      if(form.pwd1.value.length < 6) {
        alertify.error("Error: La contraseña debe contener más de 6 caracteres.");
        form.pwd1.focus();
        return false;
      }

      if(form.pwd1.value == form.idusuario.value) {
        alertify.error("Error: La contraseña debe ser distinta del nombre del usuario.");
        form.pwd1.focus();
        return false;
      }

      re = /[0-9]/;

      if(!re.test(form.pwd1.value)) {
        alertify.error("Error: La contraseña debe contener al menos un número (0-9)");
        form.pwd1.focus();
        return false;
      }

      re = /[a-z]/;

      if(!re.test(form.pwd1.value)) {
        alertify.error("Error: La contraseña debe contener al menos una letra en minúscula (a-z)!");
        form.pwd1.focus();
        return false;
      }

      re = /[A-Z]/;

      if(!re.test(form.pwd1.value)) {
        alertify.error("Error: La contraseña debe contener al menos una letra en mayúscula (A-Z)!");
        form.pwd1.focus();
        return false;
      }

    } else {

      alertify.error("Error: Comprueba que has introducido y confirmado tu contraseña!");
      form.pwd1.focus();
      return false;

    }

  }

  alert("Cambios realizados con éxito.");
  return true;
};
