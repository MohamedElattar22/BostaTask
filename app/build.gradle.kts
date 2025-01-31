plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.hilt)
    id("kotlin-kapt")
    alias(libs.plugins.kotlin.compose)
    id("kotlinx-serialization")
    id("kotlin-parcelize")

}

android {
    namespace = "com.moelattar.bostatask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.moelattar.bostatask"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.core.testing)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // kotest Dependencies
    testImplementation(libs.kotest.assertions.core)
    testImplementation(platform(libs.kotest.bundle))
    testImplementation(libs.kotest.runner.junit5)
    testImplementation(libs.kotest.property)
    testImplementation(libs.kotlin.reflect) // Use the alias
    testImplementation(libs.byte.buddy) // Use the alias)

    //mockk
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)

    // Turbine
    testImplementation(libs.turbine)

    //mockk
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.mockk.android)
    // Hilt Testing
    androidTestImplementation(libs.google.hilt.android.testing)
    kaptAndroidTest(libs.google.hilt.android.compiler)




    // Hilt
    implementation(libs.google.hilt.android)
    kapt(libs.google.hilt.android.compiler)
    kapt(libs.hilt.compiler)
    kapt(libs.google.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)


    // Retrofit
    implementation(libs.retrofit)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.coil.compose.v304)
    implementation(libs.coil.network.okhttp)
    implementation(libs.logging.interceptor)
    // Gson
    implementation(libs.gson)
    implementation(libs.converter.gson)
    implementation(libs.kotlinx.serialization.json) // or the latest version


}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}