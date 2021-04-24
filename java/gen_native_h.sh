#!/bin/bash

java=$(pwd)
c=$java/../c
javac -h $c $java/src/main/java/org/jetbrains/research/boolector/Native.java
native=$c/org_jetbrains_research_boolector_Native.h

if [ -f $native ] 
then 
	mv $native $c/JavaBoolector.h
else
	echo "Header not generated"
fi
