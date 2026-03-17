package lenny.taskmanagementsystem.domain.repository

import lenny.taskmanagementsystem.domain.model.Project

interface ProjectRepository{
    fun save(project: Project):Project
    fun findById(id:String):Project?
    fun findAll(): List<Project>
    fun deleById(id:String)
}