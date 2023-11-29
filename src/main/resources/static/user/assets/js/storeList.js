//======== select js
    new Selectr('#sort', {
    searchable: false,
    width: 300
});

    var snapSlider = document.getElementById('slider-snap');

    noUiSlider.create(snapSlider, {
    start: [199, 789],
    // snap: true,
    connect: true,
    range: {
    'min': 99,
    'max': 999
}
});

    var snapValues = [
    document.getElementById('slider-snap-value-lower'),
    document.getElementById('slider-snap-value-upper')
    ];

    snapSlider.noUiSlider.on('update', function (values, handle) {
    snapValues[handle].innerHTML = values[handle]
});


const $storeSort = document.querySelector('#sort');
const $storeSearch = document.querySelector('#search');

function searchByStoreCategory(storeCategoryValue) {
    const $storeTableBody = document.querySelector('#listGrid table tbody');
    if($storeTableBody.hasChildNodes()) {
        $storeTableBody.replaceChildren();
    }
    fetch("/user/store/storeSearch", {
        method : "POST",
        headers : {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body : JSON.stringify({
            "storeCategoryValue" : storeCategoryValue,
        })
    }).then((resp) => resp.json())
        .then(result => result.forEach((data) => {
            console.log(data)
            let storeTableTr = document.createElement('tr')
            let storeTableTd = document.createElement('td')
            let storeTableBr = document.createElement('br')
            let storeCategorySpan = document.createElement('span')
            let contentsCategorySpan = document.createElement('span')
            let storeTitleTd = document.createElement('td')
            let storeTitleBr = document.createElement('br')
            let storeTableAnchor = document.createElement('a')
            let storeAddrSpan = document.createElement('span')
            let storeContactTd = document.createElement('td')
            let storeContactSpan = document.createElement('span')
            let storeOpenTd = document.createElement('td')
            let storeOpenTimeSpan = document.createElement('span')
            let storeRegDateTd = document.createElement('td')
            let storeRegDateSpan = document.createElement('span')

            storeTableTr.setAttribute('class', 'text-center')
            storeTableAnchor.setAttribute('class', 'title-text')
            storeTableAnchor.setAttribute('href', `/user/store/nuriStore?storeId=${data.storeId}`)
            storeCategorySpan.setAttribute('class', 'category-text')

            storeCategorySpan.appendChild(document.createTextNode(`${data.storeCategoryName}`))
            contentsCategorySpan.appendChild(document.createTextNode(`${data.contents.contentsCategoryName}`))
            storeTableAnchor.appendChild(document.createTextNode(`${data.storeName}`))
            storeAddrSpan.appendChild(document.createTextNode(`${data.region.regionName} ${data.district.districtName}`))
            storeContactSpan.appendChild(document.createTextNode(`${data.storeContact}`))
            storeOpenTimeSpan.appendChild(document.createTextNode(`${data.openingTime}`))
            storeRegDateSpan.appendChild(document.createTextNode(`${data.storeRegDate}`))

            storeTableTd.append(storeCategorySpan, storeTableBr, contentsCategorySpan)
            storeTitleTd.append(storeTableAnchor, storeTitleBr, storeAddrSpan)
            storeContactTd.append(storeContactSpan)
            storeOpenTd.append(storeOpenTimeSpan)
            storeRegDateTd.append(storeRegDateSpan)

            storeTableTr.appendChild(storeTableTd)
            storeTableTr.appendChild(storeTitleTd)
            storeTableTr.appendChild(storeContactTd)
            storeTableTr.appendChild(storeOpenTd)
            storeTableTr.appendChild(storeRegDateTd)

            $storeTableBody.appendChild(storeTableTr)
        }))
}