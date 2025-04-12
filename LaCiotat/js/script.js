function resizeVideo() {
    const iframe = document.querySelector('.youtube-iframe');
    const windowRatio = window.innerWidth / window.innerHeight;
    const videoRatio = 16 / 9;

    if (windowRatio < videoRatio) {
        iframe.style.width = '177.77vh';
        iframe.style.height = '100vh';
    } else {
        iframe.style.width = '100vw';
        iframe.style.height = '56.25vw';
    }
}

window.addEventListener('load', resizeVideo);
window.addEventListener('resize', resizeVideo);

// Contournement autoplay mobile
document.addEventListener('touchstart', function() {
    const iframe = document.querySelector('.youtube-iframe');
    iframe.src += '&autoplay=1';
}, {once: true});