const $submitBtn = document.querySelector('#submit-btn');
const $storeCategory =  document.querySelector('#storeCategory');
const $storeName = document.querySelector('#storeName');
const $storeContact = document.querySelector('#storeContact');
const $storeRegion = document.querySelector('#storeRegion');
const $storeDistrict = document.querySelector('#storeDistrict');
const $businessNum = document.querySelector('#businessNum');
const $corporationNum = document.querySelector('#corporationNum');
const $storeAddress1 = document.querySelector('#storeAddress1');
const $storeAddress2 = document.querySelector('#storeAddress2');

$storeCategory.addEventListener('change', () => {
    console.log($storeCategory.value);
})

$submitBtn.addEventListener('click', () => {
    sendMemberInfo();
})

$storeRegion.addEventListener('change', () => {
    if($storeDistrict.childElementCount > 1) {
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
    fetch("/user/register/storeUserRegister", {
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
                sendStoreInfo();
            }
        })
}

// 공무원  필수 입력 정보 전송
function sendStoreInfo()  {
    fetch("/user/store/storeRegister", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
            "userId": $userId.value,
            "storeCategoryCode": $storeCategory.value,
            "districtCode": $storeDistrict.value,
            "storeCategoryName": $storeCategory.options[$storeCategory.selectedIndex].text,
            "businessNumber": $businessNum.value,
            "corporationNumber": $corporationNum.value,
            "storeName": $storeName.value,
            "storeContact": $storeContact.value,
            "storeAddress": `${$storeAddress1.value} ${$storeAddress2.value}`,
            }
        )
    }).then((resp) => resp.text())
        .then(result => {
            if(result == 1) {
                window.location.href="/user/register/registerConfirm";
            }
        })
}