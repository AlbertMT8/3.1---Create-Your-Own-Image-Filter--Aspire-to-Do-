public class Main 
{
    /* Main method for testing */
  public static void main(String[] args) 
  {
    FilterPicture pic = new FilterPicture("pics/PA.jpg");
    pic.warmFilter();
    pic.write("output_pics/output.jpg");
    System.out.println("output.jpg written.");
  }
}
