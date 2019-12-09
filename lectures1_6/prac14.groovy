package lectures1_6

import groovy.transform.Field

// Anotated Fields
/*
Using the @Field annotation allows the declared variable to be available to the script's methods (functions).
 */

@Field def x
@Field String y
def z
int v

def func() {
// x, y are visible
// z, v - not
}