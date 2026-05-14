plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
}

dependencies {
    intellijPlatform {
        phpstorm("2025.3")
        bundledPlugin("Git4Idea")
    }
}
