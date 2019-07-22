Releasing
========

 1. Change the version in `gradle.properties` to a non-SNAPSHOT version.
 1. If the release is not a `rc`, `beta`, or similar, change the version in `website/index.html`.
 2. Update the `CHANGELOG.md` for the impending release.
 4. `git commit -am "Prepare for release X.Y.Z."` (where X.Y.Z is the new version)
 5. `git tag -a X.Y.X -m "Version X.Y.Z"` (where X.Y.Z is the new version)
 6. `./gradlew clean uploadArchives`
 1. If you updated `website/index.html`, run the `deploy_website.sh` script.
 7. Update the `gradle.properties` to the next SNAPSHOT version.
 8. `git commit -am "Prepare next development version."`
 9. `git push && git push --tags`
 10. Visit [Sonatype Nexus](https://oss.sonatype.org/) and promote the artifact.