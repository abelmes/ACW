package com.acw

class Section {
	String name
    static belongsTo=[department:Department]
    static hasmany = [students:Student,instructors:Instructor]
    static constraints = {
    }
    String toString(){
    	this.name
    }
}
