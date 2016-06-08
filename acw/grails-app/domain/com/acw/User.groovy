package com.acw

class User {
    String userName
    String email
    String password
    String firstName
    String lastName
    static constraints = {
    }
    String toString(){
    	this.firstName+" "+this.lastName
    }
}
