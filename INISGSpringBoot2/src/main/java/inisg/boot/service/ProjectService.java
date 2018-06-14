package inisg.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import inisg.boot.dao.ProjectRepository;
import inisg.boot.entity.Project;

@Service
public class ProjectService {
	private static Logger log = LoggerFactory.getLogger(ProjectService.class);
	@Autowired
	private ProjectRepository projectRepo;

	@Cacheable(value="projectCache", key="#id")
	public Project getProject(long id) {
		log.debug("# get project {}", id);
		return projectRepo.findOne(id);
	}

	public List<Project> getProjects() {
		log.debug("# get all projects");
		return projectRepo.findAll();
	}
	
	@CacheEvict(value="projectCache", key="#saveProject.id")
	public Project saveProject(Project saveProject) {
		log.debug("# save project {}", saveProject.toString());
		return projectRepo.save(saveProject);
	}
	
	@CacheEvict(value="projectCache", key="#updateProject.id")
	public Project updateProject(Project updateProject) {
		log.debug("# update project {}", updateProject.toString());
		return projectRepo.save(updateProject);
	}
	
	@CacheEvict(value="projectCache", key="#id")
	public void removeProject(long id) {
		log.debug("# remove project {}", id);
		projectRepo.delete(id);
	}
}
