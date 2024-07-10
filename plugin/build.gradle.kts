import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
    implementation(project(":NMS:v1_8_R1"))
    implementation(project(":NMS:v1_13_R1"))
}

tasks.jar {
    archiveBaseName.set("ExamplePlugin")
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}



tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "eu.xap3y.example.plugin.Plugin"))
        }
        relocate("eu.xap3y.example.v1_8_R1", "eu.xap3y.example.plugin.nms.v1_8_R1")
        relocate("eu.xap3y.example.v1_13_R1", "eu.xap3y.example.plugin.nms.v1_13_R1")
        relocate("eu.xap3y.example.v1_21_R1", "eu.xap3y.example.plugin.nms.v1_21_R1")

        archiveFileName.set("ExamplePlugin.jar")
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}