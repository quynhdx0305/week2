# Project 2 - *Resource*

**Resource** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can enter a search query that will display a grid of news articles using the thumbnail and headline from the New York Times Search API.
* [X] User can click on "filter" icon which allows selection of advanced search options to filter articles. 
* [X] User can configure advanced search filters such as:
  * [X] Begin Date (using a date picker)
  * [X] Sort order (oldest or newest) using a spinner dropdown
  * [X] News desk values (Arts, Fashion & Style, Sports) using checkboxes
* [X] Subsequent searches will have any filters applied to the search results. 
* [X] User can tap on any article in results to view the contents in an embedded browser.
* [X] User can scroll down "infinitely" to continue loading more news articles. The maximum number of articles is limited by the API search.

The following **optional** features are implemented:

* [X] Display a nice default [placeholder graphic](https://guides.codepath.com/android/Displaying-Images-with-the-Glide-Library) for each image during loading.

The following **bonus** features are implemented:

Robust error handling, check if internet is available, handle error cases, network failures. (1 point)
* [ ] Use the ActionBar SearchView or custom layout as the query box instead of an EditText. (1 point)
* [ ] User can share a link to their friends or email it to themselves. (1 point)
* [ ] Replace Filter Settings Activity with a lightweight modal overlay. (2 points)
* [ ] Improve the user interface and experiment with image assets and/or styling and coloring (1 to 3 points depending on the difficulty of UI improvements)
* [ ] Stretch: Use the RecyclerView with the StaggeredGridLayoutManager to display improve the grid of image results (see Picasso guide too). (2 points)
* [ ] Stretch: For different news articles that only have text or have text with thumbnails, use Heterogenous Layouts with RecyclerView. (2 points)
* [ ] Stretch: Apply the popular ButterKnife annotation library to reduce view boilerplate. (1 point)
* [ ] Stretch: Use Parcelable instead of Serializable using the popular Parceler library. (1 point)
* [X] Stretch: Replace all icon drawables and other static image assets with vector drawables where appropriate. (1 point)
* [ ] Stretch: Leverage the data binding support module to bind data into one or more activity layout templates. (1 point)
* [X] Stretch: Replace Picasso with Glide for more efficient image rendering. (1 point)
* [ ] Stretch: Switch to using retrolambda expressions to cleanup event handling blocks. (1 point)
* [X] Stretch: Leverage the popular GSON library to streamline the parsing of JSON data. (1 point)
* [X] Stretch: Consume the New York Times API using the popular Retrofit networking library instead of Android Async HTTP. (3 points)
* [X] Replace the embedded WebView with Chrome Custom Tabs using a custom action button for sharing. (2 points)
The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/ljO24EX.gif' title='Video Demo' width='' alt='Video Demo' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [2018] [Rock Lee]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


README.md
Open with Drive Notepad
Displaying README.md.

