# Truth Android

A set of Truth assertions geared toward testing Android.

Writing tests is not the most glamorous part of developing an Android
application but it is an invaluable one. Using libraries like JUnit and Truth
provide a great starting point for writing tests.

This library is an extension of [Truth][truth] which aims to make it even easier to test
Android.

Check the [website][website] for usage and installation instructions.

## Credits

A huge thanks to Google for their work on _Truth_ which provides the foundation for this project.

Additionally, a huge thanks to Square for their work on [Assertj Android][assertj-android], the inspiration for this library.
A large amount of code has been copied or modified from the _Assertj Android_ project.
_Assertj Android_ continues to be maintained and is an excellent solution, particularly if you aren't already
including _Truth_ in your tests.

_Truth_ has a dependency on _Guava_, so using _Truth Android_ will add a significant number of methods to your
test APK.

## Development

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

## License

    Copyright 2016 PKWARE, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




 [truth]: https://google.github.io/truth/
 [2]: https://google.github.io/truth/extension
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 [website]: https://pkware.github.io/truth-android/
 [assertj-android]: http://square.github.io/assertj-android/