package com.ourevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ourevents.model.Equipment;
import com.ourevents.service.EquipmentService;

@Controller
public class EquipmentController {
	@Autowired
	EquipmentService equipmentService;

    //show the add movie form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewEquipment", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEquipment", "equ", new Equipment());
	}

    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewEquipment", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("equ") Equipment equ) {
		equipmentService.insertEquipment(equ);
		List<Equipment> equipments = equipmentService.getAllEquipments();
		ModelAndView model = new ModelAndView("getEquipments");
		model.addObject("equipments", equipments);
		return model;
	}

    //show all movies saved in db
	@RequestMapping("/getEquipments")
	public ModelAndView getEquipments() {
		List<Equipment> equipments = equipmentService.getAllEquipments();
		ModelAndView model = new ModelAndView("getEquipments");
		model.addObject("equipments", equipments);
		return model;
	}

}
