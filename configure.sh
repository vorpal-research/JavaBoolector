#!/bin/bash

javaBoolector=$(pwd)

$javaBoolector/c/configure.sh
$javaBoolector/java/mvn clean package
