package com.choo.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.choo.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val constraints = myConstraintSet(margin = 8.dp)
    ConstraintLayout(constraints, Modifier.size(width = 200.dp, height = 200.dp)) {
        MyButton(text = "Button1", modifier = Modifier.size(200.dp).layoutId("button1"))

//        val button1 = createRef()

//        val barrier = createEndBarrier(button1, button2)

//        val guide = createGuidelineFromStart(fraction = .60f)

//        createHorizontalChain(button1, button2, button3)

//        MyButton(text = "Button1", modifier = Modifier.width(200.dp).constrainAs(button1) {
//            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
//            linkTo(parent.start, parent.end, startMargin = 8.dp, endMargin = 8.dp)
//            width = Dimension.fillToConstraints
//            height = Dimension.fillToConstraints
//        })
//        MyButton(text = "Button 2", modifier = Modifier.width(100.dp).constrainAs(button2) {
//            top.linkTo(button1.bottom, margin = 20.dp)
//            start.linkTo(parent.start, margin = 8.dp)
//        })
//        MyButton(text = "Button 3", modifier = Modifier.constrainAs(button3) {
//            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
//            linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)
//            start.linkTo(barrier, margin = 30.dp)
//            width = Dimension.fillToConstraints
//            height = Dimension.fillToConstraints
//        })
    }
}

private fun myConstraintSet(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button1 = createRefFor("button1")

        constrain(button1) {
            linkTo(parent.top, parent.bottom, topMargin = margin, bottomMargin = margin)
            linkTo(parent.start, parent.end, startMargin = margin, endMargin = margin)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* Do something! */ },
        modifier = modifier
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConstraintLayoutTheme {
        MainScreen()
    }
}