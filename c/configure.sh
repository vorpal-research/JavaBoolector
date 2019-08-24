#!/bin/bash

javaBoolectorC=$(pwd)
echo $javaBoolectorC
git submodule init
git submodule update

cd boolector
./contrib/setup-lingeling.sh

./contrib/setup-btor2tools.sh

./configure.sh --shared

cd build
make
cd
cd $javaBoolectorC
./lib_in_resources.sh
