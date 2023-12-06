package com.rohit.splitwiseclone.repository;

import org.apache.catalina.Group;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
