import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BabyStoreMain {

    private static Map chart = new HashMap();

    public static void main(String[] args) {

        DataManagement dm = new DataManagement();

        ProductsBiz newBiz = dm.readAllData();

        menu(newBiz);

        dm.writeAllData(newBiz);

    }


    public static void menu(ProductsBiz biz) {
        System.out.println(" ");
        System.out.println("****** Welcome to the Star-light Baby Store ****** ");
        System.out.println(" ");
        System.out.println("Please choose one of the following options: ");
        System.out.println("1, Add up new products, ");
        System.out.println("2, Sell products. ");
        System.out.println("3, Search products.");
        System.out.println("4, Show all the products in the warehouse. ");
        System.out.println("5, Quit the system. ");

        menuOptions(biz);
    }


    public static void menuOptions(ProductsBiz biz) {

        Scanner s = new Scanner(System.in);
        String option = s.nextLine();
        switch (option) {
            case "1":
                biz.addProducts(biz);
                menu(biz);
                break;

            case "2":
                ProductsBiz.sellProducts(biz);
                menu(biz);
                break;

            case "3":
                ProductsBiz.searchType(biz);
                menu(biz);
                break;

            case "4":
                ProductsBiz.productsInWarehouse(biz);
                menu(biz);
                break;

            case "5":
                System.out.println("Thank you for your visit and welcome back! ");
                break;

        }
    }

}

