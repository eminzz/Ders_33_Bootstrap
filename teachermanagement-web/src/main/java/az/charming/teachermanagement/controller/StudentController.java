package az.charming.teachermanagement.controller;

import az.charming.entity.StudentEntity;
import az.charming.repository.StudentRepository;
import az.charming.teachermanagement.dto.StudentFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class StudentController {

    private final StudentRepository studentRepository = new StudentRepository();

    @RequestMapping(value = "students", method= {RequestMethod.GET})
    public String index(Model model,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
                        ){
        model.addAttribute("list",studentRepository.findList(
                name,
                surname,
                age,
                scholarship
        ));
        return "students/index";
    }

    @RequestMapping(value = "students/add", method= {RequestMethod.POST})
    public String add(@ModelAttribute StudentEntity studentEntity){
        studentRepository.insert(studentEntity);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/update", method= {RequestMethod.POST})
    public String update(@ModelAttribute StudentEntity studentEntity){
        studentRepository.update(studentEntity);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/delete", method= {RequestMethod.POST})
    public String delete(@RequestParam(required = false) Integer id){
        studentRepository.delete(id);
        return "redirect:/students";
    }
}
