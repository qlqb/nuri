const $userId =  document.querySelector('#userId');
const $userContact = document.querySelector('#userContact');
const $submitBtn = document.querySelector('#submit-btn');

$submitBtn.addEventListener('click', () => {
    findMyPw();
})

function findMyPw () {
    fetch("/user/auth/findMyPw", {
        method : "POST",
        headers : {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body : JSON.stringify({
            "userId" : $userId.value,
            "userContact" : $userContact.value
        })
    })
        .then((response) => response.text())
        .then(result => {
            console.log(result);
            if(result == 1) {
                sendResetForm();
            } else {
                printFailMessage();
            }
        })
}

function sendResetForm() {
    const resetForm = document.createElement('form');
    const hiddenField = document.createElement('input');

    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "resetUserId");
    hiddenField.setAttribute("value", $userId.value);

    resetForm.setAttribute("action", "/user/auth/resetPage");
    resetForm.setAttribute("charset", "UTF-8");
    resetForm.setAttribute("method", "POST");
    resetForm.appendChild(hiddenField);

    document.body.appendChild(resetForm);
    resetForm.submit();
}

function printFailMessage() {
    console.log('실패임');
}