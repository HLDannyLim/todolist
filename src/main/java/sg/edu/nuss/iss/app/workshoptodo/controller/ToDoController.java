package sg.edu.nuss.iss.app.workshoptodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nuss.iss.app.workshoptodo.method.ToDoMethod;
import sg.edu.nuss.iss.app.workshoptodo.module.ToDo;

@Controller
@RequestMapping(path="/todo")
public class ToDoController {

    @Autowired
    ToDoMethod todomethod;

    @GetMapping(path="/list")
    public String showListToDoPage(Model model){
        // model.addAttribute("todo", new ToDo());
        System.out.println("tesing list--------------------------------------------");
        todomethod.getTodo(model);
        return "listtodo";
    }

    @GetMapping(path = "/add")
    public String showAddToDoPage(Model model){     
        System.out.println("tesing addget --------------------------------------------");
        model.addAttribute("todo", new ToDo());
        return "addtodo";
    }

    @PostMapping(path = "/add")
    public String postAddToDoPage(@ModelAttribute ToDo todo , Model model){
        System.out.println("tesing addpost--------------------------------------------");
        todomethod.addTodo(todo.getTask(),todo.getTaskdate(),todo.isCompleted());
        todomethod.getTodo(model);
        return "listtodo";
        // return "listtodo";
    }

    @GetMapping(path = "/update")
    public String getUpdatePage(@RequestParam int id , Model model){
        System.out.println("tesing getupdate--------------------------------------------");
        ToDo todo = todomethod.findById(id);
        model.addAttribute("todo", todo);
        return "addtodo";
    }

    // i need helpppp !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @PostMapping(path= "/update") 
    public String postUpdatePage(Model model, @ModelAttribute ToDo todo){
        System.out.println("tesing postupdate--------------------------------------------");
        todomethod.updateToDo(todo);
        todomethod.getTodo(model);
        return "listtodo";
        // return "redirect:/list";
    }

    @GetMapping(path = "/delete")
    public String deleteTodo(@RequestParam int id){
        todomethod.deleteById(id);
        return "redirect:list";
    }

}
