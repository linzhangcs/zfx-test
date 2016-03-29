package com.zfx
import grails.plugin. springsecurity.annotation.Secured

class SecuredController {
def springSecurityService
  @Secured('ROLE_USER')
	def index() {
		render 'ROLE_USER or ROLE_ADMIN'
    render springSecurityService.authentication.principal.authorities
	}

	@Secured('ROLE_ADMIN')
	def admin() {
		render 'ROLE_ADMIN'
	}
}
