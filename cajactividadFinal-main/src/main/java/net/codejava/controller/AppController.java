package net.codejava.controller;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.codejava.entity.CuentaUsuario;
import net.codejava.entity.Formulario;
import net.codejava.entity.Imc;
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
    Double estatura;
    
    
    @Autowired
    private ImcService imcService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

    /* 
        Aqui se empieza a ejecutar el programa, se revisa si el usuario tiene
        una sesion activa, sino se le redirigue a la pagina de login, en nuestro caso,
        la segunda opcion no se usa.
        Esta pagina de inicio viene siendo index.html, donde veremos los registros de imc
    */
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
    
    /* 
        Luego de pulsar el enlace de registro, se nos se llevara a
        la direccion /registro, donde podremos ingresar datos de registro
        Esta es registro.html
    */
    @RequestMapping("/registro")
    public String registro(CuentaUsuario cuentaUsuario) {
        return "registro";
    }

    /* 
        Una vez hecho el registro se validan los campos y de ser correctos 
        se crea una sesion con estos y volvemos a index.html. De lo contrario se señalan los errores.
    */
    @PostMapping("/registro")
    public String checarInfo(@Valid CuentaUsuario cuentaUsuario, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "registro";
        }
        session.setAttribute("mySessionAttribute", cuentaUsuario.getNombreUsuario());
        return "redirect:/";
    }

    /* 
        Esto ocurre al pulsar en el enlace de agregar.
        Se añade al modelo el atributo de imcObj que será aquel que tiene 
        los valores para mostrar en index
    */
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Imc imcObj = new Imc();
//        imcObj.setEstatura(cuentaUsuario.getEstatura());
        
        model.addAttribute("imcObj", imcObj);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("imcObj") Imc imcObj, CuentaUsuario cuentaUsuario) {
//        imcObj.getId();
//        imcObj.setImc(imcObj.getPeso() / Math.pow((imcObj.getEstatura())/100, 2));
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        NumberFormat n = NumberFormat.getIntegerInstance();
        //nombre = cuentaUsuario.getNombrePersona();
        estatura = Double.valueOf(cuentaUsuario.getEstatura());
        
        
        imcObj.setNombrePersona(cuentaUsuario.getNombrePersona()); // cuentaUsuario.getNombrePersona()
        imcObj.setEstatura(estatura); // Double.valueOf(cuentaUsuario.getEstatura())
        imcObj.setImc(Double.parseDouble(n.format(imcObj.getPeso()/ Math.pow((imcObj.getEstatura())/100, 2))));
        imcObj.setFecha(dtf2.format(LocalDateTime.now()));
        imcService.save(imcObj);
        return "redirect:/";
    }
    
//    @RequestMapping(value = "/resultado", method = RequestMethod.POST)
    @PostMapping("/resultado")
    public String mostrarResultado(Imc imcObj, CuentaUsuario cuentaUsuario){
//        imcObj.setEstatura(cuentaUsuario.getEstatura());
//        imcObj.setImc(imcObj.getPeso() / Math.pow((imcObj.getEstatura())/100, 2));
        imcService.save(imcObj);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
//        session.setAttribute("mySessionAttribute", "sasas");

        // model.addAttribute("listProducts", listProducts);
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
