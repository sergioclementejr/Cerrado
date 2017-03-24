package com.cerradoSic.control.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Aluno;
import com.cerradoSic.model.valueObjects.Usuario;

@Controller
public class TestController {
  
  @RequestMapping("/test")
  public ModelAndView test(@Valid Aluno aluno, BindingResult result){
    ModelAndView mv = new ModelAndView();
    if(result.hasFieldErrors()){
      System.out.println("Houve erro");
      mv.setViewName("../index");
    }else{
      System.out.println("Não houve erro");
      mv.setViewName("display");
      mv.addObject("result",aluno.toString());
    }
    
    return mv;
  }
  
  @RequestMapping("loginForm")
  public String loginForm() {
    return "login-form";
  }
  
  @RequestMapping("/efetuaLogin")
  public String efetuaLogin(Aluno aluno, HttpSession session){
    if(ModelFacade.getInstance().load(Aluno.class, aluno.getId())!=null){
      session.setAttribute("alunoLogado", aluno);
      return"menu";
    }else{
      return "redirect:loginForm";
    }
  }
}
