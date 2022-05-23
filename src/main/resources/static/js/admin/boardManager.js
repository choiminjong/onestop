async function registerBoard() {
    /*
       registerBoard 게시글 등록
    */

    let data = {
        title: document.querySelector('#title').value,
        content: document.querySelector('#content').value,
        category: document.querySelector('#category').value
    }

    let url = "/admin/board"
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });

    let error = await response.json();

    if (error['status'] == '200') {
        alert("게시글를 추가했습니다.");
        location.href = "/admin/boards";
    } else {
        alert("게시글 추가를 실패했습니다.");
    }

}
