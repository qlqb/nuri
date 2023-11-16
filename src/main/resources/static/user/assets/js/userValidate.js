const $userId = document.querySelector('#userId');

const $idAlert1  = document.querySelector('#id-alert1');
const $idAlert2  = document.querySelector('#id-alert2');
const $idAlert3  = document.querySelector('#id-alert3');

$userId.addEventListener('input', () => {
    const userIdValue = $userId.value;
    if(userIdValue.length < 6) {
        $idAlert2.classList.toggle('notice-hide')
    } else {
        $idAlert2.classList.toggle('notice-hide')
    }
})