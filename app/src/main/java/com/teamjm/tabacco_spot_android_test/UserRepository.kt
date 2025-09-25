package com.teamjm.tabacco_spot_android_test

class UserRepository {
    fun saveUser(user: User) {
        // 데이터베이스나 다른 곳에 사용자를 저장하는 로직
        println("Saving user: ${user.name}")
    }
}