const $officerRegion = document.querySelector('#officerRegion');
const $department = document.querySelector('#department');
const $officerCert = document.querySelector('#officerCert');

$officerRegion.addEventListener('input', () => {
    if($department.childElementCount > 1) {
        $department.replaceChildren();
    }
    const regionQuery = `/user/register/departmentList?regionCode=${$officerRegion.value}`;
    getDepartmentList(regionQuery);
})

function getDepartmentList(regionQuery) {
    fetch(regionQuery)
        .then((response) => response.json())
        .then(departmentList => departmentList.forEach((department) => {
            let departmentOption = document.createElement("option");
            departmentOption.value = `${department.districtDepCode}`;
            departmentOption.text = `${department.districtDepName}`;
            $department.appendChild(departmentOption);
        }))
};

// 가입 버튼 클릭 시 전송
const $submitBtn = document.querySelector('#submit-btn');

$submitBtn.addEventListener('click', () => {
    sendMemberInfo();
})

// 회원 입력 정보 전송
function sendMemberInfo () {
    fetch("/user/register/officerUserRegister", {
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
                sendOfficerInfo();
            }
        })
}

// 공무원  필수 입력 정보 전송
function sendOfficerInfo()  {
    fetch("/admin/officer/officerRegister", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
                "userId": $userId.value,
                "officerUserName": $userName.value,
                "districtDepCode": $department.value,
                "officerCert": $officerCert.value,
            }
        )
    }).then((resp) => resp.text())
        .then(result => {
            if(result == 1) {
                window.location.href="/user/register/registerConfirm";
            }
        })
}