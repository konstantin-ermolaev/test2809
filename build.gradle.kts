plugins {
    kotlin("jvm") version "1.6.10"
    java
    id ("io.qameta.allure") version "2.9.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))  // added
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")  // added
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25") // added
}

/*tasks.test{
/    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}*/

tasks.withType<Test> {
    useJUnitPlatform()
    ignoreFailures = true
}