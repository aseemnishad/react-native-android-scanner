
# React Native Android Scanner

## react native library for [AndroidScannerDemo](https://github.com/jhansireddy/AndroidScannerDemo) 

## Getting started

`$ npm install react-native-android-scanner --save`

### Automatic installation

`$ react-native link react-native-android-scanner`

### Important

* In `android/setting.gradle`

```gradle
...
include ':scanlibrary'
project(':scanlibrary').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-scanner/android/scanlibrary')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':scanlibrary')
}
```

## Usage
```
import ReactNativeAndroidScanner from 'react-native-android-scanner';

```
## Credits
This repo is a React Native implementation of the following native library : [AndroidScannerDemo](https://github.com/jhansireddy/AndroidScannerDemo)
  