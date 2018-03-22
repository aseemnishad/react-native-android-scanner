
package com.reactlibrary;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNReactNativeAndroidScannerModule extends ReactContextBaseJavaModule {

  private WritableMap scannedResult;
  private static final int REQUEST_CODE = 99;
  private final ReactApplicationContext reactContext;
  public static final String REACT_CLASS = "Scanner";
  private static final String SCANNED_RESULT = "ReactNativeAndroidScanner:scannedResult";
  public RNReactNativeAndroidScannerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    reactContext.addActivityEventListener(mActivityEventListener);
  }

  @Override
  public String getName() {
    return "ReactNativeAndroidScanner";
  }

  @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("SCANNED_RESULT", SCANNED_RESULT);
        return constants;
  }

  private void emitMessageToRN(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
    reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);
  }

  @ReactMethod
  public void startScan(int preference) {
    Activity currentActivity = getCurrentActivity();
    Log.d(REACT_CLASS, "start scan ReactNativeAndroidScanner ");
    Intent intent = new Intent(getReactApplicationContext(), ScanActivity.class);
    intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, preference);
      currentActivity.startActivityForResult(intent, REQUEST_CODE);
  } 

    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
                Uri uri = data.getExtras().getParcelable(ScanConstants.SCANNED_RESULT);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getReactApplicationContext().getContentResolver(), uri);
                    //getReactApplicationContext().getContentResolver().delete(uri, null, null);

                    scannedResult = Arguments.createMap();
                    scannedResult.putString ("uri", uri.toString());


                    emitMessageToRN(getReactApplicationContext(), SCANNED_RESULT, scannedResult);
                    Log.d(REACT_CLASS, "onActivitiyResult scan ReactNativeAndroidScanner ");
                    // scannedImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}