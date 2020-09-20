#!/usr/bin/env bash

docker stop mock
docker rm mock
docker rmi mock

cd /root/mock/project
bash -x gradlew buildDocker --no-daemon --stacktrace -Dprod -Pprofile=prod -x test
docker logs -f mock