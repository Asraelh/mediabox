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

  if(form.email.value == ""){
    alertify.error("Error: Debe introducir un email válido. Formato: 'x@x.com/es'");
    form.pwd0.focus();
    return false;
  }

  if(form.password.value == ""){
    alertify.error("Error: Debe introducdir una contraseña.");
    form.pwd1.focus();
    return false;
  }

  if(form.re_password.value == ""){
    alertify.error("Error: Debe repetir la contraseña.");
    form.pwd1.focus();
    return false;
  }

  if(form.password.value != form.re_password.value){
    alertify.error("Error: Debe repetir correctamente la contraseña.");
    form.pwd1.focus();
    return false;

  }else{

    if(form.password.value.length < 6) {
      alertify.error("Error: La contraseña debe contener más de 6 caracteres.");
      form.password.focus();
      return false;
    }

    if(form.password.value == form.idusuario.value) {
      alertify.error("Error: La contraseña debe ser distinta del nombre del usuario.");
      form.password.focus();
      return false;
    }

    re = /[0-9]/;

    if(!re.test(form.password.value)) {
      alertify.error("Error: La contraseña debe contener al menos un número (0-9)");
      form.password.focus();
      return false;
    }

    re = /[a-z]/;

    if(!re.test(form.password.value)) {
      alertify.error("Error: La contraseña debe contener al menos una letra en minúscula (a-z)!");
      form.password.focus();
      return false;
    }

    re = /[A-Z]/;

    if(!re.test(form.password.value)) {
      alertify.error("Error: La contraseña debe contener al menos una letra en mayúscula (A-Z)!");
      form.password.focus();
      return false;
    }

  }

  alert("Cambios realizados con éxito.");

  return true;
};
