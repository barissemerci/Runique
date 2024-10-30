import com.android.build.api.dsl.LibraryExtension
import com.barissemerci.convention.ExtensionType
import com.barissemerci.convention.configureAndroidCompose
import com.barissemerci.convention.configureBuildTypes
import com.barissemerci.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin
class AndroidLibraryComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runique.android.library")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}