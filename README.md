# Dog App

## Tech choices:
- Language: Kotlin
- UI: Jetpack Compose
- Architectural Pattern: MVVM with clean code architecture
- Dependency Injection: Dagger HILT
- Concurrent Programming: Coroutines
- Data holder classes: Kotlin Flows
- Cache: LruCache

## Features:
- Home screen has 2 buttons to navigate to generate dog image and renet generated screen
- fetched random dog image and to set to the imgae holder
- LruCache implemented to cache recent generated images and the images are displayed in a list on 'My Recent Generated Dogs Screen'
