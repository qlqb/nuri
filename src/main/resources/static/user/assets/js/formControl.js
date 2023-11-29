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



function hasHideClass(variable) {
    return variable.classList.contains();
}

$proegress1.addEventListener('click', function () {
    if(hasHideClass($userForm) && hasHideClass($specificForm)) {
        $agreement.classList.toggle('notice-hide');
    }
    console.log('클릭');
})

$proegress2.addEventListener('click', function () {
    if(hasHideClass($agreement) && hasHideClass($specificForm)) {
        $userForm.classList.toggle('notice-hide');
    }
})

$proegress3.addEventListener('click', function () {
    if(hasHideClass($agreement) && hasHideClass($userForm)) {
        $userForm.classList.toggle('notice-hide');
    }
})

$agreementBtn.addEventListener('click', function (e) {
    if($terms1Check.checked && $terms2Check.checked) {
        $agreement.classList.toggle('notice-hide');
        $userForm.classList.toggle('notice-hide');
    } else {
        e.preventDefault();
    }
})