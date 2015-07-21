package com.thoughtworks.acit.controllers;

import com.thoughtworks.acit.domain.Project;
import com.thoughtworks.acit.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value="/projects", method = RequestMethod.GET)
    public ModelAndView display() {
        List<Project> projectList = projectService.getProjectList();
        //This is a useless line.
        ModelMap model = new ModelMap();
        model.put("projectList", projectList);
        return new ModelAndView("projects", model);
    }

}
