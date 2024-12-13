rem SET PATH=%PATH%;~/Android/Sdk/build-tools/28.0.3/
set PATH=%PATH%;D:\Android\_android-sdk\build-tools\28.0.3;C:\Java\jre1.8\bin;D:\msys64\usr\bin
apksigner sign -verbose  -ks ./android.ztehealth  -ks-key-alias android.ztehealth --ks-pass pass:ztehealth-pdcl --key-pass pass:ztehealth-pdcl  --in ./app/build/outputs/apk/release/app-release-unsigned.apk --out out.apk
pause