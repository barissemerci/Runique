plugins {
    alias(libs.plugins.runique.android.library)

}

android {
    namespace = "com.barissemerci.run.network"

}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)

}