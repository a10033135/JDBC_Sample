package idv.fan.tibame.jdbc_sample.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idv.fan.tibame.jdbc_sample.ui.theme.ExColor

@Preview
@Composable
fun PreviewExCardItem() {
    ExCardItem(no = "1", name = "王小明", job = "工程師")
}


@Composable
fun ExCardItem(modifier: Modifier = Modifier, no: String, name: String, job: String) {

    Column(
        modifier = modifier
            .background(
                color = ExColor.PurpleGrey40,
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Text(text = "編號：$no", color = ExColor.White)
        Text(text = "職稱：$job", color = ExColor.White)
        Text(text = "員工姓名：$name", color = ExColor.White)


    }

}