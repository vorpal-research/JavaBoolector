#!/bin/bash

JavaBoolector=$(pwd)
javac -h . Native.java
c=$JavaBoolector/../../../../c
native=$JavaBoolector/Native.h
if [ -f $native ] 
then 
mv $native $c/JavaBoolector.h
fi
