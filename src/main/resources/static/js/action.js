function likeAJoke(id) {
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', "/like/" + id, true);
    xhr.send();
    document.location.reload();
}

function dislikeAJoke(id) {
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', "/dislike/" + id, true);
    xhr.send();
    document.location.reload();
}