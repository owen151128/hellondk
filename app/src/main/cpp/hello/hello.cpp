//
// Created by Sangmin Shim on 11/03/2019.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_kr_co_everspin_hellondk_MainActivity_getHelloWorld(
        JNIEnv *env,
        jobject) {
    std::string hello = "Hello World";
    return env->NewStringUTF(hello.c_str());
}
