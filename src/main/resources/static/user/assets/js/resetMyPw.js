const $resetPw = document.querySelector('#resetPw');
const $resetPwCheck = document.querySelector('#resetPwCheck');

const $userId = document.querySelector('#userId');

const $pwAlert = document.querySelector('#pw-alert');
const $pwCheckAlert =  document.querySelector('#pwCheck-alert');

const $submitBtn = document.querySelector('#submit-btn');

function pwMatching (password1, password2) {
    return password1 === password2;
}

function pwRegexpCheck (value) {
    const pwRegexp = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
    return pwRegexp.test(value);
}

function printExistingMsg () {

}

// 변경 전 기존 DB의 비밀번호와 대조하여 중복되는지 검사
function isPwExisting () {
    fetch("/user/auth/isExistringPw", {
        method : "POST",
        headers : {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body : {
            "userId" : $userId.value,
            "resetPw" : $resetPw.value
        }
    })
        .then((response) => response.text())
        .then(existResult => {
            if(existResult != 1) {

            } else {

            }
        })
}

$resetPw.onkeyup = function () {
    if(pwRegexpCheck($resetPw.value)) {
        $pwAlert.classList.add('notice-hide');
    } else {
        $pwAlert.classList.remove('notice-hide');
        $pwAlert.classList.add('notice-show');
    }
}

$resetPwCheck.onkeyup = function () {
    if(pwMatching($resetPw.value, $resetPwCheck.value)) {
        $pwCheckAlert.classList.add('notice-hide');
    } else {
        $pwCheckAlert.classList.remove('notice-hide');
        $pwCheckAlert.classList.add('notice-show');
    }
}

$submitBtn.addEventListener('click', () => {
    if(pwMatching($resetPw.value, $resetPwCheck.value) && pwRegexpCheck($resetPw.value)) {

    }
})