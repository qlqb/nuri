const $chkBox = document.querySelectorAll('input[name=chkb]');
const chkArr = [];
$chkBox.forEach((chkBox) => {
    chkBox.addEventListener('change', () => {
        let chkValue = chkBox.value;
        chkArr.push(chkValue);
        return chkArr;
    })
    console.log(chkArr);
    return chkArr;
})


const $searchBtn = document.querySelector('#searchBtn');
const $searchKey = document.querySelector('#searchKey');
const $searchValue = document.querySelector('#searchValue');
const searchListUrl = 'http://localhost/admin/user/userSearchList';
let key = "";
let value = "";

let checkBox = document.querySelector('#datatable-checkbox');
let $searchListTable = document.querySelector('#searchListTable');

$searchBtn.addEventListener('click', () => {
    $searchListTable.replaceChildren();
    key = $searchKey.value;
    let value = $searchValue.value;
    search(key, value)
})

function search (key, value) {
    let searchRow = "";
    console.log(key, value);
    let tbodyData = [];
    fetch(searchListUrl, {
        method : "POST",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify({
            searchKey : key,
            searchValue : value
        })
    })
        .then((response) => response.json())
        .then((result) => result.forEach((element) => {
            const tableRow = document.createElement('tr');

            const checkBoxTd = document.createElement('td');
            checkBoxTd.setAttribute("class", "sorting_1");

            const checkBoxDiv = document.createElement('div');
            checkBoxDiv.setAttribute("class", "icheckbox_flat-green");
            // checkBoxDiv.setAttribute("class", "iradio_flat_green");
            checkBoxDiv.setAttribute("style", "position : relative");

            const checkBoxInput = document.createElement('input');
            checkBoxInput.setAttribute("type", "checkbox");
            checkBoxInput.setAttribute("value", `${element.userId}`);
            checkBoxInput.setAttribute("name", "chkBox");
            checkBoxInput.setAttribute("class", "flat");
            checkBoxInput.setAttribute("style", "position : absolute; opacity : 0;");

            const checkBoxIns = document.createElement('ins');
            checkBoxIns.setAttribute("class", "iCheck-helper")
            checkBoxIns.setAttribute("style", "position: absolute; top: 0%; left: 0%; display: block; " +
                "width: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;")

            const tdUserLevelName = document.createElement('td');
            tdUserLevelName.appendChild(document.createTextNode(`${element.userLevelName}`));

            const tdUserId = document.createElement('td');
            const anchorUserUpdate = document.createElement('a');
            anchorUserUpdate.setAttribute("href", `/admin/user/userInfoUpdate?userId=${element.userId}`);
            anchorUserUpdate.appendChild(document.createTextNode(`${element.userId}`));
            tdUserId.appendChild(anchorUserUpdate);

            const tdUserName = document.createElement('td');
            tdUserName.appendChild(document.createTextNode(`${element.userName}`));

            const tdUserEmail = document.createElement('td');
            tdUserEmail.appendChild(document.createTextNode(`${element.userEmail}`));

            const tdUserContact = document.createElement('td');
            tdUserContact.appendChild(document.createTextNode(`${element.userContact}`));

            const tdUserAddress = document.createElement('td');
            tdUserAddress.appendChild(document.createTextNode(`${element.userAddress}`));

            const tdUserRegDate = document.createElement('td');
            tdUserRegDate.appendChild(document.createTextNode(`${element.userRegDate}`));

            const tdUserRecentLogin = document.createElement('td');
            tdUserRecentLogin.appendChild(document.createTextNode(`${element.userRecentLogin}`));

            const tdUserStat = document.createElement('td');
            tdUserStat.appendChild(document.createTextNode(`${element.userStat}`));

            tableRow.appendChild(checkBoxTd);
            checkBoxTd.appendChild(checkBoxDiv);
            checkBoxDiv.appendChild(checkBoxInput);
            checkBoxDiv.appendChild(checkBoxIns);
            tableRow.appendChild(tdUserLevelName);
            tableRow.appendChild(tdUserId);
            tableRow.appendChild(tdUserName);
            tableRow.appendChild(tdUserEmail);
            tableRow.appendChild(tdUserContact);
            tableRow.appendChild(tdUserAddress);
            tableRow.appendChild(tdUserRegDate);
            tableRow.appendChild(tdUserRecentLogin);
            tableRow.appendChild(tdUserStat);
            $searchListTable.appendChild(tableRow);
        }))
}
