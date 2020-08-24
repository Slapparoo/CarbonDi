// generated EC compiled source Core.FileUtils
#ifndef __C_2106303_FILEUTILS_H__
#define __C_2106303_FILEUTILS_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_FILEUTILS_DATA_ 
#define __C_2106303_FILEUTILS_CLASS_  \
  u64 (*filesize)(pointer);  \
  num (*fileread)(num);
typedef struct c_2106303_FileUtils_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_FILEUTILS_CLASS_
} c_2106303_FileUtils_cm;

typedef struct c_2106303_FileUtils {

__C_2106303_OBJECT_DATA_
__C_2106303_FILEUTILS_DATA_
} c_2106303_FileUtils;
pointer getc_2106303_FileUtils_cm();
void populatec_2106303_FileUtils_cm(pointer classModel);
num create_c_2106303_FileUtils();
/* default constructor */


#endif