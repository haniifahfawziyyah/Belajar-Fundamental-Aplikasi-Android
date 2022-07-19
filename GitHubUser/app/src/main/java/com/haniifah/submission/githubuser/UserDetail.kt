package com.haniifah.submission.githubuser

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class UserDetail : AppCompatActivity() {

    companion object {
        var EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_user)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Detail User"
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val img:de.hdodenhof.circleimageview.CircleImageView = findViewById(R.id.detail_avatar)
        val username:TextView = findViewById(R.id.detail_username)
        val name:TextView = findViewById(R.id.detail_name)
        val location:TextView = findViewById(R.id.detail_location)
        val repository:TextView = findViewById(R.id.detail_repository)
        val company:TextView = findViewById(R.id.detail_company)
        val followers:TextView = findViewById(R.id.detail_followers)
        val following:TextView = findViewById(R.id.detail_following)

        val listUser = intent.getParcelableExtra<UserData>(EXTRA_USER) as UserData

        img.setImageResource(listUser.avatar)
        username.text = getString(R.string.username, listUser.username)
        name.text = listUser.name
        location.text = getString(R.string.location, listUser.location)
        repository.text = getString(R.string.repository, listUser.repository)
        company.text = getString(R.string.company, listUser.company)
        followers.text = getString(R.string.followers, listUser.followers)
        following.text = getString(R.string.following, listUser.following)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

