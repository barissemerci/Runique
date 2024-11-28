plugins {
    alias(libs.plugins.runique.android.dynamic.feature)
    alias(libs.plugins.runique.android.room)

}
android {
    namespace = "com.barissemerci.analytics.analytics_feature"

}

dependencies {
    implementation(project(":app"))
    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)
    implementation(libs.androidx.navigation.compose)

}