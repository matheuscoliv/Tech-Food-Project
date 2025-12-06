//const html = docuument.querySelector('html');
let username = "Matheus";
let password = "12345678";
function showPassword () {
    const eye=document.getElementById('eye');
    const eyeSlash=document.getElementById('eye-slash');
    const fieldPassword=document.getElementById('field-password');

    if(eye.style.display ==='none') {
        eye.style.display = 'block';
        eyeSlash.style.display = 'none';
        fieldPassword.type = 'text';
    } else {
        eye.style.display = 'none';
        eyeSlash.style.display = 'block';
        fieldPassword.type = 'password';

    }
}

document.getElementById('btn-login').addEventListener('click', function(e) {
    e.preventDefault();

    if(username == "Matheus" && password == "12345678"){
        alert('Logado!')
        window.location.href = "index.html";
    }
})