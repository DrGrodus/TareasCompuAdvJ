package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.ProductService;
import net.codejava.Usuario;
import net.codejava.entity.Formulario;
import net.codejava.entity.Imc;
import net.codejava.entity.Product;
import net.codejava.services.ImcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private ProductService service;
    @Autowired
    private ImcService imcService;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
//            List<Product> listProducts = service.listAll();
            List<Imc> listImc = imcService.listAll();
            model.addAttribute("listImc", listImc);
            return "index";
        } else {
            model.addAttribute("formulario", new Formulario());
            return "login";
        }
        //model.addAttribute("listProducts", listProducts);
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("mySessionAttribute", "sasas");

        // model.addAttribute("listProducts", listProducts);
        return "redirect:/";
    }

    @RequestMapping("/new")
    public String showNewProductPage(/*Model model,*/ Model model) {
//        Product product = new Product();
        Imc imcObj = new Imc();
//        model.addAttribute("product", product);
        model.addAttribute("imcObj", imcObj);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("imcObj") Imc imcObj) {
//        service.save(product);
        imcService.save(imcObj);
//        imc.setId(1);
//        imc.setNombrePersona("Alfredo");
//        imc.setEstatura(1.80);
//        imc.setPeso(87d);
//        imcService.save(imc);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
//        Product product = service.get(id);
        Imc imcObj = imcService.get(id);
        mav.addObject("imc", imcObj);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
//        service.delete(id);
        imcService.delete(id);
        return "redirect:/";
    }
}
