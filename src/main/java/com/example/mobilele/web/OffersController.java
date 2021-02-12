package com.example.mobilele.web;

import com.example.mobilele.models.bindings.OfferServiceModel;
import com.example.mobilele.models.entities.enums.Engine;
import com.example.mobilele.models.entities.enums.Transmission;
import com.example.mobilele.services.BrandService;
import com.example.mobilele.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;


    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }


    @ModelAttribute("offerModel")
    public OfferServiceModel offerModel() {
        return new OfferServiceModel();
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String newOffer(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());

        return "offer-add";
    }


    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute OfferServiceModel offerModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect: add";
        }
        long newOfferId = offerService.save(offerModel);

        return "redirect:offer/" + newOfferId;
    };


//    @GetMapping("/details")
//    public String showDetails(Model model){
//      model.addAttribute("offer", offerService.getOfferById (model.getAttribute("id")));
//
//      return "details";
//    }

    @GetMapping("/offer/{id}")
    public String offerDetails(@PathVariable Long id,
                               Model model) {

        model.addAttribute("id", id);
        model.addAttribute("offer", offerService.getOfferEntity((Long) id));

        return "details";
    }

    @DeleteMapping("/offer/{id}")
    public String delete(@PathVariable Long id,
                         Model model) {

        offerService.delete(id);

        return "redirect:/offers/all";
    }


}

