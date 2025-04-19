package CreationDesigns;

import java.util.List;

/*Avoid repetitive expensive initialization (e.g., database calls, complex computations).
        ✔ When object creation is costlier than copying.
        ✔ Need to hide object creation complexity from the client.*/
public class ClonableDesign implements Cloneable {

    private String title;
    private List<String> authors;

    public ClonableDesign(String title, List<String> authors){
        this.title = title;
        this.authors = authors;
    }

    //Shallow copy ,
    @Override
    public ClonableDesign clone() {
        try {
            return (ClonableDesign) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
/*

    //Deep copy ,
    @Override
    public CreationDesigns.ClonableDesign clone() throws CloneNotSupportedException {
        CreationDesigns.ClonableDesign clonableDesign = (CreationDesigns.ClonableDesign) super.clone();
        clonableDesign.authors = new ArrayList<>(this.authors);
        return clonableDesign;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
