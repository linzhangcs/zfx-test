package com.zfx
import groovy.transform.ToString

@ToString(cache=true, includeNames=true, includePackage=false)
class CompanyUser {

    //Company company
    //ZfxUser user
    ZfxUser user
    Company company
    Authority companyAuth

    CompanyUser(ZfxUser user, Company company, Authority companyAuth){
      this.company = company
      this.user = user
      this.companyAuth = companyAuth
    }
    static constraints = {

    }
}
