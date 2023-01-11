package sg.edu.nuss.iss.app.workshoptodo.method;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import sg.edu.nuss.iss.app.workshoptodo.module.ToDo;

@Component("todomethod")
public class ToDoMethod {
    private static int todosCount = 0 ;
    private static List<ToDo> todolist = new ArrayList<>();
    static{
        todolist.add(new ToDo(++todosCount,"Buy Dinks",LocalDate.now(),false));
        todolist.add(new ToDo(++todosCount,"Buy Food",LocalDate.now(),false));
        todolist.add(new ToDo(++todosCount,"Buy Clothes",LocalDate.now(),false));
    }

    public void addTodo(String task, LocalDate taskdate, boolean completed) {
        ToDo todo = new ToDo(++todosCount, task, taskdate, completed);
        todolist.add(todo);
        
        // todolist.remove(todo);
    }

    public void getTodo(Model model){

        System.out.println(todolist);
        model.addAttribute("todo", todolist);
        

    }

    public ToDo findById(int Id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == Id;
        ToDo todo = todolist.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateToDo(ToDo todo){
        System.out.println("inside update to do ");
        deleteById(todo.getId());
        System.out.println(todolist.toArray());
        todolist.add(todo);
        System.out.println(todolist.toArray());
    }

    public void deleteById(int Id){
        //todo.getId() == id
        //todo -> todo.getId() ==Id
        Predicate<? super ToDo> predicate = todo -> todo.getId() == Id;
        todolist.removeIf(predicate);
    }
}
