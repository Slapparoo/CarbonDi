
#ifndef __COREOBJECT__
#define __COREOBJECT__

#include "types.h"

pointer Object_asStr(num ref);
pointer Object_data(num ref);
// pointer Object_asString(num ref);
void Object_printTo(num ref, pointer stream);
pointer Object_alloc(num ref, u64 amount);
pointer Object_realloc(num ref, pointer ptr, u64 amount);
void Object_free(num ref);

#endif