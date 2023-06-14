import org.gradle.api.JavaVersion

object Config {
    const val compile_sdk = 33
    const val application_id = "com.example.proandroid"
    const val namespace = "com.example.proandroid"
    const val min_sdk = 23
    const val target_sdk = 33
    val java_version = JavaVersion.VERSION_1_8
    const val jvm_target = "1.8"
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Versions {
    //Design
    const val appcompat = "1.5.1"
    const val material = "1.7.0"
    const val constraint = "2.1.4"
    const val swipe_refresh = "1.1.0"

    //Kotlin
    const val core = "1.8.0"
    const val stdlib = "1.5.21"
    const val coroutinesCore = "1.6.4"
    const val coroutinesAndroid = "1.6.4"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "4.9.2"
    const val adapterCoroutines = "0.9.2"
    const val adapterRxjava2 = "1.0.0"
    const val ktx_fragment = "1.4.0"
    const val gson = "2.8.7"

    //Koin
    const val koin = "3.2.0"

    //Coil
    const val coil = "2.2.2"

    //Room
    const val roomKtx = "2.5.0"
    const val runtime = "2.5.0"
    const val roomCompiler = "2.5.0"

    //Test
    const val jUnit = "4.13.2"
    const val runner = "1.2.0"
    const val espressoCore = "3.5.1"
    const val extjUnit = "1.1.5"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val coroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.ktx_fragment}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Ui {
    const val swipe_refresh_layout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipe_refresh}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object Testing {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val junit_ext = "androidx.test.ext:junit:${Versions.extjUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object Modules {
    const val app = ":app"

}