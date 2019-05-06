#!/bin/bash

JavaBoolector=$(pwd)
javac -h . Native.java
c=$JavaBoolector/../../../../../../../c
native=$JavaBoolector/io_github_boolector_Native.h
if [ -f $native ] 
then 
mv $native $c/JavaBoolector.h
fi
