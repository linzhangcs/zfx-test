package com.zfx
import groovy.transform.ToString

@ToString(cache=true, includeNames=true, includePackage=false)
class Company {

    String name
    static hasMany = [companyUsers:ZfxUser, membership: CompanyUser]

    Company(String name){
      this.name = name
    }
    String toString(){
      "${name}"
    }
    static constraints = {
      name unique: true, blank: false
    }
}
