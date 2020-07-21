package shushar.ppmtool.web;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shushar.ppmtool.domain.Project;
import shushar.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @PostMapping("")
  public ResponseEntity<?> createNewProject(@Valid  @RequestBody Project project, BindingResult result){

    if(result.hasErrors())
      return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
   Project obj= projectService.saveorUpdateProject(project);
    // Return status 201 for now
    return new ResponseEntity<Project>(obj, HttpStatus.CREATED);
  }

}
