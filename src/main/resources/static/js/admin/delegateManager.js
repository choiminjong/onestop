
async function modifyDelegate() {
    /*
       modifyDelegate 수정 추가
    */

    let data = {
        id : document.querySelector('#delegateId').value,
        groupname: document.querySelector('#groupname').value
    }

    let url = "/admin/delegate"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("그룹명을 수정했습니다.");
        location.href = "/admin/delegate";
    } else {
        alert("그룹명 수정을 실패했습니다.");
    }
    
}
async function registerDelegate() {
    /*
       registerDelegate 멤버 추가
    */

    let data = {
        groupname: document.querySelector('#delegateGroup').value
    }

    let url = "/admin/delegate/group"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("그룹을 생성했습니다.");
        location.href = "/admin/delegate";
    } else {
        alert("그룹 생성을 실패했습니다.");
    }
}

async function registerDelegateUser(delegateId) {
    /*
       registerDelegate 멤버 추가
    */

     let data = {
         id:delegateId,
         username: document.querySelector('#member-'+delegateId).value
     }

    let url = "/admin/delegate/member"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("그룹 관리자를 추가했습니다.");
        location.href = "/admin/delegate";
    } else {
        alert("그룹 관리자 추가를 실패했습니다.");
    }
}


