plugins {
    id("java")
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }

}

allprojects {
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    group = "me.xap3y"
    version = "1.0"

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    }
}
