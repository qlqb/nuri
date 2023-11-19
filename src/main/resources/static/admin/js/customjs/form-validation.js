const $userId = document.querySelector('#userId')
const duplicateCheckUrl = 'http://localhost/user/register/userIdCheck';


$userId.addEventListener('input', () => {
    let userIdValue = {userId : $userId.value};

    const validationData = {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(userIdValue),
    };

    if($userId.value.length <= 6) {
        console.log('아이디를 6자리 이상 입력해주세요');
    } else {
        fetch(duplicateCheckUrl, validationData)
            .then((response) => response.text())
            .then(resData => console.log(resData))
    }
    
})

const $userPw = document.querySelector('#userPw')
const $checkPw = document.querySelector('#checkPw')

const $pwMessage = document.querySelector('#pwMessage')
const $pwCheckMessage = document.querySelector('#pwCheckMessage')

$userPw.addEventListener('input', () => {
    passValidation();
})
$checkPw.addEventListener('input', () => {
    passValidation();
})

function passValidation () {
     if($userPw.value.length <= 6) {
       console.log('비밀번호를 6자리 이상 입력해주세요.');
    } if($userPw.value != $checkPw.value) {
        console.log('비밀번호가 일치하지 않습니다.');
    } else {
        console.log('문제없음');
    }
}







