package com.zfx
import grails.plugin. springsecurity.annotation.Secured

class SecuredController {

  @Secured('ROLE_USER')
	def index() {
		render 'ROLE_USER or ROLE_ADMIN'
	}

	@Secured('ROLE_ADMIN')
	def admin() {
		render 'ROLE_ADMIN'
	}
}
