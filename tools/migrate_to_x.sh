#!/bin/bash
set -e
cd /home/asroot/chromium/

GRADLE_PRO_ROOT="./kiwi-androidx"
GRADLE_PRO_TEMPLATE="${GRADLE_PRO_ROOT}/tools/gradle_project_androidx"
APP_ROOT="${GRADLE_PRO_ROOT}/app"
APP_JAVA_ROOT="${APP_ROOT}/src/main/java"
APP_RES_ROOT="${APP_ROOT}/src/main/res"
APP_LIB_ROOT="${APP_ROOT}/libs"

RSYNC="rsync -ah -r -P"

build_gradle_project() {
    $RSYNC "${GRADLE_PRO_TEMPLATE}/"  "${GRADLE_PRO_ROOT}/"
}

echo "kiwi root dir:${KIWI_ROOT}"
echo "gradle project dir:${GRADLE_PRO_ROOT}"



build_gradle_project

