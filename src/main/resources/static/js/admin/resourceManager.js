async function registerResources() {
    /*
       registerResources 리소스 등록
    */
    let data = {
        resourceName: document.querySelector('#resourceName').value,
        resourceType: document.querySelector('#resourceType').value,
        httpMethod: document.querySelector('#httpMethod').value,
        orderNum: document.querySelector('#orderNum').value,
        roleName: document.querySelector('#roleName').value
    }

    console.log(data);

    let url = "/admin/resources/"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("리소스를 추가했습니다.");
        location.href = "/clip/resources";
    } else {
        alert("리소스 추가를 실패했습니다.");
    }
}

async function modifyResources() {
    /*
       modifyResources 리소스 수정
    */
    let resourceId = document.querySelector('#resourceId').value;

    let data = {
        resourceName: document.querySelector('#resourceName').value,
        resourceType: document.querySelector('#resourceType').value,
        httpMethod: document.querySelector('#httpMethod').value,
        orderNum: document.querySelector('#orderNum').value,
        roleName: document.querySelector('#roleName').value
    }

    let url = "/admin/resources/"+resourceId
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("리소스를 수정했습니다.");
        location.href = "/clip/resources";
    } else {
        alert("리소스 수정을 실패했습니다.");
    }
}

