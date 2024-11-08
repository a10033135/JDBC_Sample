plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "idv.fan.tibame.jdbc_sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "idv.fan.tibame.jdbc_sample"
        minSdk = 26
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

        // todo 3-1 添加 BuildConfig 增加 Flavor 機制
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    // todo 3-2 添加 Flavor 機制
    flavorDimensions += "version"
    productFlavors {
        create("emulator") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"http://10.0.2.2:8080/javaweb-example/\"")
        }
        create("smartphone") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"http://192.168.178.159:8080/javaweb-example/\"")
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

    // timber
    implementation(libs.com.jakewharton.timber)


    // android
    implementation(libs.retrofit2)
    implementation(libs.okhttp3)
    implementation(libs.okhttp.logging)
    implementation(libs.okio)
    implementation(libs.retrofit2.converter.moshi)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofit2.adapter.rxjava2)
    implementation(libs.gson)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}