const $submitBtn = document.querySelector('#submit-btn');
const $storeCategory =  document.querySelector('#storeCategory');
const $storeName = document.querySelector('#storeName');
const $storeContact = document.querySelector('#storeContact');
const $storeRegion = document.querySelector('#storeRegion');
const $storeDistrict = document.querySelector('#storeDistrict');
const $businessNum = document.querySelector('#businessNum');
const $corporationNum = document.querySelector('#corporationNum');

$storeCategory.addEventListener('change', () => {
    console.log($storeCategory.text);
})

$submitBtn.addEventListener('click', () => {
    // sendMemberInfo();
    console.log(
        $storeCategory.value,
        $storeName.value,
        $storeContact.value,
        $storeRegion.value,
        $storeDistrict.value,
        $businessNum.value,
        $corporationNum.value
    )
})

$storeRegion.addEventListener('change', () => {
    if($storeDistrict.childElementCount > 0) {
        $storeDistrict.replaceChildren();
    }

    const storeRegionValue = $storeRegion.value;
    const requestDistrictList = districtListUrl + storeRegionValue;
    getStoreDistrictList(requestDistrictList);
})

function getStoreDistrictList(requestDistrictListUrl) {
    fetch(requestDistrictListUrl)
        .then(response => response.json())
        .then(json => json.forEach((data) => {
            let districtOption = document.createElement("option");
            districtOption.value = `${data.districtCode}`;
            districtOption.text = `${data.districtName}`;
            $storeDistrict.appendChild(districtOption);
        }))
}



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
                sendOfficerInfo();
            }
        })
}

// 공무원  필수 입력 정보 전송
function sendStoreInfo()  {
    fetch("/admin/store/storeRegister", {
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