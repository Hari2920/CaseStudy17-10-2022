package com.gl.recharegApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.rechargeApp.bean.Bill;
import com.gl.rechargeApp.bean.Offer;
import com.gl.rechargeApp.service.RechargeService;

@RestController
public class RechargeController {
	
	@Autowired
	private RechargeService service;
	
	@GetMapping(value="/index")
	 public ModelAndView showWelcomePage() {
		ModelAndView mv = new ModelAndView("index");
		List<Offer> offerList = service.findAllOffers();
		mv.addObject("offerList",offerList);
		return mv;
	}
	
	@GetMapping("/performRecharge")
	public ModelAndView saveNewBill(@RequestParam("mobileNumber") String num,
									  @RequestParam("offerId") long offerId) {
		long id = service.generateId();
		Bill bill = new Bill();
		bill.setMobileNumber(num);
		bill.setOfferId(offerId);
		bill.setTransactionId(offerId);
		service.billSave(bill);
		Offer offer = service.findAOffer(offerId);
		ModelAndView mv = new ModelAndView("bill");
		mv.addObject("offer",offer);
		mv.addObject("bill",bill);
		return mv;
	}
}