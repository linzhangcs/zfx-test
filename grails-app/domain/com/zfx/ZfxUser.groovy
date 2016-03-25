package com.zfx
import groovy.transform.ToString

@ToString(includes='name', includeNames=true, includePackage=false)
class ZfxUser extends Person{

    String name;

    static constraints = {
      name (blank:false, nullable:false, size:3..30, matches:"[a-zA-Z1-9_]+")
    }
}
