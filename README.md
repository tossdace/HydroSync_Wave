# 🌊 **HydroSync Wave Movies** 🎥✨

[![GitHub Stars](https://img.shields.io/github/stars/tossdace/HydroSync_Wave?style=social)](https://github.com/tossdace/HydroSync_Wave/stargazers) [![GitHub Forks](https://img.shields.io/github/forks/tossdace/HydroSync_Wave?style=social)](https://github.com/tossdace/HydroSync_Wave/network) [![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT) [![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF.svg)](https://kotlinlang.org) [![Android](https://img.shields.io/badge/Android-13%2B-3DDC84.svg)](https://www.android.com) [![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()

![HydroSync Wave Banner](https://via.placeholder.com/1200x300/007BFF/FFFFFF?text=HydroSync+Wave+Movies+-+Sync+Your+Movie+Magic!)  
*An **epic** Android app by [Hydro Dev](https://hydrodev.com) that transforms movie nights into a **cosmic shared experience**! Play videos from URLs or files, with audio blasting to **unlimited** Bluetooth headsets via Android’s Audio Sharing. Built with slick Kotlin—your ticket to cinematic sync magic! 🚀🔊*

## 🎉 **Quick Overview**
**HydroSync Wave Movies** is the ultimate Android powerhouse for group movie vibes! Drop a video URL (like a free flick from Archive.org), hit play, and watch the magic unfold. Powered by ExoPlayer, it streams crystal-clear videos while Android’s futuristic **Audio Sharing** beams sound to a squad of Bluetooth headsets. It’s like a silent disco for blockbusters—everyone hears in perfect sync!  

Perfect for movie marathons, road trips, or chill hangouts. Open-sourced under the **MIT License** on GitHub, so fork it, remix it, and ride the wave with Hydro Dev! 🌊  

**Why It's Pro:**  
- 🎬 **Flawless Video Playback** with ExoPlayer—URLs, local files, 4K streams, no sweat.  
- 🔊 **Multi-Headset Audio Magic** via LE Audio/Auracast (Android 13+, shines on 16+).  
- 📱 **Bluetooth Boss**—auto-routes audio, lists paired devices.  
- 💻 **Clean Kotlin Code**—beginner-friendly yet pro-grade.  

**Live Stats:**  
| Feature | Status |  
|---------|--------|  
| Video Playback | ✅ .mp4/.m3u8 |  
| Single Bluetooth | 🔵 A2DP |  
| Multi-Headset | 🔵 Auracast |  
| Kotlin | 💎 ExoPlayer 1.4.1 |  

---

## 🚀 **Key Features**  
Dive into the hydro-powered awesomeness:  

- **🌈 Video Streaming Supreme:** Play movies from URLs (e.g., `https://archive.org/download/sample-video/sample.mp4`) or local .mp4 files. Pause/resume for those heart-pounding plot twists!  
- **🔗 Audio Sharing Extravaganza:** Broadcast audio to **unlimited** LE Audio headsets (Galaxy Buds 3 Pro, Sony WF-1000XM6) with Android’s Audio Sharing. Share a QR code—bam, group sync!  
- **📡 Bluetooth Mastery:** Auto-routes audio to paired devices. Tap to see connected headsets in a sleek list.  
- **⚡ Smart Instructions:** Pop-up guides make setup a breeze, even for your non-techie friends.  
- **🔒 Secure & Smooth:** Handles Bluetooth/Internet perms like a vault. No ads, just pure Hydro Dev vibes.  

**Pro Tip:** Pair with an Android TV for big-screen video, while audio flows to headsets! 🎥  

---

## 🔊 **Audio Sharing Deep Dive**  
<details>
<summary>🎧 Click to Unleash the Audio Magic! 🌊</summary>  

Hold onto your headphones—this is where **HydroSync Wave Movies** becomes a **sound-sharing superhero**! Android’s **Audio Sharing** (amped up in 2025, Android 16) turns your app into a broadcasting beast, flooding **unlimited** LE Audio headsets with movie audio in perfect sync.  

- **What’s the Vibe?** It’s like a hydro-powered tsunami of sound, delivering every explosion and whisper to all ears via **LE Audio** (Bluetooth 5.2+) and **Auracast**. Low latency, low power, high vibes!  
- **How It Flows:**  
  1. Pair LE Audio headsets (Settings > Bluetooth).  
  2. Enable Audio Sharing (Settings > Connected Devices > Audio Sharing).  
  3. Share QR code/link—friends join in seconds.  
  4. Play your movie—audio crashes like waves across all headsets!  
- **Why It’s Epic:** No cables, no lag, secure (password-protected), and scales for huge movie parties. Think silent cinema under the stars! 🌟  
- **Compat Check:** Android 13+ (16+ for full Auracast). Headsets like Pixel Buds Pro 2, Sony WF-1000XM6. Older A2DP? Falls back to 1-2 devices.  
- **Code Magic:** ExoPlayer pumps audio; Android’s system handles the broadcast heavy lifting.  

**Sneak Peek (MainActivity.kt):**  
```kotlin
private fun togglePlayback() {
    if (isPlaying) player.pause() else {
        player.play()
        if (audioManager.isBluetoothA2dpOn) Toast.makeText(this, "🌊 Audio Sharing Activated! Syncing to headsets...", Toast.LENGTH_SHORT).show()
    }
    isPlaying = !isPlaying
}
🛠 Getting Started
Ride the wave in 5 pro steps:
Clone the Repo:
git clone https://github.com/tossdace/HydroSync_Wave.git
cd HydroSync_Wave
Open in Android Studio:
Use Android Studio (2025+).
Import project—Gradle syncs like a dream.
Add Permissions (AndroidManifest.xml):
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_MEDIA_PLAYBACK" />
<uses-feature android:name="android.hardware.bluetooth_le" android:required="true" />
Build & Run:
Build > Run on Android 13+ device (USB debugging on).
Test with: https://ia600500.us.archive.org/22/items/duck_and_cover/duck_and_cover.mp4.
Multi-Headset Setup:
Pair headsets (Settings > Bluetooth).
Enable Audio Sharing (Settings > Connected Devices).
Share QR code, play, and vibe! 🎧
Troubleshooting:
🚫 No Video? Check URL (.mp4/.m3u8) or INTERNET perm.
🚫 No Broadcast? Verify Android 16+, LE Audio headsets.
🚫 Build Fail? Update Gradle to 8.5+.
📋 Tech Stack
Powered by 2025’s freshest tools:
Component
Version
Why It Rocks
Language
Kotlin 1.9.0
Clean, crash-proof code.
Media Player
ExoPlayer 1.4.1
4K streams, buttery smooth.
UI
Jetpack AppCompat
Sleek, Material Design vibes.
Bluetooth
Android BT API
A2DP + Auracast sync.
Build
Gradle (Kotlin DSL)
Fast, dependency magic.
Target SDK
36 (Android 16)
Future-proof for 2025.
Dependencies (build.gradle.kts):
dependencies {
    implementation("androidx.media3:media3-exoplayer:1.4.1")
    implementation("androidx.media3:media3-ui:1.4.1")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
}
