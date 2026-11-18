class AddArray {
    
    public void arrAdd(){
        int arr[] = {30, 42, 12, 93, 53, 73, 25};
        int item = 0;
        for(int i = 0; i <arr.length; i++){
            item = item + arr[i];
        }
        System.out.print("Add of the Array: " + item);
    }
    
    public static void main(String[] args) {
        AddArray ar = new AddArray();
        ar.arrAdd();
    }
}