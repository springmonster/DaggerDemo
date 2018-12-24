package com.sunflower.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.idescout.sql.SqlScoutServer
import com.sunflower.R


class GardenActivity : AppCompatActivity() {
    private var sqlScoutServer: SqlScoutServer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden)

        sqlScoutServer = SqlScoutServer.create(this, packageName)
    }

    override fun onSupportNavigateUp(): Boolean =
        Navigation.findNavController(this, R.id.activity_garden_fragment).navigateUp()

    override fun onDestroy() {
        sqlScoutServer?.destroy()
        super.onDestroy()
    }
}
