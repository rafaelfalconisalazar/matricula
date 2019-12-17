package unibe.edu.ec.matricula.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unibe.edu.ec.matricula.controllers.PrerequirementController;
import unibe.edu.ec.matricula.dtos.PrerequirementDto;
import unibe.edu.ec.matricula.resources.exeptions.StudentIdNotFoundException;

import java.util.List;

@RestController
@RequestMapping(PrerequirementResource.PREREQUIREMENT)
public class PrerequirementResource {

    @Autowired
    private PrerequirementController prerequirementController;

    public static final String PREREQUIREMENT = "/prerequirements";
    public static final String ID="/{id}";

    @RequestMapping(value=ID,method = RequestMethod.GET)
    public List<PrerequirementDto> listPrerequirementForSubject(@PathVariable int id) throws StudentIdNotFoundException {
        return this.prerequirementController.listPrerequirementForSubject(id).orElseThrow(()->new StudentIdNotFoundException());
    }
}
