function likeAJoke(id) {
    let xhr = new XMLHttpRequest();
    console.log("im liking it")
    xhr.open('PUT', "http://localhost:8080/like/" + id, true);
    xhr.send();
    document.location.reload();
}

function dislikeAJoke(id) {
    let xhr = new XMLHttpRequest();
    console.log("im disliking it")
    xhr.open('PUT', "http://localhost:8080/dislike/" + id, true);
    xhr.send();
    document.location.reload();
}