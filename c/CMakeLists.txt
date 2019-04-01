cmake_minimum_required(VERSION 3.5.1)
set(PROJECT_NAME JavaBoolectorC)
project(${PROJECT_NAME})
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/lib)

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

set(BOOLECTOR_DIR ${PROJECT_SOURCE_DIR}/boolector)
set(BOOLECTOR_INCLUDE_DIRS ${BOOLECTOR_DIR}/src)
set(BOOLECTOR_INCLUDE_LIB ${BOOLECTOR_DIR}/build/lib)
include_directories(${BOOLECTOR_INCLUDE_DIRS})
link_directories(${BOOLECTOR_INCLUDE_LIB})

set(SOURCES JavaBoolector.c)
set(HEADERS JavaBoolector.h)
add_library(JavaBoolector SHARED ${HEADER} ${SOURCES})

set_target_properties(JavaBoolector PROPERTIES LINKER_LANGUAGE C)
target_link_libraries(JavaBoolector boolector)






