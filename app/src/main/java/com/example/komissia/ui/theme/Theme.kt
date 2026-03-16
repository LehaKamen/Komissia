package com.example.komissia.ui.theme

<<<<<<< HEAD
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
=======
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
<<<<<<< HEAD
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
=======
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = Orange700,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFE0B2),
    onPrimaryContainer = Color(0xFF3E2723),
    secondary = Slate600,
    onSecondary = Color.White,
    secondaryContainer = Slate100,
    onSecondaryContainer = Slate800,
    tertiary = Amber400,
    background = Slate50,
    onBackground = Slate900,
    surface = Color.White,
    onSurface = Slate900,
    surfaceVariant = Slate100,
    onSurfaceVariant = Slate600,
    outline = Slate200,
    error = Red400,
    onError = Color.White
)

private val DarkColors = darkColorScheme(
    primary = Orange600,
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF4E2600),
    onPrimaryContainer = Color(0xFFFFDDB3),
    secondary = Slate400,
    onSecondary = Color.Black,
    secondaryContainer = Slate700,
    onSecondaryContainer = Slate200,
    tertiary = Amber400,
    background = Slate900,
    onBackground = Slate100,
    surface = Slate800,
    onSurface = Slate100,
    surfaceVariant = Slate700,
    onSurfaceVariant = Slate400,
    outline = Slate600,
    error = Red400,
    onError = Color.Black
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
)

@Composable
fun KomissiaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
<<<<<<< HEAD
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
=======
    dynamicColor: Boolean = false,
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
<<<<<<< HEAD

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
=======
        darkTheme -> DarkColors
        else -> LightColors
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
    }

    MaterialTheme(
        colorScheme = colorScheme,
<<<<<<< HEAD
        typography = Typography,
        content = content
    )
}

fun MaterialTheme(
    colorScheme: ColorScheme,
    typography: Typography,
    content: () -> Unit
) {
}
=======
        typography = AppTypography,
        content = content
    )
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
