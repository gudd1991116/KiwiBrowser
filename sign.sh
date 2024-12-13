export PATH=$PATH:~/Android/Sdk/build-tools/28.0.3/
echo $PATH
apksigner sign -verbose  -ks ~/android.ztehealth  -ks-key-alias android.ztehealth \
        --ks-pass pass:ztehealth-pdcl --key-pass pass:ztehealth-pdcl \
        --in ./app/build/outputs/apk/release/app-release-unsigned.apk --out out.apk
