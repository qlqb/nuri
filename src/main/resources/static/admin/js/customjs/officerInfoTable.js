const $searchBtn = document.querySelector('#searchBtn');
const $searchKey = document.querySelector('#searchKey');
const $searchValue = document.querySelector('#searchValue');
const searchListUrl = 'http://localhost/admin/officer/officerSearchList';
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
            checkBoxInput.setAttribute("value", `${element.officerId}`);
            checkBoxInput.setAttribute("name", "chk-user");
            checkBoxInput.setAttribute("class", "flat");
            checkBoxInput.setAttribute("style", "position : absolute; opacity : 0;");
            const tdOfficerId = document.createElement('td');
            const anchorOfficerUpdate = document.createElement('a');
            anchorOfficerUpdate.setAttribute("href", `/admin/officer/officerInfoUpdate?officerId=${element.officerId}`);
            anchorOfficerUpdate.appendChild(document.createTextNode(`${element.officerId}`));
            const tdOfficerUserName = document.createElement('td');
            tdOfficerUserName.appendChild(document.createTextNode(`${element.officerUserName}`));
            const tdDistrictDepName = document.createElement('td');
            tdDistrictDepName.appendChild(document.createTextNode(`${element.districtDepName}`));
            const tdWorkStartdate = document.createElement('td');
            tdWorkStartdate.appendChild(document.createTextNode(`${element.workStartDate}`));
            const tdOfficerRecentLogin = document.createElement('td');
            tdOfficerRecentLogin.appendChild(document.createTextNode(`${element.officerRecentLogin}`));
            const tdOfficerAccountStat = document.createElement('td');
            tdOfficerAccountStat.appendChild(document.createTextNode(`${element.officerAccountStat}`));
            tdOfficerId.appendChild(anchorOfficerUpdate);
            checkBoxTd.appendChild(checkBoxDiv);
            checkBoxDiv.appendChild(checkBoxInput);
            tableRow.appendChild(checkBoxTd);
            tableRow.append(tdOfficerId,
                tdOfficerUserName,
                tdDistrictDepName,
                tdWorkStartdate,
                tdOfficerRecentLogin,
                tdOfficerAccountStat);
            $searchListTable.appendChild(tableRow);
        }))
}