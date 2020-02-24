#!/usr/bin/env bash
gradle clean build &&
gradle docker &&
docker-compose up