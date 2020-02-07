Releasing
========

 1. Change the version in `gradle.properties` to a non-SNAPSHOT version.
 1. If the release is not a `rc`, `beta`, or similar, change the version in `website/index.html`.
 1. Update the `CHANGELOG.md` for the impending release.
 1. `git commit -am "Prepare for release X.Y.Z."` (where X.Y.Z is the new version)
 1. `./gradlew clean publish --no-parallel`
 1. Visit [Sonatype Nexus](https://oss.sonatype.org/) and promote the artifact.
 1. `git tag -a X.Y.X -m "Version X.Y.Z"` (where X.Y.Z is the new version)
 1. If you updated `website/index.html`, run the `deploy_website.sh` script.
 1. Update the `gradle.properties` to the next SNAPSHOT version.
 1. `git commit -am "Prepare next development version."`
 1. `git push && git push --tags`

If step 5 or 6 fails, drop the Sonatype repo, fix the problem, commit, and start again at step 5.