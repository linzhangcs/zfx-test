import com.zfx.*
class BootStrap {

    def init = { servletContext ->
      def adminRole = Authority.findOrCreateByAuthority('ROLE_ADMIN')
      adminRole.save()
      def admin = new Person('lin', 'p')
      admin.save()

      def comOne = Company.findOrCreateByName('zfx')
      comOne.save()


      def zfxUser = new ZfxUser(name:'lin', username:'linz', password:'pp').save()

      comOne.addToCompanyUsers(zfxUser)
      comOne.save()

      def comOneUser = new CompanyUser(user:zfxUser, company:comOne, companyAuth:adminRole).save()
      comOne.addToMembership(comOneUser).save()

      PersonAuthority.create admin, adminRole
      PersonAuthority.create zfxUser, adminRole

      PersonAuthority.withSession{
        it.flush()
        it.clear()
      }
    }
    def destroy = {
    }
}
