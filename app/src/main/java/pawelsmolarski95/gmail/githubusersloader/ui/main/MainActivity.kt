package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pawelsmolarski95.gmail.githubusersloader.databinding.MainActivityBinding
import pawelsmolarski95.gmail.githubusersloader.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainActivityBinding.inflate(layoutInflater).root)
    }
}