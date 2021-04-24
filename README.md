# JavaBoolector

JavaBoolector allows you to call [Boolector](https://github.com/boolector/boolector/tree/0dba411bebb9ac70fd03de68f984ccb5bd3e1a03) from Java.

*We are using Boolector version 3.2.1*

## Build

Build jar with all the dependencies:

```shell
$ mvn clean package
```

## Adding new bindings

    1) Add your native method to the Native class
	
	2) Generate JavaBoolector.h:
```shell
$ cd JavaBoolector/java
$ ./gen_native_h.sh
```
	3) And implement your method in JavaBoolector.c
