package com.jskaleel.quotesgen

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import coil.api.load
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateGradient()

        ivTextFont.setOnClickListener {
            changeFont()
        }

        fab.setOnClickListener {
            txtQuote.text = Utils.getQuotes()
        }

        ivChangeBg.setOnClickListener {
            generateGradient()
        }

        ivAbout.setOnClickListener {

        }
    }

    private fun changeFont() {
        Utils.getFont().apply {
            ResourcesCompat.getFont(baseContext, this).apply {
                txtQuote.typeface = this
//                txtAuthor.typeface = this
            }
        }
    }

    private fun generateGradient() {
        val colors = Utils.getColors()
        val orientation = Utils.getOrientation()

        val gd = GradientDrawable(orientation, colors)

        gd.gradientType = GradientDrawable.LINEAR_GRADIENT
        gd.gradientRadius = 300f
        gd.cornerRadius = 0f

        bgFrame.load(gd)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                saveImage()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveImage() {
        val bitmap =
            Bitmap.createBitmap(contentRoot.width, contentRoot.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        contentRoot.draw(canvas)
        try {
            val file = File(getExternalFilesDir(null), "DemoFile.png")
            val output =
                FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
            output.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
