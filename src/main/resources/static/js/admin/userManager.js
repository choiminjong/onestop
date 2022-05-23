
async function updateUser() {
    /*
       updateUser 회원 정보 수정
       accountDto = AccountDto(id=1, username=admin, email=dominic@nexon.co.kr, password=1234, roles=[ROLE_USER, ROLE_MANAGER, ROLE_ADMIN])
    */

    let checkbox = [];
    let obj_length = document.getElementsByName('roles').length;
    for (let i=0; i<obj_length; i++) {
        if (document.getElementsByName('roles')[i].checked == true) {
            checkbox.push(document.getElementsByName('roles')[i].value);
        }
    }

    let data = {
        id: document.querySelector('#userId').value,
        username: document.querySelector('#username').value,
        password: document.querySelector('#password').value,
        email: document.querySelector('#email').value,
        roles: checkbox
    }

    let url = "/admin/accounts"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("사용자 변경을 완료했습니다.");
        location.href = "/admin/accounts";
    } else {
        alert("사용자 변경 실패했습니다.");
    }
}



