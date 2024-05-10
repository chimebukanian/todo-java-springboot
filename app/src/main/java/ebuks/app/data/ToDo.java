package ebuks.app.data;

import org.springframework.data.annotation.Id;

public class ToDo {
    @Id
    private String id;
    private String title;
    private Boolean completed;

    public void ToDo(String title, Boolean completed){
        this.title=title;
        this.completed=completed;

    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public Boolean geCompleted(){
        return completed;
    }
    
}
