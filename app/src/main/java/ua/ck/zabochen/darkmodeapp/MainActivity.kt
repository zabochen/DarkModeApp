package ua.ck.zabochen.darkmodeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Guide:
 * https://developer.android.com/guide/topics/ui/look-and-feel/darktheme
 */
class MainActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPreferences()
        setUi()
        loadWebView()
    }

    private fun initPreferences() {
        this.preferences = Preferences(this)
    }

    private fun setUi() {
        // Toolbar
        toolbar.title = getString(R.string.app_name)

        // Button: Change Theme
        btnChangeTheme.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                preferences.isDarkModeOn = false
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                preferences.isDarkModeOn = true
            }
        }
    }

    private fun loadWebView() {
        val page = "<h1>HTML Ipsum Presents</h1>\n" +
                "\n" +
                "<p><strong>Pellentesque habitant morbi tristique</strong> senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. <em>Aenean ultricies mi vitae est.</em> Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, <code>commodo vitae</code>, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. <a href=\"#\">Donec non enim</a> in turpis pulvinar facilisis. Ut felis.</p>\n" +
                "\n" +
                "<h2>Header Level 2</h2>\n" +
                "\n" +
                "<ol>\n" +
                "   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\n" +
                "   <li>Aliquam tincidunt mauris eu risus.</li>\n" +
                "</ol>\n" +
                "\n" +
                "<blockquote><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est.</p></blockquote>\n" +
                "\n" +
                "<h3>Header Level 3</h3>\n" +
                "\n" +
                "<ul>\n" +
                "   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\n" +
                "   <li>Aliquam tincidunt mauris eu risus.</li>\n" +
                "</ul>\n" +
                "\n" +
                "<pre><code>\n" +
                "#header h1 a {\n" +
                "  display: block;\n" +
                "  width: 300px;\n" +
                "  height: 80px;\n" +
                "}\n" +
                "</code></pre>"

        webView.apply {
            loadData(page, null, null)
            settings.javaScriptEnabled = true
        }
    }
}