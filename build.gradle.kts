plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.productapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.productapp"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xjvm-default=all",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
        )
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.viewpager2)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.glide)
    kapt(libs.glide.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}