# socialma

Contents table
-----------------

- [Apk installable - link](https://drive.google.com/open?id=108X4lcgc0gESkb_mdBVYsOnUoyvidm3H)
- [Technical specifications](#technical-specifications)
- [Structure](#structure)
- [Version control](#version)
- [Libraries](#libraries)


Technical specifications
-------------

- [Example test app](https://drive.google.com/file/d/0B_usVBysSyOuZFpsc0ktUGN3M1E/view)


Structure
---------------

- [MVP (Model - View - Presenter)] (https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/)
- [Android Clean MVPContract (Model - View - Presenter + Contract)] (https://github.com/nomisRev/AndroidCleanMVP)
- [Dagger 2] (https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2)
- [RxJava2] (https://github.com/amitshekhariitbhu/RxJava2-Android-Samples)
- [RxAndroid] (https://github.com/ReactiveX/RxAndroid)


Version
---------------

        // Versions of the build
        min_sdk_version = '17'
        target_sdk_version = '26'
        compile_sdk_version = 26

        // Gradle
        gradle_version = '3.0.1'

        // Kotlin
        kotlin_version = '1.1.60'

        // Versions of dependencies
        android_support_version = '27.0.1'
        calligraphy_version = '2.2.0'
        dagger_version = '2.9'
        google_service_version = '3.1.0'
        joda_time_version = '2.9.4'
        play_services_version = '10.2.4'
        okhttp_version = '3.6.0'
        picasso_version = '2.5.2'
        retrofit_version = '2.2.0'
        rxjava_version = '2.0.5'
        rxandroid_version = '2.0.1'
        rxbinding_version = '2.0.0'
        rxpermissions_version = '0.9.3@aar'


Libraries
---------------

```bash
dependencies {

implementation fileTree(dir: 'libs', include: ['*.jar'])

    // ---------- Android support ----------
    implementation "com.android.support:appcompat-v7:$android_support_version"
    implementation "com.android.support:support-v4:$android_support_version"
    implementation "com.android.support:design:$android_support_version"
    implementation "com.android.support:recyclerview-v7:$android_support_version"
    implementation "com.android.support:cardview-v7:$android_support_version"
    implementation "com.android.support.constraint:constraint-layout:1.0.2"

    // ---------- Kotlin ----------
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
    implementation "org.jetbrains.anko:anko-common:0.9"

    // ---------- Dagger ----------
    kapt "com.google.dagger:dagger-compiler:$dagger_version"
    implementation "com.google.dagger:dagger:$dagger_version"

    // ---------- OkHttp ----------
    implementation "com.squareup.okhttp3:okhttp:$okhttp_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp_version"

    // ---------- Retrofit ----------
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-moshi:$retrofit_version"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"

    // ---------- Rx ----------
    implementation "io.reactivex.rxjava2:rxjava:$rxjava_version"
    implementation "io.reactivex.rxjava2:rxandroid:$rxandroid_version"
    implementation "com.jakewharton.rxbinding2:rxbinding-kotlin:$rxbinding_version"
    implementation "com.tbruyelle.rxpermissions2:rxpermissions:$rxpermissions_version"

    // ---------- Font ----------
    implementation "uk.co.chrisjenx:calligraphy:$calligraphy_version"

    // ---------- For Images ----------
    implementation "com.squareup.picasso:picasso:$picasso_version"
    implementation "com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0"
    implementation "com.soundcloud.android:android-crop:1.0.1@aar"
    implementation "de.hdodenhof:circleimageview:2.1.0"

    // ---------- Joda-time ----------
    implementation "joda-time:joda-time:$joda_time_version"

    // ---------- Twitter ----------
    implementation 'com.twitter.sdk.android:twitter:3.1.1'
    implementation 'com.twitter.sdk.android:twitter-mopub:3.1.1'

    // ---------- Test ----------
    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'

    testImplementation 'junit:junit:4.12'
}
