plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = ("com.example.repository")
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    buildTypes.forEach { buildType ->
        buildType.buildConfigField("String", "BASE_URL", "\"\${localProperties['BASE_URL']}\"")
    }


}

dependencies {
    implementation(project(":model"))

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.coroutines)
    implementation(Retrofit.gson)

    // Room
    implementation(Room.runtime)
    kapt(Room.compiler)

    // Koin
    implementation(Koin.core)
    implementation(Koin.android)

    implementation(Kotlin.core)

}
