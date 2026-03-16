<<<<<<< HEAD
// Top-level build file where you can add configuration options common to all subprojects/modules.
plugins {
    alias(libs.plugins.android.application) apply false

    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
}
=======
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
