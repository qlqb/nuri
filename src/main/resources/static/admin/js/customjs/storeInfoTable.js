
const $searchBtn = document.querySelector('#searchBtn');
const $searchKey = document.querySelector('#searchKey');
const $searchValue = document.querySelector('#searchValue');
const searchListUrl = 'http://localhost/admin/store/storeSearchList';
let key = "";
let value = "";

let $searchListTable = document.querySelector('#searchListTable');

$searchBtn.addEventListener('click', () => {
    $searchListTable.replaceChildren();
    key = $searchKey.value;
    let value = $searchValue.value;
    search(key, value)
})

function search (key, value) {
    console.log(key, value);
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
            checkBoxDiv.setAttribute("style", "position : relative");

            const checkBoxInput = document.createElement('input');
            checkBoxInput.setAttribute("type", "checkbox");
            checkBoxInput.setAttribute("value", `${element.userId}`);
            checkBoxInput.setAttribute("name", "chk-user");
            checkBoxInput.setAttribute("class", "flat");
            checkBoxInput.setAttribute("style", "position : absolute; opacity : 0;");
            const checkBoxIns = document.createElement('ins');
            checkBoxIns.setAttribute("class", "iCheck-helper")
            checkBoxIns.setAttribute("style", "position: absolute; top: 0%; left: 0%; display: block; " +
                "width: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;")

            checkBoxTd.appendChild(checkBoxInput);



            const storeIdTd = document.createElement('td');
            const storeUpdateAnchor = document.createElement('a');
            storeUpdateAnchor.setAttribute("href", `/admin/store/storeInfoUpdate?storeId=${element.storeId}`);
            storeUpdateAnchor.appendChild(document.createTextNode(`${element.storeId}`));
            storeIdTd.appendChild(storeUpdateAnchor);
            const storeNameTd = document.createElement('td');
            storeNameTd.appendChild(document.createTextNode(`${element.storeName}`));
            const userNameTd = document.createElement('td');
            userNameTd.appendChild(document.createTextNode(`${element.userName}`));
            const storeCategoryTd = document.createElement('td');
            storeCategoryTd.appendChild(document.createTextNode(`${element.storeCategoryName}`));
            const userEmailTd = document.createElement('td');
            userEmailTd.appendChild(document.createTextNode(`${element.userEmail}`));
            const userContactTd = document.createElement('td');
            userContactTd.appendChild(document.createTextNode(`${element.storeContact}`));
            const userAddressTd = document.createElement('td');
            userAddressTd.appendChild(document.createTextNode(`${element.storeAddress}`));
            const storeRegDateTd = document.createElement('td');
            storeRegDateTd.appendChild(document.createTextNode(`${element.storeRegDate}`));
            const openingTimeTd = document.createElement('td');
            openingTimeTd.appendChild(document.createTextNode(`${element.openingTime}`));
            tableRow.appendChild(storeIdTd);
            tableRow.appendChild(storeNameTd);
            tableRow.appendChild(userNameTd);
            tableRow.appendChild(storeCategoryTd);
            tableRow.appendChild(storeCategoryTd);
            tableRow.appendChild(userEmailTd);
            tableRow.appendChild(userContactTd);
            tableRow.appendChild(userAddressTd);
            tableRow.appendChild(storeRegDateTd);
            tableRow.appendChild(openingTimeTd);
            $searchListTable.appendChild(tableRow);
        }))
}


