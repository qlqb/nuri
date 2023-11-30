const $proegress1 = document.querySelector('#progress1')
const $proegress2 = document.querySelector('#progress2')
const $proegress3 = document.querySelector('#progress3')

const $agreement = document.querySelector('#agreement')
const $agreementBtn = document.querySelector('#agreement-btn')

const $userForm = document.querySelector('#userForm')
const $userFormBtn = document.querySelector('#user-btn')
const $specificForm = document.querySelector('#specificForm')

const $terms1Check = document.querySelector('#term1');
const $terms2Check = document.querySelector('#term2');

const $likeBtn = document.querySelectorAll('.like-button');

for (let i = 0; i < $likeBtn.length; i+=1) {
    $likeBtn[i].addEventListener('click', function(){
        formControl(i);
    })
}

function formControl (parameter){
    if(parameter === 0) {
        $specificForm.classList.add('notice-hide');
        $userForm.classList.add('notice-hide');
        $agreement.classList.remove('notice-hide');
    } else if(parameter === 1) {
        $specificForm.classList.add('notice-hide');
        $userForm.classList.remove('notice-hide');
        $agreement.classList.add('notice-hide');
    } else if(parameter === 2) {
        $specificForm.classList.remove('notice-hide');
        $userForm.classList.add('notice-hide');
        $agreement.classList.add('notice-hide');
    }
}