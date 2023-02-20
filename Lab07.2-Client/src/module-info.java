/**
 * This module is the "client" module, and it consists of packages:
 * com.entertainment.client
 *
 * As the "client" module, it does not export anything.
 * BUT it does need to declare a dependency on module com.entertainment.
 */
module com.entertainment.client {
// what other *modules* does this module depend on?
// this module has access (visibility) to the *exported* packages (only)
// of the other module
    requires com.entertainment;     // this is a *module* name
}