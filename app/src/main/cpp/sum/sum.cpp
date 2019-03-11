//
// Created by Sangmin Shim on 11/03/2019.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_kr_co_everspin_hellondk_MainActivity_getSum(
        JNIEnv *env,
        jobject, jint val1, jint val2) {

    return val1 + val2;
}
