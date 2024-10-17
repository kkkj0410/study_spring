package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//CRUD 함수를 JpaRepository가 들고 있음
//@Repository라는 어노테이션이 없어도 IoC 가능. 이유는 JpaRepository 상속받았기 때문
public interface UserRepository extends JpaRepository<User,Integer> {
}
