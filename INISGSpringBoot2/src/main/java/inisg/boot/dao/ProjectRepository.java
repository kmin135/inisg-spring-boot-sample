package inisg.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import inisg.boot.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
