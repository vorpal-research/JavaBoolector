/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class Native */

#ifndef _Included_Native
#define _Included_Native
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     Native
 * Method:    btor
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Native_btor
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    btorRelease
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Native_btorRelease
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    var
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_Native_var
        (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     Native
 * Method:    releaseNode
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_Native_releaseNode
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    bitvecSort
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_Native_bitvecSort
        (JNIEnv *, jclass, jint);

/*
 * Class:     Native
 * Method:    releaseSort
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_Native_releaseSort
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    isBitvecSort
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_Native_isBitvecSort
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    isArraySort
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_Native_isArraySort
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    getWidth
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_Native_getWidth
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    not
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_Native_not
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    add
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_add
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    and
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_and
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    or
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_or
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    xor
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_xor
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    neg
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_Native_neg
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    eq
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_eq
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    copy
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_Native_copy
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    assertForm
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_Native_assertForm
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    getSat
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Native_getSat
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    sub
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_sub
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    mul
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_mul
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    sdiv
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_sdiv
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    udiv
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_udiv
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    smod
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_smod
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    urem
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_urem
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    sgt
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_sgt
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    sgte
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_sgte
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    slt
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_slt
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    slte
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_slte
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    sll
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_sll
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    srl
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_srl
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    sra
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_sra
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    implies
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_implies
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    iff
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_iff
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    concat
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_concat
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    cond
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_cond
        (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     Native
 * Method:    zero
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_Native_zero
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    constBitvec
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_Native_constBitvec
        (JNIEnv *, jclass, jstring);

/*
 * Class:     Native
 * Method:    isBoolSort
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_Native_isBoolSort
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    constNodeTrue
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_Native_constNodeTrue
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    constNodeFalse
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_Native_constNodeFalse
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    getSort
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_Native_getSort
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    getId
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_Native_getId
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    getSymbol
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_Native_getSymbol
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    simplify
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Native_simplify
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    constInt
 * Signature: (IJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_constInt
        (JNIEnv *, jclass, jint, jlong);

/*
 * Class:     Native
 * Method:    sext
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_Native_sext
        (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     Native
 * Method:    uext
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_Native_uext
        (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     Native
 * Method:    slice
 * Signature: (JII)J
 */
JNIEXPORT jlong JNICALL Java_Native_slice
        (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     Native
 * Method:    arraySort
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_arraySort
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    array
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_Native_array
        (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     Native
 * Method:    read
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_read
        (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     Native
 * Method:    write
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_write
        (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     Native
 * Method:    param
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_Native_param
        (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     Native
 * Method:    fun
 * Signature: ([JIJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_fun
        (JNIEnv *, jclass, jlongArray, jint, jlong);

/*
 * Class:     Native
 * Method:    apply
 * Signature: ([JIJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_apply
        (JNIEnv *, jclass, jlongArray, jint, jlong);

/*
 * Class:     Native
 * Method:    printModel
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Native_printModel
        (JNIEnv *, jclass);

/*
 * Class:     Native
 * Method:    getBits
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_Native_getBits
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    constLong
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_Native_constLong
        (JNIEnv *, jclass, jstring);

/*
 * Class:     Native
 * Method:    forAll
 * Signature: ([JIJ)J
 */
JNIEXPORT jlong JNICALL Java_Native_forAll
        (JNIEnv *, jclass, jlongArray, jint, jlong);

/*
 * Class:     Native
 * Method:    boolectorAssert
 * Signature: (Ljava/lang/String;J)Z
 */
JNIEXPORT jboolean JNICALL Java_Native_boolectorAssert
        (JNIEnv *, jclass, jstring, jlong);

/*
 * Class:     Native
 * Method:    kindNode
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_Native_kindNode
        (JNIEnv *, jclass, jlong);

/*
 * Class:     Native
 * Method:    writerInArray
 * Signature: (JJLjava/lang/String;[JI)J
 */
JNIEXPORT jlong JNICALL Java_Native_writerInArray
        (JNIEnv *, jclass, jlong, jlong, jstring, jlongArray, jint);

#ifdef __cplusplus
}
#endif
#endif
