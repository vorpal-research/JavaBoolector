#include "JavaBoolector.h"
#include <assert.h>
#include <limits.h>
#include "boolector.h"
#include "btoropt.h"
#include <stdio.h>
#include <btorlog.h>

Btor *btor;

JNIEXPORT void JNICALL Java_JBtor_jbtorC(JNIEnv *env, jobject jobj) {
    btor = boolector_new();
}

JNIEXPORT void JNICALL Java_JBtor_jbtorReleaseC(JNIEnv *env, jobject jobj) {
    assert (boolector_get_refs(btor) == 0);
    boolector_delete(btor);
}

JNIEXPORT jlong JNICALL Java_JBoolectorNode_jboolectorVarC
        (JNIEnv *env, jobject jobj, jlong jsort_ref, jstring jsymbol) {

    BoolectorNode *node;
    BoolectorSort sort = (BoolectorSort ) jsort_ref;

    const char *str = (*env)->GetStringUTFChars(env, jsymbol, 0);
    if (strncmp(str, "nullINc", 7) == 0) {
        node = boolector_var(btor, sort, NULL);
    } else { node = boolector_var(btor, sort, str); }
    return (jlong) node;
}

JNIEXPORT jlong JNICALL Java_JBoolectorNode_jboolectorCopyC(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode* node = (BoolectorNode *) jnode_ref;
    BoolectorNode* copy;
    copy = boolector_copy(btor, node);
    return (jlong) copy;
}

JNIEXPORT jlong JNICALL
Java_JBoolectorNode_jboolectorXorC(JNIEnv *env, jobject jobj, jlong jfirst_node_ref, jlong jsecond_node_ref) {
    BoolectorNode *first = (BoolectorNode *) jfirst_node_ref;
    BoolectorNode *second = (BoolectorNode *) jsecond_node_ref;
    BoolectorNode *xor = boolector_xor(btor, first, second);
    return (jlong) xor;
}

JNIEXPORT jlong  JNICALL
Java_JBoolectorNode_jboolectorEqC(JNIEnv *env, jobject jobj, jlong jfirst_node_ref, jlong jsecond_node_ref) {
    BoolectorNode *first = (BoolectorNode *) jfirst_node_ref;
    BoolectorNode *second = (BoolectorNode *) jsecond_node_ref;
    BoolectorNode *eq = boolector_eq(btor, first, second);
    return (jlong) eq;
}

JNIEXPORT jlong  JNICALL
Java_JBoolectorNode_jboolectorAndC(JNIEnv *env, jobject jobj, jlong jfirst_node_ref, jlong jsecond_node_ref) {
    BoolectorNode *first = (BoolectorNode *) jfirst_node_ref;
    BoolectorNode *second = (BoolectorNode *) jsecond_node_ref;
    BoolectorNode *and = boolector_and(btor, first, second);
    return (jlong) and;
}

JNIEXPORT jlong  JNICALL Java_JBoolectorNode_jboolectorNotC(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode *node = (BoolectorNode *) jnode_ref;
    BoolectorNode *not= boolector_not(btor, node);
    return (jlong) not;
}

JNIEXPORT void JNICALL Java_JBoolectorNode_jboolectorAssertC(JNIEnv *env, jobject obj, jlong jnode_ref) {
    BoolectorNode *node = (BoolectorNode *) jnode_ref;
    boolector_assert(btor, node);
}

JNIEXPORT void JNICALL Java_JBoolectorNode_jboolectorReleaseC(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode *node = (BoolectorNode *) jnode_ref;
    boolector_release(btor, node);
}


JNIEXPORT jlong JNICALL Java_JBoolectorSort_jboolectorBitvecSortC(JNIEnv *env, jobject jobj, jint width) {
    BoolectorSort s= boolector_bitvec_sort(btor, (uint32_t) width);
    return (jlong) s;
}

JNIEXPORT void JNICALL Java_JBoolectorSort_jboolectorReleaseSortC(JNIEnv *env, jobject jobj, jlong jsort_ref) {
    BoolectorSort s = (BoolectorSort) jsort_ref;
    boolector_release_sort(btor, s);
}

JNIEXPORT jint JNICALL Java_JBoolectorSat_jboolectorSatC(JNIEnv *env, jobject jobj) {
    int result = boolector_sat(btor);
    switch (result) {
        case BOOLECTOR_SAT:
            return 10;
        case BOOLECTOR_UNSAT:
            return 20;
        default:
            return 0;
    }
}
