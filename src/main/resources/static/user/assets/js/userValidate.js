const $userId = document.querySelector('#userId');
const $userPw = document.querySelector('#userPw');
const $userPwCheck = document.querySelector('#userPwCheck');
const $userName = document.querySelector('#userName');
const $userBirth = document.querySelector('#userBirth');
const $userContact = document.querySelector('#userContact');
const $userEmail = document.querySelector('#userEmail');
const $regionInput = document.querySelector('#regionCode');
const $districtInput = document.querySelector('#districtCode');
const $address1 = document.querySelector('#address1');
const $address2 = document.querySelector('#address2');

const $idAlert1 = document.querySelector('#id-alert1');
const $idAlert2 = document.querySelector('#id-alert2');

// 아이디 입력 EventListener
$userId.addEventListener('focusout', () => {
    if(idRegexpCheck($userId.value)) {
        $idAlert2.classList.add('notice-hide')
        idDuplicationCheck($userId.value)
    } else {
        $idAlert2.classList.add('notice-show')
        $idAlert2.classList.remove('notice-hide')
    }
})

// 아이디 유효성 정규식
function idRegexpCheck (value) {
    const idRegexp = /^[a-zA-Z][0-9a-zA-Z]{5,19}$/;
    return idRegexp.test(value);
}

// 아이디 ajax 중복검사
function idDuplicationCheck (value) {
    let checkResult = false;
    fetch("/user/register/userIdCheck", {
        method : 'POST',
        headers : {
            "Content-Type" : "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
            "checkId" : value,
        })
    }).then((responseData) => responseData.json())
        .then(jsonData => {
            if(jsonData.checkedValue) {
                $idAlert1.classList.add('notice-hide');
            } else {
                $idAlert1.classList.add('notice-show')
                $idAlert1.classList.remove('notice-hide')
            }
        })
};

const $pwAlert = document.querySelector('#pw-alert');



// 비밀번호 유효성 검사
function pwRegexpCheck (value) {
    const pwRegexp = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
    return pwRegexp.test(value);
}

// 비밀번호 확인 검사
function pwMatching (password1, password2) {
    if(password1 === password2) {
        return true;
    }
    return false;
}

$userPw.onkeyup = function () {
    if(pwRegexpCheck($userPw.value)) {
        $pwAlert.classList.add('notice-hide')
    } else {
        $pwAlert.classList.add('notice-hide')
        $pwAlert.classList.remove('notice-hide')
    }
}

const $pwCheckAlert = document.querySelector('#pw-checkAlert');

$userPwCheck.onkeyup = function () {
    if(pwMatching($userPw.value, $userPwCheck.value)) {
        $pwCheckAlert.classList.add('notice-hide')
    } else {
        $pwCheckAlert.classList.add('notice-hide')
        $pwCheckAlert.classList.remove('notice-hide')
    }
}

const $nameAlert = document.querySelector('#name-alert');



$userName.addEventListener('focusout', () => {
    if(nameCheck($userName.value)) {
        $nameAlert.classList.add('notice-hide')
    } else {
        $nameAlert.classList.add('notice-hide')
        $nameAlert.classList.remove('notice-hide')
    }
})

// 한글 이름 유효성 검사
function nameCheck (value) {
    const nameRegexp = /[가-힣]/;
    return nameRegexp.test(value);
}

const $dateCheck = document.querySelector('#dateCheck');

$userBirth.addEventListener('focusout', () => {
    const refDate = getToday(7);
    if(birthDateCheck($userBirth.value ,refDate)) {
        $dateCheck.classList.add('notice-hide')
    } else {
        $dateCheck.classList.add('notice-hide')
        $dateCheck.classList.remove('notice-hide')
    }
})

// 생년월일 체크 (7세 미만 가입불가)
function birthDateCheck(inputDate, refDate) {
    return inputDate < refDate;
}

function getToday(distract) {
    let date = new Date();
    let year = date.getFullYear() - distract;
    let month = ("0" + (1 + date.getMonth())).slice(-2);
    let day = ("0" + date.getDate()).slice(-2);
    return year + "-" + month + "-" + day;
}

const $contactAlert = document.querySelector('#contact-alert');

$userContact.addEventListener('focusout', () => {
    if(contactCheck($userContact.value)) {
        $contactAlert.classList.add('notice-hide')
    } else {
        $contactAlert.classList.add('notice-hide')
        $contactAlert.classList.remove('notice-hide')
    }
})

// 연락처(휴대폰 유효성 검사)
function contactCheck (value) {
    const userContactRegexp = /^(?:(010)|(01[1|6|7|8|9]))-\d{3,4}-(\d{4})$/;
    return userContactRegexp.test(value);
}

const $mailAlert = document.querySelector('#mail-alert');

$userEmail.addEventListener('focusout', () => {
    if(mailCheck($userEmail.value)) {
        $mailAlert.classList.add('notice-hide')
    } else {
        $mailAlert.classList.add('notice-hide')
        $mailAlert.classList.remove('notice-hide')
    }
})

// 메일 입력값 유효성 검사
function mailCheck (value) {
    const userMailRegexp = /[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$/i;
    return userMailRegexp.test(value);
}

const $regionAlert = document.querySelector('#region-alert');

$regionInput.addEventListener('focusout', () => {
    if($regionInput.value == null || $regionInput.value == "" || $regionInput.value == undefined) {
        $regionAlert.classList.add('notice-hide')
        $regionAlert.classList.remove('notice-hide')
    } else {
        $regionAlert.classList.add('notice-hide')
    }
})

const $districtAlert = document.querySelector('#district-alert');

$districtInput.addEventListener('focusout', () => {
    if($districtInput.value == null || $districtInput.value == "" || $districtInput.value == undefined) {
        $districtAlert.classList.add('notice-hide')
        $districtAlert.classList.remove('notice-hide')
    } else {
        $districtAlert.classList.add('notice-hide')
    }
})

const $addrAlert = document.querySelector('#address1Alert');

$address1.addEventListener('focusout', () => {
    if($address1.value == null || $address1.value == "") {
        $addrAlert.classList.add('notice-hide')
        $addrAlert.classList.remove('notice-hide')
    } else {
        $addrAlert.classList.add('notice-hide')
    }
})
