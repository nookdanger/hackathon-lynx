#!/usr/bin/env bash

TAG="v1.0.15"
DOMAIN="lynx"
APP_NAME="lynx-api"
REGISTRY_PATH="swr.ap-southeast-2.myhuaweicloud.com/$DOMAIN/$APP_NAME:$TAG"

./gradlew --build-file "build.gradle.kts" clean build -x test

docker rmi "$(docker images | grep $APP_NAME)"

docker build . -t $REGISTRY_PATH

docker push $REGISTRY_PATH
