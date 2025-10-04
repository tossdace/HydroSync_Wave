package com.hydrodev.hydrosyncwave

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private lateinit var player: ExoPlayer
    private lateinit var audioManager: AudioManager
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private var isPlaying = false

    private val requestPermissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { /* Handle permissions */ }

    private val enableBluetooth = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { /* Handle enable result */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        player = ExoPlayer.Builder(this).build()
        findViewById<PlayerView>(R.id.player_view).player = player

        // Request permissions
        val perms = arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT, android.Manifest.permission.BLUETOOTH_SCAN)
        ActivityCompat.requestPermissions(this, perms, 1)

        if (!bluetoothAdapter.isEnabled) {
            enableBluetooth.launch(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
        }

        // Load sample video
        val mediaItem = MediaItem.fromUri("https://archive.org/download/sample-video/sample.mp4")
        player.setMediaItem(mediaItem)
        player.prepare()

        findViewById<Button>(R.id.btn_play).setOnClickListener { togglePlayback() }
        findViewById<Button>(R.id.btn_devices).setOnClickListener { showDevices() }
        findViewById<Button>(R.id.btn_instructions).setOnClickListener { showInstructions() }
    }

    private fun togglePlayback() {
        if (isPlaying) {
            player.pause()
        } else {
            player.play()
            if (audioManager.isBluetoothA2dpOn || audioManager.isBluetoothScoOn) {
                Toast.makeText(this, "Audio routing to Bluetooth", Toast.LENGTH_SHORT).show()
            }
        }
        isPlaying = !isPlaying
        findViewById<Button>(R.id.btn_play).text = if (isPlaying) "Pause" else "Play"
    }

    private fun showDevices() {
        val devices = bluetoothAdapter.bondedDevices.filter { it.bluetoothClass.majorDeviceClass == 1024 }
        val list = devices.joinToString("\n") { it.name }
        findViewById<TextView>(R.id.tv_devices).text = "Paired audio devices:\n$list"
    }

    private fun showInstructions() {
        val instructions = """
            To share movie audio with multiple headsets:
            1. Pair all Auracast-compatible headsets.
            2. Go to Settings > Connected devices > Audio sharing.
            3. Enable 'Audio sharing' (Android 16+).
            4. Share QR code or link for others to join.
            5. Play movie here—the system broadcasts it.
            Note: Works on Pixel 9+, Galaxy S25+, etc.
        """.trimIndent()
        Toast.makeText(this, instructions, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        player.release()
        super.onDestroy()
    }
}
