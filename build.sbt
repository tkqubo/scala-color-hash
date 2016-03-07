name := "color-hash"

scalaVersion := "2.11.7"

val specs2Ver = "3.6.5"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % specs2Ver % "test",
  "org.specs2" %% "specs2-matcher" % specs2Ver % "test",
  "org.specs2" %% "specs2-matcher-extra" % specs2Ver % "test",
  "org.specs2" %% "specs2-mock" % specs2Ver % "test"
)

javaOptions in Test ++= Seq(
  s"-Djava.util.Arrays.useLegacyMergeSort=true"
)

initialCommands := "import com.github.tkqubo.colorHash._"

// sbt publish
publishArtifact in Test := false
publishMavenStyle := true
pomIncludeRepository := { _ => false }
pomExtra := (
  <url>https://github.com/tkqubo/scala-color-hash</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>http://opensource.org/licenses/MIT</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:tkqubo/scala-color-hash.git</url>
      <connection>scm:git:github.com/tkqubo/scala-color-hash.git</connection>
      <developerConnection>scm:git:git@github.com:tkqubo/scala-color-hash.git</developerConnection>
    </scm>
    <developers>
      <developer>
        <id>tkqubo</id>
        <name>Takaichi Kubo</name>
        <url>https://github.com/tkqubo</url>
      </developer>
    </developers>
  )
publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) {
    Some("snapshots" at nexus + "content/repositories/snapshots")
  } else {
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  }
}
useGpg := true

// sbt-release
releaseVersionBump := sbtrelease.Version.Bump.Bugfix
releasePublishArtifactsAction := PgpKeys.publishSigned.value

// disable using the Scala version in output paths and artifacts
crossPaths := false

// sbt-ghpages
site.settings
site.includeScaladoc()
ghpages.settings
git.remoteRepo := "git@github.com:tkqubo/scala-color-hash.git"