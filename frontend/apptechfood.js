//const html = docuument.querySelector('html');
let username = "Matheus";
let password = "12345678";
function showPassword () {
    const eye=document.getElementById('eye');
    const eyeSlash=document.getElementById('eye-slash');
    const fieldPassword=document.getElementById('field-password');
    const fieldConfirmacao=document.getElementById('field-confirmacao');


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
document.getElementById('btn-cadastrar').addEventListener('click', function(e) {
    e.preventDefault();
    alert("Redirecionando para pagina de cadastro")
    window.location.href = "cadastro.html";
})

function verificarCadastro() {
    const fieldPassword = document.getElementById('field-password');
    const btnCadastrar = document.getElementById('btn-cadastrarpage');


    if(fieldPassword.value.length < 4){
        alert("Senha invalida, tente mais caracteres");
    } else {
        alert("Cadastro realizado com sucesso!")
    }



}
