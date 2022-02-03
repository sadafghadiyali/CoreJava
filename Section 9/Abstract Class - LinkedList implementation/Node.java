public class Node extends ListItem{
    // write code here
    public Node(Object object){
        super(object);
    }
    @Override
    ListItem next(){
        return this.rightLink; 
    }
    @Override
    ListItem setNext(ListItem value){
        this.rightLink = value;
        return this.rightLink;
    }
    @Override
    ListItem previous(){
        return this.leftLink;
    }
    @Override
    ListItem setPrevious(ListItem value){
        this.leftLink = value;
        return this.leftLink;
    }
    

    @Override
    int compareTo(ListItem item) {
        if(item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
    
}