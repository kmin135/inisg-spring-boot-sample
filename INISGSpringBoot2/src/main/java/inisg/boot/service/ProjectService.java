package inisg.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inisg.boot.dao.ProjectRepository;
import inisg.boot.entity.Project;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	public Project getProject(long id) {
		return projectRepo.findOne(id);
	}

	public List<Project> getProjects() {
		return projectRepo.findAll();
	}
	
	public Project saveProject(Project saveProject) {
		return projectRepo.save(saveProject);
	}

	public void removeProject(long id) {
		projectRepo.delete(id);
	}
}
