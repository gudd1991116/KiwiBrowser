#!/bin/bash
set -e 
cd /home/asroot/chromium/

GRADLE_PRO_ROOT="./kiwi-androidx"
APP_ROOT="${GRADLE_PRO_ROOT}/app"                    
APP_JAVA_ROOT="${APP_ROOT}/src/main/java"
APP_RES_ROOT="${APP_ROOT}/src/main/res"

KIWI_ROOT="/home/asroot/chromium/kiwi/src"
RELEASE_ROOT="${KIWI_ROOT}/out/android_arm"

RSYNC="rsync -ah -r -P"

sync_assets_from_kiwi() {
    rm -rf ${GRADLE_PRO_ROOT}/./apk
    local apk_ext="${GRADLE_PRO_ROOT}/apk"
    mkdir $apk_ext
    unzip ${RELEASE_ROOT}/apks/ChromePublic.apk -d $apk_ext
    $RSYNC $apk_ext/assets ${APP_ROOT}/src/main/
    $RSYNC $apk_ext/lib/   ${APP_ROOT}/src/main/jniLibs/
}


sync_assets_from_kiwi_fail() {
    local assets_dst="${APP_ROOT}/src/main/assets"
    local jni_dst="${APP_ROOT}/src/main/jniLibs/armeabi-v7a"
    mkdir -p $assets_dst
    mkdir -p $jni_dst
    local lib_so1="${RELEASE_ROOT}/libchrome.so"
    local lib_so2="${RELEASE_ROOT}/libchromium_android_linker.so"
    local local="${RELEASE_ROOT}/locales"
    local bin_file="${RELEASE_ROOT}/*.bin"
    local pak_file="${RELEASE_ROOT}/*.pak"
    local unwind_file="${RELEASE_ROOT}/gen/chrome/android/chrome_public_apk_unwind_assets/unwind_cfi_32"
    local webpak_file="${RELEASE_ROOT}/gen/chrome/android/webapk/libs/runtime_library/webapk5.dex"
    $RSYNC $local $bin_file $pak_file  $unwind_file $webpak_file  "$assets_dst/"
    $RSYNC $lib_so1 $lib_so2 "$jni_dst/"
}

echo "kiwi root dir:${KIWI_ROOT}" 
echo "gradle project dir:${GRADLE_PRO_ROOT}"

sync_assets_from_kiwi 

