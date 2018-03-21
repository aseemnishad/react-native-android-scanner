using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Android.Scanner.RNReactNativeAndroidScanner
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeAndroidScannerModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeAndroidScannerModule"/>.
        /// </summary>
        internal RNReactNativeAndroidScannerModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeAndroidScanner";
            }
        }
    }
}
