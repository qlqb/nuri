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

console.log($storeSort.value);

function searchByStoreCategory(storeCategoryValue) {
    fetch("/user/store/storeSearch", {
        method : "POST",
        headers : {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body : JSON.stringify({
            "storeCategoryValue" : storeCategoryValue,
        })
    }).then((resp) => resp.json())
        .then(result => console.log(result));
}

