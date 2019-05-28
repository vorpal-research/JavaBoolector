#!/bin/bash

javaBoolector=$(pwd)

cd $javaBoolector/c
./configure.sh
cd
cd $javaBoolector
cd $javaBoolector/java
mvn clean package
