package com.artemissoftware.jetpackcomposetutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

class TestListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_test, container, false
        )
        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, Color.Black))
                    .padding(16.dp)
            ) {

                Text("THIS IS A COMPOSABLE INSIDE THE FRAGMENT XML")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator()
                Spacer(modifier = Modifier.padding(10.dp))
                Text("NEAT")
                Spacer(modifier = Modifier.padding(10.dp))

                val customView = HorizontalDottedProgress(ContextAmbient.current)
                AndroidView(viewBlock = { customView })
            }
        }

        return view
    }




}