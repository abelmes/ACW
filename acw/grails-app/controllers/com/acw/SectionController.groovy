package com.acw

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SectionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Section.list(params), model:[sectionCount: Section.count()]
    }

    def show(Section section) {
        respond section
    }

    def create() {
        respond new Section(params)
    }

    @Transactional
    def save(Section section) {
        if (section == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (section.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond section.errors, view:'create'
            return
        }

        section.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'section.label', default: 'Section'), section.id])
                redirect section
            }
            '*' { respond section, [status: CREATED] }
        }
    }

    def edit(Section section) {
        respond section
    }

    @Transactional
    def update(Section section) {
        if (section == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (section.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond section.errors, view:'edit'
            return
        }

        section.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'section.label', default: 'Section'), section.id])
                redirect section
            }
            '*'{ respond section, [status: OK] }
        }
    }

    @Transactional
    def delete(Section section) {

        if (section == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        section.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'section.label', default: 'Section'), section.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'section.label', default: 'Section'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
