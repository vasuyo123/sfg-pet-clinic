package com.vjava.sfgpetclinic.controller;

import com.vjava.sfgpetclinic.model.Owner;
import com.vjava.sfgpetclinic.services.OwnerService;
import com.vjava.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private final VisitService visitService;

    public OwnerController(OwnerService ownerService, VisitService visitService) {
        this.ownerService = ownerService;
        this.visitService = visitService;
    }

//    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String listOwners(Model model) {
//        model.addAttribute("owners", ownerService.findAll());
//        return "owners/index";
//    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.findAllByLastNameIgnoreCaseLike("%"+owner.getLastName()+"%");

        if(owners.isEmpty()){
            bindingResult.rejectValue("lastName", "notFound", "notFound");
            return "owners/findOwners";
        }else if(owners.size() == 1){
            owner = owners.get(0);
            return "redirect:/owners/"+owner.getId();
        }else{
            model.addAttribute("selections", owners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findById(ownerId);
        mav.addObject(owner);
        return mav;
    }

    //id field set by system so, dont allow UI forms to manipulate it
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

}
