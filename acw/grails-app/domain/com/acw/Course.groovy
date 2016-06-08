package com.acw

class Course {
    String title 
    String courseNo
    int    creditHour
    static hasMany = [instructors:Instructor]
    static constraints = {
    }
    String toString(){
    	this.title
    }
}
