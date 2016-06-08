package com.acw

class Admin {
	User user
    Role role
    static belongsTo = [department:Department]
    static constraints = {
    }
    String toString(){
    	this.user?.firstName+" "+this.user?.lastName
    }
}
