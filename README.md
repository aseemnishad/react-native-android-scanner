
# React Native Android Scanner

## react native library for [AndroidScannerDemo](https://github.com/jhansireddy/AndroidScannerDemo) 

## Getting started



### Installation

`$ npm install git+https://git@github.com/aseemnishad/react-native-android-scanner.git  --save`

`$ react-native link`

* In `android/setting.gradle`

```gradle
...
include ':scanlibrary'
project(':scanlibrary').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-scanner/android/scanlibrary')
```

## Usage
```
import ReactNativeAndroidScanner from 'react-native-android-scanner';

```
## Credits
This repo is a React Native implementation of the following native library : [AndroidScannerDemo](https://github.com/jhansireddy/AndroidScannerDemo)
  