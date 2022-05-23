async function registerCategory() {
    /*
       registerCategory 카테고리 등록
    */
    let data = {
        categoryName: document.querySelector('#categoryName').value,
        categoryDesc: document.querySelector('#categoryDesc').value
    }

    let url = "/admin/category"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("카테고리를 추가했습니다.");
        location.href = "/admin/category";
    } else {
        alert("카테고리 추가를 실패했습니다.");
    }
}

async function modifyCategory() {
    /*
       modifyCategory 카테고리 수정
    */

    let categoryId = document.querySelector('#categoryId').value;

    let data = {
        categoryName: document.querySelector('#categoryName').value,
        categoryDesc: document.querySelector('#categoryDesc').value
    }

    let url = "/admin/category/"+categoryId
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("카테고리를 수정했습니다.");
        location.href = "/admin/category";
    } else {
        alert("카테고리 수정을 실패했습니다.");
    }
}

async function deleteCategory() {
    /*
       deleteCategory 카테고리 삭제
    */

    let categoryId = document.querySelector('#categoryId').value;

    let url = "/admin/category/"+categoryId
    let response = await fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("카테고리를 삭제했습니다.");
        location.href = "/admin/category";
    } else {
        alert("카테고리 삭제를 실패했습니다.");
    }

}

