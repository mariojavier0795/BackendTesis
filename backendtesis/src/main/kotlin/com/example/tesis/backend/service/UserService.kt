package com.example.tesis.backend.service

import com.example.tesis.backend.entity.User
import com.example.tesis.backend.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service()
class UserService(private val userRepository : UserRepository) {

    fun saveUser(user: User?): User {
        var userSaved = User()
        if(user != null) {
            userSaved = userRepository.save(user)
        }
        return userSaved
    }

    fun logInUser(username: String?, password: String?): ResponseEntity<List<User>> =
            ResponseEntity.ok(userRepository.findUser(username, password))

    /*fun getTaskById(taskId: Long): ResponseEntity<Task> =
            taskRepository.findById(taskId).map { task ->
                ResponseEntity.ok(task)
            }.orElse(ResponseEntity.notFound().build())

    fun putTask(taskId: Long, newTask: Task): ResponseEntity<Task> =
            taskRepository.findById(taskId).map { currentTask ->
                val updatedTask: Task =
                        currentTask
                                .copy(
                                        title = newTask.title,
                                        description = newTask.description,
                                        status = newTask.status,
                                        startDate = newTask.startDate,
                                        priority = newTask.priority,
                                        dueDate = newTask.dueDate
                                )
                ResponseEntity.ok().body(taskRepository.save(updatedTask))
            }.orElse(ResponseEntity.notFound().build())

    fun deleteTask(taskId: Long): ResponseEntity<Void> =
            taskRepository.findById(taskId).map { task ->
                taskRepository.delete(task)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())*/

}