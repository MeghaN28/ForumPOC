const newPostButton = document.querySelector('.new-post');
const commentButton = document.querySelector('.comment');
const commentBox = document.querySelector('.comment-box');
const settingsDots = document.querySelectorAll('.settings .dot');
const newPostPopup = document.getElementById('newPostPopup');
const closePopupButton = document.getElementById('closePopup');
const submitPostButton = document.getElementById('submitPost');

newPostButton.addEventListener('click', () => {
  newPostPopup.classList.toggle('active');
});

commentButton.addEventListener('click', () => {
  commentBox.classList.toggle('active');
});

settingsDots.forEach(dot => {
  dot.addEventListener('click', () => {
    // Add your logic for settings here
    alert('Settings clicked!');
  });
});

closePopupButton.addEventListener('click', () => {
  newPostPopup.classList.remove('active');
});

submitPostButton.addEventListener('click', () => {
  // Logic for submitting the new post
  alert('New post submitted!');
  newPostPopup.classList.remove('active');
});
