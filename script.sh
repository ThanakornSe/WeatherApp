#!/bin/bash
#
# Copyright (C) 2022 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Verify bash version. macOS comes with bash 3 preinstalled.
#if [[ ${BASH_VERSINFO[0]} -lt 4 ]]
#then
#  echo "You need at least bash 4 to run this script."
#  exit 1
#fi

# exit when any command fails
set -e

if [[ $# -lt 2 ]]; then
   echo "Usage: bash script.sh my.new.package [ApplicationName]" >&2
   exit 2
fi

PACKAGE=$1
APPNAME=$2
SUBDIR=${PACKAGE//.//} # Replaces . with /

for n in $(find . -type d \( -path '*/src/androidTest' -or -path '*/src/main' -or -path '*/src/test' \) )
do
  echo "Creating $n/kotlin/$SUBDIR"
  mkdir -p $n/kotlin/$SUBDIR
  echo "Moving files to $n/kotlin/$SUBDIR"
  mv $n/kotlin/android/template/* $n/kotlin/$SUBDIR
  echo "Removing old $n/kotlin/android/template"
  rm -rf mv $n/kotlin/android
done

# Rename package and imports
echo "Renaming packages to $PACKAGE"
find ./ -type f -name "*.kt" -exec sed -i.bak "s/package android.template/package $PACKAGE/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/import android.template/import $PACKAGE/g" {} \;

# Gradle files
find ./ -type f -name "*.kts" -exec sed -i.bak "s/android.template/$PACKAGE/g" {} \;

# Rename app
if [[ $APPNAME ]]
then
    echo "Renaming app to $APPNAME"
    find ./ -type f \( -name "TemplateApplication.kt" -or -name "settings.gradle.kts" -or -name "*.xml" \) -exec sed -i.bak "s/TemplateApplication/$APPNAME/g" {} \;
    find ./ -name "TemplateApplication.kt" | sed "p;s/TemplateApplication/$APPNAME/" | tr '\n' '\0' | xargs -0 -n 2 mv
    find . -name "*.bak" -type f -delete
fi

echo "Cleaning up"
find . -name "*.bak" -type f -delete

# Remove additional files
#echo "Removing additional files"
#rm -rf .google/
#rm -rf .github/
#rm -rf CONTRIBUTING.md LICENSE README.md script.sh
#rm -rf .git/
echo "Done!"