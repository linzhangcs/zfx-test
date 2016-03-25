import com.zfx.*
class BootStrap {

    def init = { servletContext ->
      def adminRole = Authority.findOrCreateByAuthority('ROLE_ADMIN')
      adminRole.save()
      def admin = new Person('lin', 'p')
      admin.save()

      def zfxUser = new ZfxUser(name:'lin', username:'linz', password:'pp').save()

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
