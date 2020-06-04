package com.azer.azexpressandroid.ext

import android.Manifest
import android.app.Activity
import android.content.Context
import pub.devrel.easypermissions.EasyPermissions

fun Context.hasReadStoragePermission(): Boolean {
    return EasyPermissions.hasPermissions(
        this,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
}

fun Context.hasCameraPermission(): Boolean {
    return EasyPermissions.hasPermissions(
        this,
        Manifest.permission.CAMERA
    )
}

fun Context.hasAudioPermission(): Boolean {
    return EasyPermissions.hasPermissions(
        this,
        Manifest.permission.RECORD_AUDIO
    )
}

fun Activity.requestReadAndWriteStoragePermission(requestCode: Int) {
    EasyPermissions.requestPermissions(
        this,
        "Read and write external storage permission is required to carry out this feature",
        requestCode,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
}
//
//fun Fragment.requestCameraPermission(requestCode: Int) {
//    EasyPermissions.requestPermissions(
//        this, this.getString(R.string.camera_permission),
//        requestCode, Manifest.permission.CAMERA
//    )
//}
//
//fun Activity.requestCameraPermission(requestCode: Int) {
//    EasyPermissions.requestPermissions(
//        this, this.getString(R.string.camera_permission),
//        requestCode, Manifest.permission.CAMERA
//    )
//}
//
//fun Activity.requestReadAndWriteStoragePermission(requestCode: Int) {
//    EasyPermissions.requestPermissions(
//        this,
//        this.getString(R.string.read_storage_permission),
//        requestCode,
//        Manifest.permission.READ_EXTERNAL_STORAGE,
//        Manifest.permission.WRITE_EXTERNAL_STORAGE
//    )
//}
//
//
//fun Activity.requestAudioPermission(requestCode: Int) {
//    EasyPermissions.requestPermissions(
//        this, this.getString(R.string.audio_permission),
//        requestCode, Manifest.permission.RECORD_AUDIO
//    )
//}
