#!/bin/bash

javaBoolectorC=$(pwd)
git submodule init
git submodule update

cd boolector
./contrib/setup-lingeling.sh

./contrib/setup-btor2tools.sh

./configure.sh --shared

cd build
make

cd ./$javaBoolectorC
cmake .
make
./lib_in_resources.sh
