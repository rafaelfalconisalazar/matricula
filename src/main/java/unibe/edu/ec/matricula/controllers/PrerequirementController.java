package unibe.edu.ec.matricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import unibe.edu.ec.matricula.dtos.PrerequirementDto;
import unibe.edu.ec.matricula.entities.Prerequirement;
import unibe.edu.ec.matricula.entities.Subject;
import unibe.edu.ec.matricula.repositories.PrerequirementRepository;
import unibe.edu.ec.matricula.repositories.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PrerequirementController {

    @Autowired
    private PrerequirementRepository prerequirementRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public Optional<List<PrerequirementDto>> listPrerequirementForSubject(int id) {
        Optional<Subject> subject = this.subjectRepository.findById(id);
        if (subject.isPresent()) {
            List<PrerequirementDto> prerequirementDtos = new ArrayList<PrerequirementDto>();
            List<Prerequirement> prerequirements = this.prerequirementRepository.findPrerequirementBySubject(subject.get());
            for (Prerequirement prerequirement :
                    prerequirements) {
                prerequirementDtos.add(new PrerequirementDto(prerequirement));

            }
            return Optional.of(prerequirementDtos);
        } else {
            return Optional.empty();
        }
    }
}
