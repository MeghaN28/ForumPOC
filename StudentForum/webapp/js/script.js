function likePost(postId) {
    fetch(`/forum/likePost?postId=${postId}`, {
        method: 'POST'
    }).then(response => window.location.reload());
}

function commentPost(postId) {
    const content = prompt('Enter your comment:');
    if (content) {
        fetch(`/forum/commentPost?postId=${postId}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `content=${content}`
        }).then(response => window.location.reload());
    }
}
