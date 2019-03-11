
cmake_minimum_required(VERSION 3.4.1)

add_library(
        sum
        SHARED
        sum/sum.cpp
)

add_library(
        hello
        SHARED
        hello/hello.cpp
)

find_library(
        log-lib
        log)

target_link_libraries(
        sum
        ${log-lib})

target_link_libraries(
        hello
        ${log-lib})
