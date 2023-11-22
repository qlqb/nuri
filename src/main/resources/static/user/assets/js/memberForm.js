const $submitBtn = document.querySelector('#submit-btn');
const $cardNum = document.querySelector('#cardNum');
const $cvcNum = document.querySelector('#cvcNum');
const $cardPw = document.querySelector('#cardPw');
const $expiryDate = document.querySelector('#expiryDate');
const $cardComp = document.querySelector('#cardComp');
const $cardUsableCheck = document.querySelector('#cardUsableCheck');

// 가입 버튼 클릭 시 전송
$submitBtn.addEventListener('click', () => {
    sendMemberInfo();
})

// 회원 입력 정보 전송
function sendMemberInfo () {
    fetch("/user/register/memberRegister", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
            "userId": $userId.value,
            "userPw": $userPw.value,
            "userName": $userName.value,
            "userBirth": $userBirth.value,
            "userContact": $userContact.value,
            "userEmail": $userEmail.value,
            "regionCode": $regionCode.value,
            "districtCode": $districtCode.value,
            "userAddress": $address1.value,
        }),
    })
        .then((resp) => resp.text())
        .then(result => {
            if(result == 1) {
                sendMunhwaCardInfo();
            }
        })
}

// 문화누리카드 입력 정보 전송
function sendMunhwaCardInfo()  {
    fetch("/admin/user/munhwaCardRegist", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
                "munhwaCardNum": $cardNum.value,
                "userId": $userId.value,
                "cvc": $cvcNum.value,
                "cardPw": $cardPw.value,
                "cardExpiryDate": $expiryDate.value,
                "cardComp": $cardComp.value,
                "cardUsableCheck": $cardUsableCheck.value,
                "districtCode": $districtCode.value,
                "userAddress": $address1.value,
                "firstUsageAmount" : 110000,
                "lastUsageAmount" : 110000,
            }
        )
    }).then((resp) => resp.text())
        .then(result => {
            if(result == 1) {
                window.location.href="/user/register/registerConfirm";
            }
        })
}