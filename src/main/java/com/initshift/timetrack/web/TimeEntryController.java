package com.initshift.timetrack.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.initshift.timetrack.domain.TimeEntry;
import com.initshift.timetrack.repository.TimeEntryRepository;

@Controller
@RequestMapping("/timeEntry")
public class TimeEntryController {
	
	private TimeEntryRepository repository;
	
    @Autowired
    public void setTimeEntryRepository(TimeEntryRepository repository) {
      this.repository = repository;
    }
    
	@RequestMapping(method = RequestMethod.GET)
    public String timeEntry(Model model) {
		TimeEntry timeEntry = new TimeEntry();
    	model.addAttribute("timeEntry", timeEntry);
    	model.addAttribute("timeEntryList", repository.findAll());
        return "timeEntry";
    }

	@RequestMapping("/{id:\\d+}")
    public String editTimeEntry(@PathVariable Long id, Model model) {
		model.addAttribute("timeEntry", repository.findOne(id));
		model.addAttribute("timeEntryList", repository.findAll());
		return "timeEntry";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String timeEntrySubmit(@Valid TimeEntry timeEntry, BindingResult bindingResult, 
    		Model model, final RedirectAttributes redirectAttributes) {
		
			if (bindingResult.hasErrors()) {
	            return "timeEntry";
	        }

			repository.save(timeEntry);
			
			return "redirect:/timeEntry";
			
	}
	
	@RequestMapping("/multiple")
	public String timeEntryMultiple(Model model) {
		
		TimeEntry timeEntry = new TimeEntry();
    	model.addAttribute("timeEntries", timeEntry);
    	model.addAttribute("timeEntryList", repository.findAll());
    	
		return "timeEntryMultiple";
	}
	
}
