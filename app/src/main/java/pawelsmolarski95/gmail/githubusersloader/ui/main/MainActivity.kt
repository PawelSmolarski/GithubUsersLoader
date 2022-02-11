package pawelsmolarski95.gmail.githubusersloader.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pawelsmolarski95.gmail.githubusersloader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}
