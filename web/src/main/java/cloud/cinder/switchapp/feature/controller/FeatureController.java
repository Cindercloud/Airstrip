package cloud.cinder.switchapp.feature.controller;

import cloud.cinder.switchapp.application.service.ApplicationService;
import cloud.cinder.switchapp.feature.service.FeatureService;
import cloud.cinder.switchapp.feature.service.dto.FeatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/dashboard/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;
    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public String list(ModelMap modelMap) {
        modelMap.put("features", featureService.findAll());
        return "features/list";
    }

    @GetMapping(value = "/add")
    public String create(@ModelAttribute("featureDto") final FeatureDTO productDto,
                         ModelMap modelMap) {
        modelMap.put("applications", applicationService.findAll());
        return "features/edit";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@ModelAttribute("featureDto") final FeatureDTO featureDTO,
                       @PathVariable("id") final long id,
                       final ModelMap modelMap) {
        featureDTO.fill(featureService.findOne(id)
            .orElseThrow(IllegalArgumentException::new));
        modelMap.put("applications", applicationService.findAll());
        return "features/edit";
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("featureDto") final FeatureDTO featureDTO,
                       final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "features/edit";
        }
        featureService.save(featureDTO);
        return "redirect:/features";
    }
}
