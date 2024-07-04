# QuranApp

## Overview

QuranApp is an Android application that allows users to browse and view details of various surahs from the Quran.

## Functionalities

### Surah List:
- **View List of Surahs**: Browse through a list of all surahs from the Quran.
- **Surah Details**: Tap on any surah to view detailed information including its English translation, number of ayahs, and revelation type.

### Networking:
- **API Integration**: Fetch surah data using the api.alquran.cloud API.
- **Error Handling**: Gracefully handle API failures and display appropriate error messages.

### Architecture:
- **MVVM Architecture**: Utilize ViewModel and LiveData to manage UI-related data in a lifecycle-conscious way.

### Caching:
- **Local Cache**: Implement caching of surah data locally for offline use using SQLite or Room Persistence Library (if implemented).

## Technologies Used

### Development Tools:
- **Android Studio**: Integrated Development Environment (IDE) for Android app development.

### Programming Languages:
- **Kotlin**: Primary programming language for Android app development.

### Libraries and Frameworks:
- **Android Jetpack Components**:
  - **ViewModel**: Store and manage UI-related data in a lifecycle-conscious way.
  - **LiveData**: Observable data holder class.
  - **Room Persistence Library**: Local database to cache surah data (if implemented).

- **Retrofit**: Type-safe HTTP client for networking.
- **Gson**: JSON serialization/deserialization library for Java and Kotlin.
- **Coroutines**: Asynchronous programming for simplifying code that executes asynchronously.

### API:
- **api.alquran.cloud**: External API used to fetch Quranic data including surahs and their details.

## Video

https://github.com/AshrafGamalG3/QuranApp/assets/159867026/731714f3-a33d-4980-9bd9-05ccf9dc4ee3

