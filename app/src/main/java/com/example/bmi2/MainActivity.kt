package com.example.bmi2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmi2.ui.theme.Bmi2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Bmi2Theme是系統一開始生出來的
            //at Bmi2Theme 按Ctrl+B 可至該文件地方(Theme.kt) :針對整個app主題配色以及一些資訊
            Bmi2Theme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                   //color = MaterialTheme.colorScheme.
                    ) {
                    SearchBar()
                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

@Composable
//Composable 可組式(組合函示), 一般函示名稱第一個字都是小寫，
//如果是寫Composable，命名第一個字為大寫
//參數一定要有一個modifier, 然後放到參數最後一個
//可針對 顏色、寬度、對齊進行調整
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        //Composable 文字方塊
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(text="Test2")
        Text(text="Test3 blablabla")

    }

//    //Box適合用在圖檔堆疊，可將文字方塊堆爹在圖檔上面
//    Box(modifier = modifier) {
//        //Composable 文字方塊
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//        Text(text="Test2")
//        Text(text="Test3 blablabla")
//
//    }

//        Row {
//        //Composable 文字方塊
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//        Text(text="Test2")
//        Text(text="Test3 blablabla")
//
//    }
}
@Composable
//placeholder -> 提示內容
//Icons.Default -> 可使用系統所提供的icon
//modifier = modifier.fillMaxWidth() -> 將物件填滿
fun SearchBar(modifier: Modifier = Modifier) {
    Column{
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text="Search")
            },
            leadingIcon =  {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            },
            modifier = modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
//將這個專案所產生的
//Theme -> 配色, 文字屬性狀態
fun MyPreview() {
    Bmi2Theme {
        SearchBar()
        //Greeting("Android")
    }
}