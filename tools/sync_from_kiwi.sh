#!/bin/bash
set -e 
cd /home/asroot/chromium/

GRADLE_PRO_ROOT="./kiwi-androidx"
GRADLE_PRO_TEMPLATE="${GRADLE_PRO_ROOT}/tools/gradle_project"
APP_ROOT="${GRADLE_PRO_ROOT}/app"                    
APP_JAVA_ROOT="${APP_ROOT}/src/main/java"
APP_RES_ROOT="${APP_ROOT}/src/main/res"
APP_LIB_ROOT="${APP_ROOT}/libs"
MODULES_ROOT="${GRADLE_PRO_ROOT}/libraries"

KIWI_ROOT="/home/asroot/chromium/kiwi/src"
RELEASE_ROOT="${KIWI_ROOT}/out/android_arm"

RSYNC="rsync -ah -r -P"

make_folder() {
	mkdir -p "${APP_JAVA_ROOT}"
}

#//base   
sync_base() {
    local src_code="${KIWI_ROOT}/base/android/java/src/*"
    local base_code="${APP_JAVA_ROOT}"
    cp -r  $src_code ${base_code}/
}

sync_base_res() {
    local base_res_dest="${MODULES_ROOT}/base_res/src/main"
    mkdir -p $base_res_dest/res
    #  product_version  in   org.chromium.base.R.sring 
    local chrome_product_version="${RELEASE_ROOT}/gen/chrome/android/templates/chrome_version_xml/res"
    $RSYNC "$chrome_product_version"  "$base_res_dest/"

}


sync_blink() {
    local blink_code="${APP_JAVA_ROOT}"
    echo "missing -------------------------------   blink"
    #cp -r "${KIWI_ROOT}/bl"  ${blink_code}/
}

sync_build() {
    local src_code="${KIWI_ROOT}/build/android/buildhooks/java/org"
    local build_code="${APP_JAVA_ROOT}"
    $RSYNC $src_code ${build_code}/
}

sync_content() {
    local src_root="${KIWI_ROOT}/content/public/android/java/src/org"
    local content_code="${APP_JAVA_ROOT}"
    $RSYNC "$src_root"  "$content_code/"
}

sync_content_res() {
    local content_res_dest="${MODULES_ROOT}/content_res/src/main"
    mkdir -p $content_res_dest/res
    local content_res="${KIWI_ROOT}/content/public/android/java/res"
    local content_res_gen="${RELEASE_ROOT}/gen/content/public/android/content_strings_grd_grit_output/"
    echo "sync conten  .. res"
    $RSYNC "$content_res"      "$content_res_dest/"
    echo "sync content .. gen"
    $RSYNC "$content_res_gen"  "$content_res_dest/res/"
}


sync_chrome() {
    #feed java third_party
    local src_code="${KIWI_ROOT}/chrome/android"
    local feed_code="${src_code}/feed/core/java/src/org"
    local third_code="${src_code}/third_party/compositor_animator/java/src/org"
    local webapk_root="${src_code}/webapk/libs"
    local chrome_root="${APP_JAVA_ROOT}"
    $RSYNC "$feed_code"  ${chrome_root}/
    $RSYNC "${src_code}/java/src/org"  ${chrome_root}/
    $RSYNC "${src_code}/java/src/com"  ${chrome_root}/
    $RSYNC "$third_code" ${chrome_root}/
    $RSYNC "${webapk_root}/client/src/org" ${chrome_root}/
    $RSYNC "${webapk_root}/common/src/org" ${chrome_root}/
    $RSYNC "${webapk_root}/runtime_library/src/org" ${chrome_root}/
}

sync_chrome_res() {
    #name space must be:   org.chromium.chrome.R .....
    local chrome_res_dest="${MODULES_ROOT}/chrome_res/src/main"
    mkdir -p $chrome_res_dest/res
    local chrome_android_res="${KIWI_ROOT}/chrome/android/java/res"
    #channel_constants.xml
    local chrome_java_res="${KIWI_ROOT}/chrome/android/java/res_chromium/"
    local chrome_java_res_gen="${RELEASE_ROOT}/gen/chrome/java/res"
    local chrome_java_res_template="${KIWI_ROOT}/chrome/android/java/res_template/"
    local chrome_string_gen="${RELEASE_ROOT}/gen/chrome/android/chrome_strings_grd_grit_output/"
    local policy_res_gen="${RELEASE_ROOT}/gen/chrome/app/policy/android/"
    local chrome_vr_res="${KIWI_ROOT}/chrome/android/java/res_vr/"
    $RSYNC "$chrome_android_res" "$chrome_java_res_gen"      "$chrome_res_dest/"
    $RSYNC "$chrome_string_gen" "$chrome_java_res" "$policy_res_gen"  "$chrome_res_dest/res"
    $RSYNC "$chrome_java_res_template" "$chrome_vr_res"  "$chrome_res_dest/res"

    ## resource in components !!!!
    local components_chromium_str_gen="${RELEASE_ROOT}/gen/components/strings/java/res"
    $RSYNC "$components_chromium_str_gen"  "$chrome_res_dest/" 
}


sync_components() {
    local src_root="${KIWI_ROOT}/components"
    local components_code="${APP_JAVA_ROOT}"
    local autofill="$src_root/autofill/android/java/src/org"
    local task_scheduler="$src_root/background_task_scheduler/android/java/src/org"
    local bookmarks="$src_root/bookmarks/common/android/java/src/org"
    echo "missing ---------------------------------//components/bookmarks/BookmakrType"
    local contentview="$src_root/content_view/java/src/org"
    local crash="$src_root/crash/android/java/src/org"
    local dom1="$src_root/dom_distiller/content/browser/android/java/src/org"
    local dom2="$src_root/dom_distiller/core/android/java/src/org"
    local download1="$src_root/download/internal/background_service/android/java/src/org"
    echo "missing ---------------------------------//components/download/DownloadState"
    local feature1="$src_root/feature_engagement/public/android/java/src/org"
    local feature2="$src_root/feature_engagement/internal/android/java/src/org"
    local gcm_driver1="$src_root/gcm_driver/instance_id/android/java/src/org"
    local gcm_driver2="$src_root/gcm_driver/android/java/src/org"
    local invalidation="$src_root/invalidation/impl/android/java/src/org"
    local location="$src_root/location/android/java/src/org"
    echo "missing ---------------------------------//components/location/LocationSettingsDialogxx"
    local minidump="$src_root/minidump_uploader/android/java/src/org"
    local navigation="$src_root/navigation_interception/android/java/src/org"
    local offlinecore="$src_root/offline_items_collection/core/android/java/src/org"
    echo "missing ---------------------------------//components/offlinepage/ "
    local payment="$src_root/payments/content/android/java/src/org"
    local safebrow="$src_root/safe_browsing/android/java/src/org"
    echo "missing ---------------------------------//components/security_state"
    local signin="$src_root/signin/core/browser/android/java/src/org"
    local spellcheck="$src_root/spellcheck/browser/android/java/src/org"
    echo "missing ---------------------------------//components/superxx/FilteringBehaviorReason"
    local sync="$src_root/sync/android/java/src/org"
    echo "missing ---------------------------------//components/ui_metrics"
    local uiformatter="$src_root/url_formatter/android/java/src/org"
    local variation="$src_root/variations/android/java/src/org"
    local versioninfo="$src_root/version_info/android/java/src/org"
    local webcontent="$src_root/web_contents_delegate_android/java/src/org"
    local webrestrict="$src_root/web_restrictions/browser/java/src/org"
    $RSYNC "$autofill" "$task_scheduler" "$bookmarks" "$contentview" "$crash" "$dom1" "$dom2" \
           "$download1" "$feature1" "$feature2" "$gcm_driver1" "$gcm_driver2" "$invalidation" \
           "$location" "$minidump" "$navigation" "$offlinecore" "$payment" "$safebrow" "$signin" \
           "$spellcheck" "$sync" "$uiformatter" "$variation" "$versioninfo" "$webrestrict"\
           "$webcontent" \
           "$components_code/"
}

sync_components_res() {
    mkdir -p ${MODULES_ROOT}/{autofill,web_content}/src/main/res
    local autofill_res_dest="${MODULES_ROOT}/autofill/src/main"
    local web_content_res_dest="${MODULES_ROOT}/web_content/src/main"
    local components_root="${KIWI_ROOT}/components"
    local autofill_res="$components_root/autofill/android/java/res"
    local autofill_gen_res="${RELEASE_ROOT}/gen/components/autofill/android/autofill_strings_grd_grit_output/"
    $RSYNC "$autofill_res"  "$autofill_res_dest/"   
    $RSYNC "$autofill_gen_res" "$autofill_res_dest/res"

    local web_content_res="$components_root/web_contents_delegate_android/java/res/"
    local web_content_gen_res="${RELEASE_ROOT}/gen/components/web_contents_delegate_android/web_contents_delegate_android_strings_grd_grit_output/"
    $RSYNC "$web_content_res" "$web_content_gen_res" "$web_content_res_dest/res"
}

sync_device() {
     #battery bluetooth  gamepad  geolocation mojom nfc power_ ......
     local battery_code="${KIWI_ROOT}/services/device/battery/android/java/src/org"
     local device_code="${APP_JAVA_ROOT}"
     $RSYNC "${battery_code}" ${device_code}/
     local bluetooth_code="${KIWI_ROOT}/device/bluetooth/android/java/src/org"
     $RSYNC "${bluetooth_code}" ${device_code}/
     local gamepad_code="${KIWI_ROOT}/device/gamepad/android/java/src/org"
     $RSYNC "${gamepad_code}"  ${device_code}/
     local geolocation_code="${KIWI_ROOT}/device/geolocation/android/java/src/org"
     $RSYNC "${geolocation_code}"  ${device_code}/
     echo "missing -------------------------  /device/mojom"
     local nfc_code="${KIWI_ROOT}/services/device/nfc/android/java/src/org"
     $RSYNC "$nfc_code" ${device_code}/
     local usb_code="${KIWI_ROOT}/device/usb/android/java/src/org"
     $RSYNC "$usb_code" ${device_code}/
     local vr_code="${KIWI_ROOT}/device/vr/android/java/src/org"
     $RSYNC "$vr_code" ${device_code}/
     #-- some in //service/device
     local sensor_code="${KIWI_ROOT}/services/device/generic_sensor/android/java/src/org"
     local screen_code="${KIWI_ROOT}/services/device/screen_orientation/android/java/src/org"
     local timezone_code="${KIWI_ROOT}/services/device/time_zone_monitor/android/java/src/org"
     local vibra_code="${KIWI_ROOT}/services/device/vibration/android/java/src/org"
     #-- power_save_blocker
     local wakelock_code="${KIWI_ROOT}/services/device/wake_lock/power_save_blocker/android/java/src/org"
     $RSYNC "$sensor_code"   ${device_code}/
     $RSYNC "$screen_code"   ${device_code}/
     $RSYNC "$timezone_code" ${device_code}/
     $RSYNC "$vibra_code"    ${device_code}/
     $RSYNC "$wakelock_code" ${device_code}/
}

sync_media() {
     local media_root="${KIWI_ROOT}/media"
     local media_code="${APP_JAVA_ROOT}"
     local base_code="$media_root/base/android/java/src/org"
     #local audio_code="$media_root/audio/android/java/src/org"
     local content_code="$media_root/capture/content/android/java/src/org"
     local video_code="$media_root/capture/video/android/java/src/org"
     #local gpu_code="$media_root/gpu/android/java/src/org"
     #local filter_code="$media_root/filters/android/java/src/org"
     local midi_code="$media_root/midi/java/src/org"
     $RSYNC "$base_code"  "$content_code" "$video_code" "$midi_code" \
            "${media_code}/"
}

sync_media_res() {
    mkdir -p ${MODULES_ROOT}/media/src/main/res
    local media_dst="${MODULES_ROOT}/media/src/main"
    local media_src="${KIWI_ROOT}/media/base/android/java/res/"
    $RSYNC "$media_src" "$media_dst/res" 

}

sync_customtabs() {
    mkdir -p ${MODULES_ROOT}/customtabs/src/main/res

    local customtabs_root="${KIWI_ROOT}/third_party/custom_tabs_client/src/customtabs"
    $RSYNC "${customtabs_root}/src/"  "${APP_JAVA_ROOT}"

    $RSYNC "${customtabs_root}/res/"  "${MODULES_ROOT}/customtabs/src/main/res"
}

sync_mojo(){
	 local mojo_root="${KIWI_ROOT}/mojo/public/java"
     local mojo_code="${APP_JAVA_ROOT}"
 	 local base_code="$mojo_root/base/src/org"
     local bind_code="$mojo_root/bindings/src/org"
     local sys_code="$mojo_root/system/src/org"
     local mojo_android_sys_code="${KIWI_ROOT}/mojo/android/system/src/org"
	 $RSYNC "$base_code" "$bind_code" "$sys_code" "$mojo_android_sys_code"  "${mojo_code}/"
}

sync_net() {
	 local net_root="${KIWI_ROOT}/net/android/java/src/org"
     local net_code="${APP_JAVA_ROOT}"
     $RSYNC "$net_root" "${net_code}/"
     echo "missing ---------------------------------//net/interfaces"
	 echo "missing ---------------------------------//network/mojom"

}  

sync_print() {
	 local print_root="${KIWI_ROOT}/printing/android/java/src/org"
     $RSYNC "$print_root"  "${APP_JAVA_ROOT}/"
}

sync_services() {
     local service_root="${KIWI_ROOT}/services"
     local service_code="${APP_JAVA_ROOT}"
     local base_code="$service_root/device/android/java/src/org"
     local public_code="$service_root/device/public/java/src/org"
     local shape_code="$service_root/shape_detection/android/java/src/org"
     local manager_code="$service_root/service_manager/public/java/src/org"
     local decoder_code="$service_root/data_decoder/public/cpp/android/java/src/org"
     $RSYNC "$base_code"  "$public_code" "$shape_code" "$manager_code" "$decoder_code" \
            "$service_code/"
}

sync_third() {
     local third_root="${KIWI_ROOT}/third_party"
     local third_code="${APP_JAVA_ROOT}"
     local chart_code="$third_root/android_data_chart/java/src/org" 
     local swipe_code="$third_root/android_swipe_refresh/java/src/org" 
     local media_code="$third_root/android_media/java/src/org"
     $RSYNC "$chart_code" "$swipe_code" "$media_code"  "$third_code"
}

sync_third_res() {
    mkdir -p ${MODULES_ROOT}/{android_media,android_data_chart}/src/main/res
    local android_media_dst="${MODULES_ROOT}/android_media/src/main"
    local chart_dst="${MODULES_ROOT}/android_data_chart/src/main"
    local android_media_src="${KIWI_ROOT}/third_party/android_media/java/res/"
    local chart_src="${KIWI_ROOT}/third_party/android_data_chart/java/res/"
    $RSYNC "$android_media_src" "$android_media_dst/res"
    $RSYNC "$chart_src" "$chart_dst/res"
}

sync_ui() {
     local ui_root="${KIWI_ROOT}/ui/android/java/src/org"
     local ui_code="${APP_JAVA_ROOT}"
     $RSYNC "$ui_root"  "$ui_code"
     echo "missing ---------------------------------//ui/touch_selection"
     echo "missing ---------------------------------//ui/mojom"
}

sync_ui_res() {
    mkdir -p ${MODULES_ROOT}/ui_res/src/main/res
    local ui_res_src="${KIWI_ROOT}/ui/android/java/res"
    local ui_res_gen="${RELEASE_ROOT}/gen/ui/android/ui_strings_grd_grit_output/"
    local ui_res_dest="${MODULES_ROOT}/ui_res/src/main/"
    $RSYNC "$ui_res_src"  "$ui_res_dest/"
    $RSYNC "$ui_res_gen"  "$ui_res_dest/res/"
}


sync_other() {
    #echo "missing  ---------------------------------//gfx/mojom "
    #echo "missing  ---------------------------------//gpu/mojom "
    #echo "missing  ---------------------------------//installedapp/mojom "
    #echo "missing  ---------------------------------//payments/mojom"
    #echo "missing  ---------------------------------//policy java file .  class is in libs" 
    local policy_jar="${RELEASE_ROOT}/gen/components/policy/android/policy_java.javac.jar"
    mkdir -p "${APP_JAVA_ROOT}/org/chromium/policy/missing_java"
    $RSYNC "$policy_jar"  "$APP_LIB_ROOT/"
    #echo "missing  ---------------------------------//proxy_resolver/mojom"
    #echo "missing  ---------------------------------//service_manager/mojom"
    #echo "missing  ---------------------------------//signin/InvestigatedScenario"
    #echo "missing  ---------------------------------//skia/mojom"
    #echo "missing  ---------------------------------//url/mojom"
    #echo "missing  ---------------------------------//webauth/mojom"
    #echo "missing  ---------------------------------//webshare/mojom"
    local gcm_jar="${RELEASE_ROOT}/lib.java/third_party/android_tools/support/gcm.jar"
    $RSYNC "$gcm_jar"  "$APP_LIB_ROOT/"
    local proto_jar="${RELEASE_ROOT}/lib.java/third_party/protobuf/protobuf_lite_javalib.jar"
    $RSYNC "$proto_jar" "$APP_LIB_ROOT/"

}

sync_com_google() {
    local com_android_root="${KIWI_ROOT}/chrome/android/java/src/com"
    local ipc="${KIWI_ROOT}/third_party/cacheinvalidation/src/java/com"
    local protobuf_android="${KIWI_ROOT}/third_party/android_protobuf/src/java/src/device/main/java/com"
    local protobuf_android_base="${KIWI_ROOT}/third_party/android_protobuf/src/java/src/main/java/com"
    local protobuf_base="${KIWI_ROOT}/third_party/protobuf/java/core/src/main/java/com"
    local protos="${KIWI_ROOT}/third_party/cacheinvalidation/src/java/com"
    local feed="${KIWI_ROOT}/third_party/feed/src/src/main/java/com"
    local proto_nano="${KIWI_ROOT}/third_party/webrtc/third_party/protobuf/javanano/src/main/java/com"
    local com_google_dst="${APP_JAVA_ROOT}"
    $RSYNC "$ipc" "$com_android_root" "$protobuf_android" "$protobuf_android_base"  "$protobuf_base" \
           "$protos" "$feed"\
           "$com_google_dst/"

    echo "missing  ---------------------------------//com/google/common"
    ##com.google.common.* in    third_party/bazel/desugar/Desugar-runtime.jar
    local com_google_common_jar="${KIWI_ROOT}/third_party/bazel/desugar/Desugar-runtime.jar"
    $RSYNC "$com_google_common_jar"  "$APP_LIB_ROOT/" 
    #
    echo "missing  ---------------------------------//com/google/devtools protos"
    echo "missing  ---------------------------------//com/google/firebase search"

}

sync_com_feed_res() {
    mkdir -p ${MODULES_ROOT}/{feed_piet,feed_basicstream}/src/main/res
    local piet_dst="${MODULES_ROOT}/feed_piet/src/main"
    local basicstream_dst="${MODULES_ROOT}/feed_basicstream/src/main"
    local piet_src="${KIWI_ROOT}/third_party/feed/src/src/main/java/com/google/android/libraries/feed/piet/res/"
    local basicstream_src="${KIWI_ROOT}/third_party/feed/src/src/main/java/com/google/android/libraries/feed/basicstream/internal/viewholders/res/"
    $RSYNC "$piet_src" "$piet_dst/res"
    $RSYNC "$basicstream_src" "$basicstream_dst/res"
}



sync_jp() {
    local gif_root="${KIWI_ROOT}/third_party/gif_player/src/jp"
    local jp_code="${APP_JAVA_ROOT}"
    $RSYNC "$gif_root"  "$jp_code/"
    
}

extract_gen_code() {
    echo "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
    echo "---------------------  EXTRACT SRCJAR ---------------------------------------------- "
    local gen_root="${RELEASE_ROOT}/gen"
    local extract_root="${APP_ROOT}/ext"
    rm -rf $extract_root 
    mkdir $extract_root
    find $gen_root -name "*.srcjar" -exec unzip -o {} -d $extract_root \;
    $RSYNC "$extract_root/" "${APP_JAVA_ROOT}/" 
}


sync_build_gen() {
    #./components/version_info/android/java/org/chromium/components/version_info/VersionConstants.java    
    local verinfo_root="${RELEASE_ROOT}/gen/components/version_info/android/java/org"
    # gen1 error !!!!  NativeLibraries.java !!!!!
    local base_gen1="${RELEASE_ROOT}/gen/base/base_native_libraries_gen/java_cpp_template/org"
    local base_gen2="${RELEASE_ROOT}/gen/chrome/android/chrome_public_apk__build_config_java/java_cpp_template/org"
    local dest_root="${APP_JAVA_ROOT}"
    $RSYNC "$verinfo_root" "$base_gen1" "$base_gen2"  "$dest_root/"
    #$RSYNC "$base_gen2" "${MODULES_ROOT}/base_res/src/main/java/"

    echo " SYNC gen: AndroidManifest.xml !!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    local manifest_src="$RELEASE_ROOT/gen/chrome/android/chrome_public_apk/AndroidManifest.xml"
    $RSYNC "$manifest_src" "$APP_ROOT/src/main"
    echo " SYNC gen: NativeLibraries.java !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    local base_native="${RELEASE_ROOT}/gen/chrome/android/chrome_public_apk__native_libraries_java/java_cpp_template/org"
    $RSYNC "$base_native" "$dest_root"
    echo " SYNC gen: NetError.java "
    local net_err="${RELEASE_ROOT}/gen/net/android/net_errors_java/java_cpp_template/org"
    $RSYNC "$net_err" "$dest_root"

}

sync_from_kiwi_code() {
    make_folder
    sync_base
    sync_blink
    sync_build
    sync_content
    sync_chrome
    sync_components
    sync_device
    sync_media
	sync_mojo
	sync_net
    sync_print
    sync_services
    sync_third
    sync_ui

    sync_other
    sync_com_google
    sync_jp
}

sync_from_kiwi_aidl() {
    echo ""
}

sync_from_kiwi_res() {
    sync_base_res
    sync_content_res
    sync_chrome_res
    sync_components_res
    sync_third_res
    sync_media_res
    sync_com_feed_res
    sync_ui_res
    sync_customtabs
}

clean_project() {
    rm -rf ${APP_ROOT}/src/main/java/org/org \
        ${APP_ROOT}/src/main/java/org/src \
        ${APP_ROOT}/src/main/java/org/com \
        ${APP_ROOT}/src/main/java/com/google/protobuf\
        ${APP_ROOT}/src/main/java/org/chromium/chrome/browser/MonochromeApplication.java \
        ${APP_ROOT}/src/main/java/org/chromium/chrome/browser/preferences/password/PasswordEntryEditorPreference.java \
        ${APP_ROOT}/src/main/java/org/chromium/chrome/browser/offlinepages/evaluation \
        ${APP_ROOT}/src/main/java/{src,test,templates}

    local feed_dir="${APP_ROOT}/src/main/java/com/google/android/libraries/feed"
    find "$feed_dir" -regextype "posix-egrep" -regex ".*/(testing|test_data|res)" -type d -print0 | \
        xargs -0 rm -rf

    find "$feed_dir" -regextype "posix-egrep" -regex ".*/AndroidManifest.xml" -type f -print0 | \
        xargs -0 rm -f

    
    local del_files="README|OWNERS|COPYING|BUILD|.*\.template|R\.java|.*\.stamp|.*stamp\.d|.*\.py|.*\.flags|.*\.aidl"
    find "$APP_ROOT" -regextype "posix-egrep" -regex ".*/(${del_files})" -type f -print0 |xargs -0 rm -f  

    #remove unuseable java in smali
    rm -rf ${APP_JAVA_ROOT}/org/chromium/chrome/browser/display_cutout
}

notice() {
    echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    echo "need import dep:google-gcm"
    echo "need import dep:google-gms"
    echo "need import dep:gvr-android-sdk"
    echo "need import dep:leakcanary-1.4-beta1"
}

sync_from_kiwi() {
    sync_from_kiwi_code
    #   no use !! > sync_from_kiwi_aidl  code from extract_gen_code
    sync_build_gen
#    extract_gen_code
    sync_from_kiwi_res
    #--------------------
    clean_project
    #--------------------
    notice
}

build_gradle_project() {
    $RSYNC "${GRADLE_PRO_TEMPLATE}/"  "${GRADLE_PRO_ROOT}/"
}

echo "kiwi root dir:${KIWI_ROOT}" 
echo "gradle project dir:${GRADLE_PRO_ROOT}"

sync_from_kiwi 

echo "---------------- need port to androidX -------------"
