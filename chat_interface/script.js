const chatMessages = document.getElementById('chat-messages');
const userInput = document.getElementById('user-input');

function sendMessage() {
    const message = userInput.value.trim();
    if (message !== '') {
        const messageElement = document.createElement('div');
        messageElement.classList.add('message');
        messageElement.textContent = message;
        chatMessages.appendChild(messageElement);
        chatMessages.scrollTop = chatMessages.scrollHeight;
        userInput.value = '';
    }
}