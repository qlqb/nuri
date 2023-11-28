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

function searchByStoreCategory(value) {
    console.log(value);
}


function showMoreStore() {

}