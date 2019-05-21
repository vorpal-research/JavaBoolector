#!/bin/bash

JavaBoolector=$(pwd)
javac -h . Native.java
c=$JavaBoolector/../../../../../../../../c
native=$JavaBoolector/org_jetbrains_research_boolector_Native.h
if [ -f $native ] 
then 
mv $native $c/JavaBoolector.h
fi
