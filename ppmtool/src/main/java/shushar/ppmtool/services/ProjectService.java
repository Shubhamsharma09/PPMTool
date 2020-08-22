package shushar.ppmtool.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shushar.ppmtool.domain.Project;
import shushar.ppmtool.exceptions.ProjectIdException;
import shushar.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public Project saveorUpdateProject(Project project){
// Passing simple project obj and going to be persisted on the db.
    //Logic

try{
  project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
    return projectRepository.save(project);
}catch(Exception e)
{
  throw new ProjectIdException("Project ID "+project.getProjectIdentifier().toUpperCase()+" already exists");
}


}

public Project findProjectByIdentifier(String projectId)
{
    Project project =projectRepository.findByProjectIdentifier(projectId.toUpperCase());
  if(project == null)
    throw new ProjectIdException("Project ID "+projectId+" doesn't exist");

    return project;
}

public Iterable<Project> findAllProjects(){
return projectRepository.findAll();
}

public void deleteProjectByIdentifier(String projectid)
{
  Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());

  if(project == null){
    throw  new ProjectIdException("Project ID"+projectid+"doesn't exist");
  }
  projectRepository.delete(project);
}



}
