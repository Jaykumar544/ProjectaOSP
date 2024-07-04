package com.biit.controller;

import com.biit.entities.Employee;
import com.biit.entities.Feedback;
import com.biit.entities.Product;
import com.biit.entities.User;
import com.biit.repositories.FeedbackRepository;
import com.biit.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/AddProduct")
    public String addingProduct()
    {
        return "AddProduct";
    }

    @RequestMapping("/AddInProcess")
    public String submittingProduct(@ModelAttribute Product product)
    {
        productRepository.save(product);
        return "AddProduct";
    }

    @RequestMapping("/doSearch")
    public ModelAndView doSearch(@RequestParam String name, @RequestParam String type)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchedProducts");

        if(stringEmptyReverseCheck(name) && stringEmptyReverseCheck(type))
        {
            List<Product> products = productRepository.findByNameAndType(name,type);
            modelAndView.addObject("products",products);
        }
        else if (stringEmptyReverseCheck(name))
        {
            List<Product> products = productRepository.findByName(name);
            modelAndView.addObject("products",products);

        }
        else if(stringEmptyReverseCheck(type))
        {
            List<Product> products = productRepository.findByType(type);
            modelAndView.addObject("products",products);
        }
        else
            modelAndView.addObject("products",null);
        return modelAndView;
    }

    @RequestMapping("/productsReport")
    public ModelAndView productsReport()
    {
        List<Product> products = productRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",products);
        modelAndView.setViewName("productsReport");
        return  modelAndView;
    }

    @RequestMapping("/deleteProduct/{id}")
    public ModelAndView deleteProduct(@PathVariable int id)
    {
        Optional<Product> optionalUser=productRepository.findById(id);
        if(optionalUser.isPresent())
            productRepository.delete(optionalUser.get());
        else
            System.out.println("Product not found.");
        return productsReport();
    }

    @RequestMapping("/updateProduct/{id}")
    public ModelAndView productUpdate(@PathVariable int id)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productUpdate");
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent())
        {
            Product product = optionalProduct.get();
            modelAndView.addObject("productId",product.getId());
            modelAndView.addObject("productName",product.getName());
            modelAndView.addObject("productType",product.getType());
            modelAndView.addObject("productBrand",product.getBrand());
            modelAndView.addObject("productPrice",product.getPrice());
            modelAndView.addObject("productDescription",product.getDescription());
        }
        else
        {
            System.out.println("product not found.");
        }
        return modelAndView;
    }

    @RequestMapping("/productUpdateProcess/{id}")
    public ModelAndView userUpdateProcess(@PathVariable int id, @ModelAttribute Product product)
    {
        product.setId(id);
        productRepository.save(product);
        return productsReport();
    }

    public boolean stringEmptyReverseCheck(String string)
    {
        return !string.isEmpty();
    }

}
