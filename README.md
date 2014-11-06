ParseLoadMapPins
================

Another Parse demo for Android at RRC BIT. This demo elaborates on <a href="https://github.com/CMDann/ParseSaveLoadDemo">my previous example</a> to bring you data loaded remotely from Parse. This shows queries for data using the service, not all data in my presentation was valid for the query so some markers are not loaded.

You need a google maps API key and a Parse.com account for this example to work for you! The wear component is for next time, ignore it for now.

Links:
<ul>
<li><a href="http://dan-blair.ca">dan-blair.ca</a></li>
<li><a href="http://cmdann.ca">cmdann.ca</a></li>
<li><a href="http://winnipegandroid.ca">winnipegandroid.ca</a></li>
</ul>

Installation
============
1. Download the zip
2. Import into Android Studio
3. Register on Parse.com
4. Replace KEY1 and KEY2 with your API keys
5. <a href="https://parse.com/docs/downloads">Download parse SDK</a>
6. Add parse SDK to /libs/
7. Add parse SDK to build.gradle
8. Profit

Data
====
The data being used during the presentation for your convenience.
<pre>
{ "results": [
	{
        "createdAt": "2014-11-06T03:59:35.402Z",
        "lat": 49.900273,
        "lng": -97.14099,
        "objectId": "tiw8RBSayO",
        "updatedAt": "2014-11-06T04:00:20.130Z",
        "username": "student"
    },
	{
        "createdAt": "2014-11-06T04:00:27.720Z",
        "lat": 49.900567,
        "lng": -97.148709,
        "objectId": "raQbCpZzu1",
        "updatedAt": "2014-11-06T04:00:51.475Z",
        "username": "Dan"
    },
	{
        "createdAt": "2014-11-06T04:00:54.753Z",
        "lat": 49.898687,
        "lng": -97.147207,
        "objectId": "OcH8DjAuye",
        "updatedAt": "2014-11-06T04:01:29.632Z",
        "username": "student"
    },
	{
        "createdAt": "2014-11-06T04:00:58.868Z",
        "lat": 49.899461,
        "lng": -97.134526,
        "objectId": "Mt5s5QgDF3",
        "updatedAt": "2014-11-06T04:01:44.333Z",
        "username": "student"
    }
] }
</pre>

Parse
=====
<a href="https://parse.com/">Parse.com</a>

Parse lets you focus on creating unique & engaging apps on any platform. They take care of everything else your app needs, from the core of your app to analytics and push notifications.

Android Studio
==============
<a href="https://developer.android.com/sdk/installing/studio.html">Android Studio</a>
<p>Android Studio is a new Android development environment based on IntelliJ IDEA. It provides new features and improvements over Eclipse ADT and will be the official Android IDE once it's ready. On top of the capabilities you expect from IntelliJ, Android Studio offers:</p>
<ol>
<li>Flexible Gradle-based build system.</li>
<li>Build variants and multiple APK generation.</li>
<li>Expanded template support for Google Services and various device types.</li>
<li>Rich layout editor with support for theme editing.</li>
<li>Lint tools to catch performance, usability, version compatibility, and other problems.</li>
<li>ProGuard and app-signing capabilities.</li>
<li>Built-in support for Google Cloud Platform, making it easy to integrate Google Cloud Messaging and App Engine.</li>
</ol>
