
# React Native Android Scanner

## react native implementaion of [AndroidScannerDemo](https://github.com/jhansireddy/AndroidScannerDemo) 

## Screenshots

<div align="center">

<img width="23%" src="" alt="Scan Input" title="Scan Input"></img>

<img width="23%" src="" alt="Scan Points" title="Scan Points"></img>

<img width="23%" src="" alt="After Scan" title="After Scan"></img>

<img width="23%" src="" alt="Scanned Result" title="Scanned Result"></img>

</div>

## Getting started



### Installation

`$ npm install git+https://git@github.com/aseemnishad/react-native-android-scanner.git  --save`

* In `android/setting.gradle`

```gradle
...
include ':scanlibrary'
project(':scanlibrary').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-scanner/android/scanlibrary')
```


* In android/app/build.gradle

```
...
dependencies {
    ...
    compile project(':scanlibrary')
}```

#### Add to an Activity
  Open your activity, usually located in `android/app/src/main/java/[your package]/MainApplication.java`.
  Add `import com.reactlibrary.RNReactNativeAndroidScannerPackage;` to the imports at the top of the file.
  Add `new RNReactNativeAndroidScannerPackage()` to the list returned by the `getPackages()` method.

```
## Usage

```
import React, {Component} from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  DeviceEventEmitter,
  ToastAndroid,
  TouchableOpacity,
  Image
} from 'react-native';

import RNAndroidScanner from 'react-native-android-scanner';

export default class App extends Component {

  state = {
    imageUri: null
  }

  componentWillMount = () => {
    ToastAndroid.show('Listening for SCANNED_RESULT', ToastAndroid.SHORT);
    DeviceEventEmitter.addListener(RNAndroidScanner.SCANNED_RESULT, this.onResult);
  }

  onScan = (preference = 2) => {
    RNAndroidScanner.startScan(preference);
  }

  onResult = (image) => {
    ToastAndroid.show('onResult completion callback:', ToastAndroid.SHORT);
    this.setState({imageUri: image.uri})
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.buttonContainer}>
          <Text style={styles.welcome}>
            React Native Android Scanner Demo
          </Text>
          <TouchableOpacity onPress={() => this.onScan()}>
            <Text style={styles.scanButton}>
              Start Scan
            </Text>
          </TouchableOpacity>
        </View>
        <View style={styles.imageContainer}>
          <Image
            style={styles.image}
            source={{
            uri: this.state.imageUri
          }}
            resizeMode="contain"/>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F5FCFF'
  },
  imageContainer: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center'
  },
  image: {
    width: 150,
    height: 150,
  },
  buttonContainer: {
    flex: 1,
    justifyContent: 'center',
    marginTop: 50,
    alignItems: 'center'
  },
  welcome: {
    fontSize: 15,
    textAlign: 'center',
    margin: 10
  },
  scanButton: {
    fontSize: 17,
    textAlign: 'center',
    color: '#333333',
    marginBottom: 30
  }
});
```

## Credits
This repo is a React Native implementation of the following native library : [AndroidScannerDemo](https://github.com/jhansireddy/AndroidScannerDemo)
  