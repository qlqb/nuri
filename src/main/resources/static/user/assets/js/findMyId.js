const $userEmail = document.querySelector('#userEmail');
const $userName = document.querySelector('#userName');
const $submitBtn = document.querySelector('#submit-btn');
const $printPlace = document.querySelector('#printPlace')

$submitBtn.addEventListener('click', () => {
    if($printPlace.childElementCount > 0) {
        $printPlace.replaceChildren();
    }
    findMyId();
})

function findMyId () {
    fetch("/user/auth/findMyId", {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
            "userEmail" : $userEmail.value,
            "userName" : $userName.value
        })
    })
        .then((resp) => resp.json())
        .then(result => {
            printMessage(result.resultValue ,result.resultMessage);
        })
}

function printMessage (findResult, resultMessage) {
    $printPlace.setAttribute("class", "mx-auto col-12");
    let messageWrapper = document.createElement('div');
    messageWrapper.setAttribute("class", "text-center section-title mb-30");
    let message = document.createElement('h3');
    let messageText = document.createTextNode(resultMessage);

    if(findResult) {
        let scription = document.createElement('p');
        scription.setAttribute("class", "text-center mb-10");
        let scriptionText = document.createTextNode("찾은 아이디의 결과");
        scription.appendChild(scriptionText);
        $printPlace.appendChild(scription);
        $printPlace.appendChild(messageWrapper);
        messageWrapper.appendChild(message);
        message.appendChild(messageText);
    } else {
        $printPlace.appendChild(messageWrapper);
        messageWrapper.appendChild(message);
        message.appendChild(messageText);
    }
}