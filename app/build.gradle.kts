plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
	kotlin("kapt")
}

android {
    namespace = "com.example.roomdatabase2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.roomdatabase2"
        minSdk = 24
        targetSdk = 35
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
    }
    buildFeatures {
        compose = true
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
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
	/////////////////////////////////
	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.google.code.gson:gson:2.10.1")
	implementation(libs.junit)
	//noinspection GradleDependency
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
	implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
	//implementation(libs.kotlinx.coroutines.android)
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
	implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
	implementation("io.reactivex.rxjava3:rxjava:3.0.13")
	implementation("io.reactivex.rxjava3:rxandroid:3.0.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")

	// Room

	val room_version = "2.6.1"

	implementation("androidx.room:room-runtime:$room_version")

	// If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
	// See Add the KSP plugin to your project
	//noinspection KaptUsageInsteadOfKsp
	kapt("androidx.room:room-compiler:$room_version")

	// If this project only uses Java source, use the Java annotationProcessor
	// No additional plugins are necessary
	annotationProcessor("androidx.room:room-compiler:$room_version")

	// optional - Kotlin Extensions and Coroutines support for Room
	implementation("androidx.room:room-ktx:$room_version")

	// optional - RxJava2 support for Room
	implementation("androidx.room:room-rxjava2:$room_version")

	// optional - RxJava3 support for Room
	implementation("androidx.room:room-rxjava3:$room_version")

	// optional - Guava support for Room, including Optional and ListenableFuture
	implementation("androidx.room:room-guava:$room_version")

	// optional - Test helpers
	testImplementation("androidx.room:room-testing:$room_version")

	// optional - Paging 3 Integration
	implementation("androidx.room:room-paging:$room_version")
}
