# JavaBoolector

JavaBoolector allows you to call [Boolector](https://github.com/boolector/boolector) from Java

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
