package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.codejava.services.ProductService;
import net.codejava.Usuario;
import net.codejava.entity.CuentaUsuario;
import net.codejava.entity.Formulario;
import net.codejava.entity.Imc;
import net.codejava.entity.Product;
import net.codejava.services.ImcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private ProductService service;
    @Autowired
    private ImcService imcService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
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
    
    @RequestMapping("/registro")
    public String registro(CuentaUsuario cuentaUsuario) {
        return "registro";
    }

    @PostMapping("/registro")
    public String checarInfo(@Valid CuentaUsuario cuentaUsuario, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "registro";
        }
        return "redirect:/index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Imc imcObj = new Imc();
        model.addAttribute("imcObj", imcObj);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("imcObj") Imc imcObj) {
        imcService.save(imcObj);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Imc imcObj = imcService.get(id);
        mav.addObject("imc", imcObj);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        imcService.delete(id);
        return "redirect:/";
    }
}
