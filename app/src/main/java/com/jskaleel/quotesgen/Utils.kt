package com.jskaleel.quotesgen

import android.graphics.drawable.GradientDrawable
import kotlin.random.Random

object Utils {
    private val orientationList = listOf(
        GradientDrawable.Orientation.TR_BL,
        GradientDrawable.Orientation.TL_BR,
        GradientDrawable.Orientation.BR_TL,
        GradientDrawable.Orientation.BL_TR
    )

    private val fontsList = listOf(
        R.font.ta_font1, R.font.ta_font2, R.font.ta_font3, R.font.ta_font4,
        R.font.ta_font5,
        R.font.ta_font6,
        R.font.ta_font7,
        R.font.ta_font8,
        R.font.ta_font9,
        R.font.ta_font10,
        R.font.ta_font11,
        R.font.ta_font12,
        R.font.ta_font13,
        R.font.ta_font14,
        R.font.ta_font15,
        R.font.ta_font16,
        R.font.ta_font17,
        R.font.ta_font18,
        R.font.ta_font19,
        R.font.ta_font20,
        R.font.ta_font21,
        R.font.ta_font22
    )

    private val colorList = listOf(
        0xffe91e63, 0xffd81b60, 0xffc2185b, 0xffad1457, 0xff880e4f, 0xffba68c8, 0xffab47bc,
        0xffef5350, 0xfff44336, 0xffe53935, 0xffd32f2f, 0xffc62828, 0xffb71c1c, 0xffec407a,
        0xff9c27b0, 0xff8e24aa, 0xff7b1fa2, 0xff6a1b9a, 0xff4a148c, 0xffff5252, 0xffff1744,
        0xffd50000, 0xffff4081, 0xfff50057, 0xffc51162, 0xffe040fb, 0xffd500f9, 0xffaa00ff,
        0xff9575cd, 0xff7e57c2, 0xff673ab7, 0xff5e35b1, 0xff512da8, 0xff4527a0, 0xff0288d1,
        0xff6200ea, 0xff536dfe, 0xff3d5afe, 0xff304ffe, 0xff448aff, 0xff2979ff, 0xff2962ff,
        0xff311b92, 0xff7986cb, 0xff5c6bc0, 0xff3f51b5, 0xff3949ab, 0xff303f9f, 0xff283593,
        0xffdd2c00, 0xfffff176, 0xffffee58, 0xffffeb3b, 0xfffdd835, 0xffffff00, 0xffffea00,
        0xff1a237e, 0xff1e88e5, 0xff1976d2, 0xff1565c0, 0xff0d47a1, 0xff7c4dff, 0xff651fff,
        0xff1b5e20, 0xff558b2f, 0xff33691e, 0xff827717, 0xfff4511e, 0xffe64a19, 0xffd84315,
        0xff00796b, 0xff00695c, 0xff004d40, 0xff0091ea, 0xff43a047, 0xff388e3c, 0xff2e7d32,
        0xffbf360c, 0xffa1887f, 0xff8d6e63, 0xff795548, 0xff6d4c41, 0xff5d4037, 0xffff3d00,
        0xff0277bd, 0xff01579b, 0xff0097a7, 0xff00838f, 0xff006064, 0xff009688, 0xff00897b,
        0xffffd740, 0xffffc400, 0xffffc107, 0xffffb300, 0xffffa000
    )

    private fun getColor(): Int = colorList.random().toInt()

    private val quotes = listOf(
        "ஒளியாக நீயிருப்பதால்\nஇருளைபற்றிய கவலை எனக்கில்லை...",
        "துன்பம் நம்மை சூழ்ந்த போதும்\nமேகம் கலைந்த வானமாய் தெளிவாகவே இருப்போம்...",
        "தனித்து போராடி கரைசேர்ந்த பின்\nதிமிராய் இருப்பதில் தப்பில்லையே",
        "முட்களையும் ரசிக்க கற்றுக்கொள்\nவலிகளும் பழகிப்போகும்...",
        "வேதனைகளை ஜெயித்துவிட்டால்\nஅதுவே ஒரு சாதனைதான்...",
        "குறி தவறினாலும்\nஉன் முயற்சி அடுத்த\nவெற்றிக்கான பயிற்சி...",
        "தத்துவ ஞானிகள் உலகத்தை இதுவரை பல்வேறு வழிகளில் விளக்கியுள்ளனர். ஆனால், அதை மாற்ற வேண்டியதுதான் இப்போதுள்ள கடைமை.",
        "One of Git's most powerful features is the ability to easily create and merge branches. Git's distributed nature encourages users to create new branches often and to merge them regularly as a part of the development process. This fundamentally improves the development workflow for most projects by encouraging smaller, more focused, granular commits.",
        "முதலாளித்துவ உற்பத்தி தொழில்நுட்பத்தை வளர்த்தெடுக்கிறது. இதனை உற்பத்தியின் மற்ற அம்சங்களுடன் இணைத்து சமூகத்தின் ஒட்டு மொத்த தன்மையை உருவாக்குகிறது. ஆனால் இந்த நிகழ்வு போக்கில் செல்வத்தின் ஆதாரங்களாக விளங்குகின்ற மண்ணையும் உழைப்பாளியையும் முதலாளித்துவம் சீரழிக்கிறது.",
        "தனது எல்லாக் குழந்தைகளையும் பள்ளிக்கு அனுப்பாத தேசம், தனது எல்லா குடிமக்களுக்கும் அடிப்படையான ஊட்டச்சத்தை உறுதிசெய்யாத தேசம், ஊட்டச்சத்துக் குறைபாட்டையும், தடுக்கக்கூடிய நோய்களையும் ஒழிக்காத தேசம் அதர்மமான தேம்.",
        "ஒரு சிலந்தி ஒரு நெசவாளியை ஒத்த செயல்பாடுகளில் ஈடுபடுகிறது, தனது கூட்டைக் கட்டும் தேனீ பல கட்டிடக்கலைஞர்களை வெட்கப்படும்படி செய்கிறது. ஆனால், மிகத்திறமையற்ற கட்டிடக் கலைஞனுக்கும், மிகச் சிறந்த தேனீக்கும் இடையிலுள்ள வேறுபாடு, கட்டிடக்கலைஞன் கட்டிடத்தை உண்மையாகக் கட்டுமுன்னரே கற்பனையில் கட்டிவிடுகிறான் என்பதாகும்."
    )

    private var fontIndex = 0
    fun getFont(): Int {
        val font = fontsList[fontIndex]
        fontIndex = fontIndex.inc()
        if (fontIndex == fontsList.size) {
            fontIndex = 0
        }
        return font
    }

    fun getQuotes(): String = quotes.random()

    fun getOrientation(): GradientDrawable.Orientation = orientationList.random()

    fun getColors(): IntArray {
        val size = Random.nextInt(2, 4)
        val colors = IntArray(size)
        var i = 0
        while (i < size) {
            colors[i] = getColor()
            i = i.inc()
        }
        return colors
    }
}