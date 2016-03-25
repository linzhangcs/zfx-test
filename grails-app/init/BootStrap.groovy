import com.zfx.*
class BootStrap {

    def init = { servletContext ->
      def adminRole = Authority.findOrCreateByAuthority('ROLE_ADMIN')
      adminRole.save()
      def admin = new Person('lin', 'p')
      admin.save()

      PersonAuthority.create admin, adminRole

      PersonAuthority.withSession{
        it.flush()
        it.clear()
      }
    }
    def destroy = {
    }
}
