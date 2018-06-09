package inisg.boot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inisg.boot.entity.JsonResult;
import inisg.boot.entity.Project;
import inisg.boot.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public Project saveProject(@RequestBody Project project) {
		Project savedProject = projectService.saveProject(project);
		return savedProject;
	}
	
	@GetMapping
	public List<Project> getProjects() {
		List<Project> pjts = projectService.getProjects();
		return pjts;
	}
	
	@GetMapping("/{id}")
	public Project getProject(@PathVariable long id) {
		Project pjt = projectService.getProject(id);
		return pjt;
	}
		
	@PutMapping("/{id}")
	public Project updateProject(@PathVariable long id, @RequestBody Project project) {
		project.setId(id);
		Project updatedProject = projectService.updateProject(project);
		return updatedProject;
	}
	
	@DeleteMapping("/{id}")
	public JsonResult deleteProject(@PathVariable long id) {
		projectService.removeProject(id);
		return new JsonResult(HttpStatus.OK.toString(), "REMOVED");
	}
}
