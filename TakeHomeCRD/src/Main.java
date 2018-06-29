import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);


    //Insert Holding Data
    public Holding insertHolding(){
        Holding hold = new Holding();
        int cont = 1;
        while(cont == 1){
            System.out.println("Enter stock name");
            String sec = sc.next();
            System.out.println("Enter stock amount");
            Double amt = sc.nextDouble();
            hold.hld.put(sec, amt);
            System.out.println("Enter 1 to continue ");
            cont = sc.nextInt();

        }
        return hold;
    }

    //Insert model data
    public Model insertModel(){
        Model m = new Model();
        int cont = 1;
        while (cont == 1){
            System.out.println("Enter stock name");
            String sec = sc.next();
            System.out.println("Enter stock percent");
            Double percent = sc.nextDouble();
            m.mdl.put(sec, percent);
            System.out.println("Enter 1 to continue ");
            cont = sc.nextInt();
        }

        return m;
    }

    //Calculates order based on required model
    public void executeOrder(Holding h, Model m){
        Map<String, Order> order=new HashMap<String, Order>();
        double total= totalHolding(h);

        System.out.println("Total holding amount is " + total);
        for(Map.Entry<String, Double> hold:h.hld.entrySet()){
            if(m.mdl.containsKey(hold.getKey())){
                double percent = m.mdl.get(hold.getKey());
                double val = (total * percent)/100;
                if(hold.getValue()>val){
                    order.put(hold.getKey(), new Order(hold.getKey(), 'S', hold.getValue()-val));
                }
                else {
                    order.put(hold.getKey(),new Order(hold.getKey(), 'B', val-hold.getValue()));
                }
            }
            else{
                order.put(hold.getKey(), new Order(hold.getKey(), 'S', hold.getValue()));
            }
        }

        for(Map.Entry<String, Double> model:m.mdl.entrySet()){
            if(!order.containsKey(model.getKey())){
                double val = (total * model.getValue())/100;
                order.put(model.getKey(), new Order(model.getKey(), 'B', val));
            }
        }

        printOrder(order, h, m);
    }

    //Print order
    public void printOrder(Map<String, Order> order, Holding holding, Model model){
        System.out.println();
        System.out.println("Holding Table");
        for(Map.Entry<String, Double> hold: holding.hld.entrySet()){
            System.out.println(hold.getKey() + " " + hold.getValue());
        }
        System.out.println();
        System.out.println("Model Table");
        for(Map.Entry<String, Double> mod: model.mdl.entrySet()){
            System.out.println(mod.getKey() + " " + mod.getValue());
        }
        System.out.println();
        System.out.println("Order Table");
        for(Map.Entry<String, Order> o:order.entrySet()){
            System.out.println(o.getValue().sec + " " + o.getValue().trans + " " + o.getValue().amt );
        }
    }

    //Calculate total holding value
    public double totalHolding(Holding h){
        double total = 0;
        for(Map.Entry<String, Double> hold:h.hld.entrySet()){
            total = total + hold.getValue();
        }
        return total;
    }


    //Inserted data for holding and model
    public void insertedData(Holding holding, Model model){
        holding.hld.put("IBM", 200.0);
        holding.hld.put("AAPL", 400.0);
        holding.hld.put("X", 50.0);
        holding.hld.put("CCC", 1000.0);
        holding.hld.put("GM", 500.0);

        model.mdl.put("GM", 20.0);
        model.mdl.put("F", 20.0);
        model.mdl.put("X", 10.0);
        model.mdl.put("Y", 50.0);
    }

    public static void main(String args[]){

        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to insert data manually or Enter 2 to use inserted data");
        int selection = sc.nextInt();

        if(selection == 1) {
            System.out.println("Enter holding data");
            Holding holding = main.insertHolding();
            System.out.println("Enter model data");
            Model model = main.insertModel();
            main.executeOrder(holding, model);
        }
        if(selection == 2) {
            Holding holding = new Holding();
            Model model = new Model();
            main.insertedData(holding, model);
            main.executeOrder(holding, model);
        }

    }
}
