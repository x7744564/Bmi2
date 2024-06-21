package com.example.bmi2.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//@ 編譯之前，先做預處理的標示
//Entity必須是在Room類別庫內
@Entity
class Record(
    //以後資料儲存不能是Non null
    @NonNull
    @ColumnInfo(name = "nick")
    var nickname:String,
    var counter:Int,
    //自動遞增編號
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
) {
}