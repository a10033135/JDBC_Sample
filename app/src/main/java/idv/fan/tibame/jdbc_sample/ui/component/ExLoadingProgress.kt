package idv.fan.tibame.jdbc_sample.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idv.fan.tibame.jdbc_sample.ui.theme.ExColor

@Preview
@Composable
private fun ExLoadingProgressPreview() {
    ExLoadingProgress()
}

@Composable
fun ExLoadingProgress(
    modifier: Modifier = Modifier,
    color: Color = ExColor.Pink40
) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    CircularProgressIndicator(
        modifier = modifier.size(80.dp),
        progress = { progress },
        strokeWidth = 10.dp,
        color = color,
    )

}