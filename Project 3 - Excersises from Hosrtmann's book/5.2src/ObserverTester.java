import java.util.ArrayList;

public class ObserverTester
{
   public static void main(String[] args)
   {
      ArrayList<Double> data = new ArrayList<Double>();

      data.add(new Double(30.0));
      data.add(new Double(40.0));
      data.add(new Double(20.0));
      data.add(new Double(20.0));

      DataModel model = new DataModel(data);

      TextFrame frame = new TextFrame(model);

      BarFrame barFrame = new BarFrame(model);

      model.attach(barFrame);
      //just need to add this to compile everytyhing up
      model.attach(frame);
   }
}