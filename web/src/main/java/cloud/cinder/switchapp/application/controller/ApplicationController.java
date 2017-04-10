package cloud.cinder.switchapp.application.controller;

import cloud.cinder.switchapp.application.service.ApplicationService;
import cloud.cinder.switchapp.application.service.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/dashboard/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public String list(ModelMap modelMap) {
        modelMap.put("applications", applicationService.findAll());
        return "applications/list";
    }

    @GetMapping(value = "/add")
    public String create(@ModelAttribute("applicationDto") final ApplicationDTO applicationDto) {
        return "applications/edit";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@ModelAttribute("applicationDto") final ApplicationDTO applicationDto,
                       @PathVariable("id") final long id) {
        applicationDto.fill(applicationService.findOne(id).orElseThrow(IllegalArgumentException::new));
        return "applications/edit";
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("appliationDto") final ApplicationDTO applicationDTO,
                       final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "applications/edit";
        }
        applicationService.save(applicationDTO);
        return "redirect:/applications";
    }

}
