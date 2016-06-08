package com.acw

class Department {
    String name
    static hasmany = [admins:Admin,courses:Course,students:Student,sections:Section]
    static constraints = {
    }
    String toString(){
    	this.name
    }
}
