import com.zfx.*
class BootStrap {

    def init = { servletContext ->
      //Authority roles
      def adminRole = Authority.findOrCreateByAuthority('ROLE_ADMIN')
      adminRole.save()

      def userRole = Authority.findOrCreateByAuthority('ROLE_USER')
      userRole.save()

      // Companies
      def comOne = Company.findOrCreateByName('zfx')
      comOne.save()

      def comTwo = Company.findOrCreateByName('xyz')
      comTwo.save()

      def comThree = Company.findOrCreateByName('abc').save()
      // ZfxUser
      def zfxUser = new ZfxUser(name:'lin', username:'linz', password:'pp').save()

      // Add user to companies
      comOne.addToCompanyUsers(zfxUser)
      comOne.save()

      comTwo.addToCompanyUsers(zfxUser)
      comTwo.save()

      // Establish company and user and auth
      def comOneUser = new CompanyUser(person:zfxUser, company:comOne, authority:adminRole).save()
      comOne.addToMembership(comOneUser).save()
      //PersonAuthority.create zfxUser, adminRole

      //def comTwoUser = new CompanyUser(user:zfxUser, company:comTwo, companyAuth:)

      def comTwoUser = new CompanyUser(person:zfxUser, company:comTwo, authority:userRole).save()
      comTwo.addToMembership(comTwoUser).save()
      //PersonAuthority.create zfxUser, userRole

      PersonAuthority.withSession{
        it.flush()
        it.clear()
      }
    }
    def destroy = {
    }
}
