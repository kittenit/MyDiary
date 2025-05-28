
<%@ page contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- 음악 자동 재생 + 지속 재생 + 일시 정지 + 볼륨 조절 -->
<div style="position: fixed; bottom: 20px; right: 20px; z-index: 9999; background-color: #fff0f5; padding: 10px; border-radius: 10px; box-shadow: 0 0 5px #ccc; font-family: 'Segoe UI', sans-serif;">
    <audio id="bgm" autoplay loop>
        <source src="music/2_23_AM.mp3" type="audio/mpeg">
        Your browser does not support the audio element.
    </audio>

    <button onclick="toggleMusic()" id="playBtn" style="margin-right: 8px;">ON</button>
    <input type="range" min="0" max="1" step="0.01" value="0.4" onchange="adjustVolume(this)">
</div>

<script>
    const audio = document.getElementById('bgm');
    const playBtn = document.getElementById('playBtn');

    // ✅ 상태 초기화
    let isPlaying = localStorage.getItem("musicPlaying") !== "false";
    const savedTime = localStorage.getItem("musicTime");
    const savedVolume = localStorage.getItem("musicVolume");

    // ✅ 이어서 재생
    if (savedTime) {
        audio.currentTime = parseFloat(savedTime);
    }

    // ✅ 볼륨 설정
    audio.volume = savedVolume ? parseFloat(savedVolume) : 0.4;
    document.querySelector("input[type='range']").value = audio.volume;

    // ✅ 재생 상태 적용
    if (!isPlaying) {
        audio.pause();
        playBtn.textContent = "OFF";
    } else {
        audio.play();
        playBtn.textContent = "ON";
    }

    // ✅ 위치, 볼륨 저장
    setInterval(() => {
        localStorage.setItem("musicTime", audio.currentTime);
        localStorage.setItem("musicVolume", audio.volume);
        localStorage.setItem("musicPlaying", isPlaying);
    }, 1000);

    // ✅ 버튼 제어
    function toggleMusic() {
        if (isPlaying) {
            audio.pause();
            playBtn.textContent = "OFF";
        } else {
            audio.play();
            playBtn.textContent = "ON";
        }
        isPlaying = !isPlaying;
    }

    // ✅ 볼륨 조절
    function adjustVolume(el) {
        audio.volume = el.value;
    }
</script>



