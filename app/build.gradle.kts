<<<<<<< HEAD
import org.gradle.accessors.dm.LibrariesForLibsInPluginsBlock

=======
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
<<<<<<< HEAD

=======
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
}

android {
    namespace = "com.example.komissia"
<<<<<<< HEAD
    compileSdk = 36
=======
    compileSdk = 35
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af

    defaultConfig {
        applicationId = "com.example.komissia"
        minSdk = 24
<<<<<<< HEAD
        targetSdk = 36
=======
        targetSdk = 35
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
<<<<<<< HEAD
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

=======
    kotlinOptions {
        jvmTarget = "17"
    }
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.hilt.navigation.compose)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation("androidx.navigation:navigation-compose:2.7.7")
<<<<<<< HEAD
}

hilt {
    enableAggregatingTask = true
}
=======
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    implementation("androidx.compose.material:material-icons-extended:1.7.6")
}
>>>>>>> 2d615af0fbb6b07834f9cfa811a32c2319e7c5af
