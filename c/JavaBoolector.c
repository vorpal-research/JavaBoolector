#include "JavaBoolector.h"
#include <assert.h>
#include <limits.h>
#include "boolector.h"
#include "btoropt.h"
#include <stdio.h>
#include <btorlog.h>

Btor *btor;

JNIEXPORT void JNICALL Java_Native_btor(JNIEnv *env, jobject jobj) {
    btor = boolector_new();
}

JNIEXPORT void JNICALL Java_Native_assertForm(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode* node = (BoolectorNode*) jnode_ref;
    boolector_assert(btor,node);
}

JNIEXPORT jint JNICALL Java_Native_getSat(JNIEnv *env, jobject jobj) {
    return (jint) boolector_sat(btor);
}

JNIEXPORT void JNICALL Java_Native_btorRelease(JNIEnv *env, jobject jobj) {
    boolector_release_all(btor); //jfdsfjsdklfjksdljfkdsjfkldsjkfjsdkfjsdkfjkdslfjkdlsjfkls
    assert (boolector_get_refs(btor) == 0);
    boolector_delete(btor);
}

JNIEXPORT jlong JNICALL Java_Native_var(JNIEnv *env, jobject jobj, jlong jsort_ref, jstring jsymbol) {
    BoolectorNode *node;
    BoolectorSort sort = (BoolectorSort) jsort_ref;

    const char *str = (*env)->GetStringUTFChars(env, jsymbol, 0);
    if (strncmp(str, "nullINc", 7) == 0) {
        node = boolector_var(btor, sort, NULL);
    } else { node = boolector_var(btor, sort, str); }
    return (jlong) node;
}

JNIEXPORT jlong JNICALL Java_Native_eq(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_eq(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_not(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode* node = (BoolectorNode*) jnode_ref;
    return (jlong) boolector_not(btor, node);
}

JNIEXPORT jlong JNICALL Java_Native_add(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_add(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_and(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_and(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_or(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_or(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_xor(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_xor(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_neg(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode* node = (BoolectorNode*) jnode_ref;
    return (jlong) boolector_neg(btor, node);
}

JNIEXPORT jlong JNICALL Java_Native_copy(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode* node = (BoolectorNode*) jnode_ref;
    return (jlong) boolector_copy(btor,node);
}

JNIEXPORT jlong JNICALL Java_Native_sub(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_sub(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_mul(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_mul(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_sdiv(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_sdiv(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_udiv(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_udiv(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_smod(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_smod(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_urem(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_urem(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_sgt(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_sgt(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_sgte(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_sgte(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_slt(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_slt(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_slte(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_slte(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_sll(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_sll(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_srl(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_srl(btor, first_node,second_node);
}

JNIEXPORT jlong JNICALL Java_Native_sra(JNIEnv *env, jobject jobj, jlong jnode_first_ref, jlong jnode_second_ref) {
    BoolectorNode* first_node = (BoolectorNode*) jnode_first_ref;
    BoolectorNode* second_node = (BoolectorNode*) jnode_second_ref;
    return (jlong) boolector_sra(btor, first_node,second_node);
}

JNIEXPORT void JNICALL Java_Native_releaseNode(JNIEnv *env, jobject jobj, jlong jnode_ref) {
    BoolectorNode *node = (BoolectorNode *) jnode_ref;
    boolector_release(btor, node);
}


JNIEXPORT jlong JNICALL Java_Native_bitvecSort(JNIEnv *env, jobject jobj, jint width) {
    BoolectorSort s = boolector_bitvec_sort(btor, (uint32_t) width);
    return (jlong) s;
}

JNIEXPORT jboolean JNICALL Java_Native_isBitvecSort(JNIEnv *env, jobject jobj, jlong jsort_ref) {
    BoolectorSort s = (BoolectorSort) jsort_ref;
    return (jboolean) boolector_is_bitvec_sort(btor,s);
}

JNIEXPORT jint JNICALL Java_Native_getWidth(JNIEnv *env, jobject jobj, jlong jsort_ref) {
    BoolectorSort s = (BoolectorSort) jsort_ref;
    BoolectorNode* node = boolector_var(btor,s, NULL); //djgdjgklfdjkldfjgkfjblkcjvbklvcjb kbjk
    jint width = (jint) boolector_get_width(btor,node);
    boolector_release(btor,node);
    return width;
}

JNIEXPORT void JNICALL Java_Native_releaseSort(JNIEnv *env, jobject jobj, jlong jsort_ref) {
    BoolectorSort s = (BoolectorSort) jsort_ref;
    boolector_release_sort(btor, s);
}

