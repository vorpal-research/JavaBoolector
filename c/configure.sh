#!/bin/bash

boolector=$(pwd)
echo "$boolector"
ls
git submodule init
git submodule update

cd boolector
./contrib/setup-lingeling.sh

./contrib/setup-btor2tools.sh

./configure.sh --shared

cd build
make
