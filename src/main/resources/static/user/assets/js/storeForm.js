
const $cardNum = document.querySelector('#cardNum');
const $cvcNum = document.querySelector('#cvcNum');
const $cardPw = document.querySelector('#cardPw');
const $expiryDate = document.querySelector('#expiryDate');
const $cardComp = document.querySelector('#cardComp');
const $cardUsableCheck = document.querySelector('#cardUsableCheck');
$submitBtn.addEventListener('click', () => {
    // sendMemberInfo();
    console.log(
        $cardNum.value,
        $cvcNum.value,
        $cardPw.value,
        $expiryDate.value,
        $cardComp.value,
        $cardUsableCheck.value
    )
})



// function sendOfficerInfo () {
//     fetch("/user/register/memberRegister", {
//         method : 'POST',
//         headers : {
//             "Content-Type" : "application/json; charset=UTF-8",
//         },
//         body : JSON.stringify({
//             "userId" : $userId.value,
//             "userPw" : $userPw.value,
//             "userName" : $userName.value,
//             "userBirth" : $userBirth.value,
//             "userContact" : $userContact.value,
//             "userEmail" : $userEmail.value,
//             "regionCode" : $regionCode.value,
//             "districtCode" : $districtCode.value,
//             "userAddress" : $address1.value,
//         }),
//     })
//         .then(
//             fetch("/user/register/officerRegister", {
//
//             })
//         )
// }