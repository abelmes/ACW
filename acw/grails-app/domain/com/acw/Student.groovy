package com.acw

class Student {
    User   user
    String studentId
    static belongsTo = [department:Department]
    static hasmany = [courses:Course]
    static constraints = {
    }
    String toString(){
    	this.user?.firstName+" "+this.user?.lastName
    }
}
