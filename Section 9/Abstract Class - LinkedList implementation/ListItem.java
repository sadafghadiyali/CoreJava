public abstract class ListItem {
    // write code here
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
    protected Object value;
    
    public ListItem(Object value){
        this.value=value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem value);    
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem value);
    abstract int compareTo(ListItem item);
 
    public Object getValue(){
        return value;
    }
    public void setValue(Object object){
        this.value=object;
    }
    
    
}