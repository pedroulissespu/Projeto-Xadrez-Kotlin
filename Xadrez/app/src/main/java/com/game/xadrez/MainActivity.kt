package com.game.xadrez

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.PrintWriter
import java.net.ConnectException
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketException
import java.util.*
import java.util.concurrent.Executors

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    var modeloxadrez = ModeloXadrez()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "$modeloxadrez")
    }
}