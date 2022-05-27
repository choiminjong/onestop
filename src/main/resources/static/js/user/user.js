async function joinForm(){
    /*
    Users 회원가입
    */
    let data ={
        username : document.querySelector('#username').value,
        password : document.querySelector('#password').value,
        email : document.querySelector('#email').value
    }

    let url = "/auth/join"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error  = await response.json();

    if(error['status'] == '200'){
        alert("회원가입이 완료되었습니다.");
        location.href="/clip/accounts";
    }else{
        alert("회원가입을 실패했습니다.");
    }
}