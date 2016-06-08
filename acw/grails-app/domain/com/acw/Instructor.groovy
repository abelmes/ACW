package com.acw

class Instructor {
    User user
    String instructorId
    static belongsTo=Course
    static hasMany = [courses:Course]
    static constraints = {
    }
    String toString(){
    	this.user?.firstName+" "+this.user?.lastName
    }
}
