// Preprocessor macros
// expand some common functions
#define printf(x...) External.stdio.printf(x)
#define sprintf(x...) External.stdio.sprintf(x)
#define fprintf(x...) External.stdio.fprintf(x)
#define throw(x...) External.core.throw(x)
#define throwException(x...) External.core.throwException(x)
#define tmpBuffer External.core.getTmpBuffer()
#define EC_ADDRESS(x...) External.core.EC_ADDRESS(x)
#define EC_ARRAY(x...) External.core.EC_ARRAY(x)
#define EC_SETVALUE_i8(x...) External.core.EC_SETVALUE_i8(x)
#define debug_println(x...) External.core.debug_println(x)

#define testStrEqual(x...) External.core.testStrEqual(x)
#define testi64Equal(x...) External.core.testi64Equal(x)
#define ecprintf(x...) External.core.ecprintf(x)
#define print(x...) External.core.ecprintf(x)