package shushar.ppmtool.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shushar.ppmtool.domain.Project;
import shushar.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public Project saveorUpdateProject(Project project){
// Passing simple project obj and going to be persisted on the db.
    //Logic


    return projectRepository.save(project);
    }

}
